@file:JsModule("fs")
@file:JsNonModule
@file:Suppress("unused")

package lyskov.portfolio.js

// ─── Sync reads/writes (used by SiteGenerator) ────────────────────────────────

external fun readFileSync(path: String, encoding: String): String
external fun readFileSync(path: String): dynamic   // binary → Buffer
external fun writeFileSync(path: String, data: String): Unit
external fun writeFileSync(path: String, data: dynamic): Unit  // Buffer copy
external fun mkdirSync(path: String, options: dynamic = definedExternally): Unit
external fun existsSync(path: String): Boolean
external fun readdirSync(path: String): Array<String>
external fun statSync(path: String): dynamic

// ─── Async (used by DevServer) ────────────────────────────────────────────────

/** Async file read — returns Buffer in callback. */
external fun readFile(path: String, callback: (err: dynamic, data: dynamic) -> Unit): Unit

/** Async file read with encoding — returns String in callback. */
external fun readFile(path: String, encoding: String, callback: (err: dynamic, data: String) -> Unit): Unit

/** Checks file accessibility. Pass [R_OK] for read access. */
external fun access(path: String, mode: Int, callback: (err: dynamic) -> Unit): Unit

/** Watch a directory recursively. Returns an FSWatcher. */
external fun watch(
    path: String,
    options: dynamic,
    listener: (eventType: String, filename: String?) -> Unit,
): dynamic

