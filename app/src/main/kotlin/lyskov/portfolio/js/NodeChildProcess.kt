@file:JsModule("child_process")
@file:JsNonModule
@file:Suppress("unused")

package lyskov.portfolio.js

external fun spawn(command: String, args: Array<String>, options: dynamic): ChildProcess

external class ChildProcess {
    val stdout: dynamic
    val stderr: dynamic
    fun on(event: String, listener: (code: Int?) -> Unit)
}
