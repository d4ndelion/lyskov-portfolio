@file:JsModule("path")
@file:JsNonModule
@file:Suppress("unused")

package lyskov.portfolio.js

external fun join(vararg parts: String): String
external fun extname(path: String): String
