@file:JsModule("http")
@file:JsNonModule
@file:Suppress("unused")

package lyskov.portfolio.js

external fun createServer(handler: (req: IncomingMessage, res: ServerResponse) -> Unit): HttpServer

external class HttpServer {
    fun listen(port: Int, callback: () -> Unit)
}

external class IncomingMessage {
    val url: String?
    fun on(event: String, listener: () -> Unit)
}

external class ServerResponse {
    fun writeHead(status: Int)
    fun writeHead(status: Int, headers: dynamic)
    fun write(chunk: String)
    fun end()
    fun end(data: dynamic)
}
