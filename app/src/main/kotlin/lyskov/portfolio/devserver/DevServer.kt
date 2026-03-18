package lyskov.portfolio.devserver

import lyskov.portfolio.js.ChildProcess
import lyskov.portfolio.js.IncomingMessage
import lyskov.portfolio.js.R_OK
import lyskov.portfolio.js.ServerResponse
import lyskov.portfolio.js.access
import lyskov.portfolio.js.createServer
import lyskov.portfolio.js.extname
import lyskov.portfolio.js.join
import lyskov.portfolio.js.readFile
import lyskov.portfolio.js.spawn
import lyskov.portfolio.js.watch

object DevServer {

    private val clients = mutableListOf<ServerResponse>()

    private var rebuilding = false
    private var pendingRebuild = false

    private val mime = mapOf(
        ".html" to "text/html; charset=utf-8",
        ".css"  to "text/css",
        ".js"   to "application/javascript",
        ".svg"  to "image/svg+xml",
        ".png"  to "image/png",
        ".jpg"  to "image/jpeg",
        ".gif"  to "image/gif",
        ".ico"  to "image/x-icon",
        ".webp" to "image/webp",
    )

    private val reloadScript =
        """<script>const _es=new EventSource("/__reload");_es.onmessage=()=>location.reload();</script>"""

    fun start(siteDir: String, srcDir: String, gradlewPath: String, rootDir: String) {
        watchSources(srcDir, gradlewPath, rootDir)
        startHttpServer(siteDir)
    }

    private fun watchSources(srcDir: String, gradlewPath: String, rootDir: String) {
        val opts = js("({ recursive: true })")
        watch(srcDir, opts) { _, filename ->
            if (filename != null && (filename.endsWith(".kt") || filename.endsWith(".json"))) {
                rebuild(gradlewPath, rootDir)
            }
        }
    }

    private fun rebuild(gradlewPath: String, rootDir: String) {
        if (rebuilding) { pendingRebuild = true; return }
        rebuilding = true
        pendingRebuild = false
        println("↻  Rebuilding...")

        val opts = js("({})")
        opts.cwd = rootDir
        opts.stdio = arrayOf("ignore", "pipe", "pipe")
        val proc: ChildProcess = spawn(
            gradlewPath,
            arrayOf(":app:generateSite", "--no-daemon"),
            opts,
        )
        proc.stdout.on("data", { d: dynamic -> nodeProcess.stdout.write(d.toString()) })
        proc.stderr.on("data", { d: dynamic -> nodeProcess.stderr.write(d.toString()) })
        proc.on("close") { code ->
            rebuilding = false
            if (code == 0) {
                println("✓  Done — reloading browser")
                broadcast()
            } else {
                nodeProcess.stderr.write("✗  Build failed (exit $code)\n")
            }
            if (pendingRebuild) rebuild(gradlewPath, rootDir)
        }
    }

    private fun broadcast() {
        for (res in clients) res.write("data: reload\n\n")
    }

    private fun startHttpServer(siteDir: String) {
        val server = createServer { req, res -> handleRequest(req, res, siteDir) }
        server.listen(3000) {
            println("\n  Dev server:  http://localhost:3000\n")
        }
    }

    private fun handleRequest(req: IncomingMessage, res: ServerResponse, siteDir: String) {
        val url = req.url ?: "/"

        if (url == "/__reload") {
            val headers = js("({})")
            headers["Content-Type"] = "text/event-stream"
            headers["Cache-Control"] = "no-cache"
            headers["Connection"] = "keep-alive"
            res.writeHead(200, headers)
            res.write(":\n\n")
            clients.add(res)
            req.on("close") { clients.remove(res) }
            return
        }

        val rawPath = url.split("?")[0]
        val urlPath = if (rawPath.endsWith("/")) "${rawPath}index.html" else rawPath
        val filePath = join(siteDir, urlPath)

        access(filePath, R_OK) { err ->
            if (err != null) {
                serveFile(join(siteDir, "404.html"), res, 404)
            } else {
                serveFile(filePath, res, 200)
            }
        }
    }

    private fun serveFile(filePath: String, res: ServerResponse, status: Int) {
        val ext = extname(filePath)
        val contentType = mime[ext] ?: "application/octet-stream"
        if (ext == ".html") {
            readFile(filePath, "utf8") { err, text ->
                if (err != null) { res.writeHead(500); res.end(); return@readFile }
                val headers = js("({})")
                headers["Content-Type"] = contentType
                res.writeHead(status, headers)
                res.end(text.replace("</body>", "$reloadScript</body>"))
            }
        } else {
            readFile(filePath) { err, data ->
                if (err != null) { res.writeHead(500); res.end(); return@readFile }
                val headers = js("({})")
                headers["Content-Type"] = contentType
                res.writeHead(status, headers)
                res.end(data)
            }
        }
    }
}

// Node.js process global
@JsName("process")
private external val nodeProcess: dynamic
