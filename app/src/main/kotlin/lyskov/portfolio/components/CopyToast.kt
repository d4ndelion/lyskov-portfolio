package lyskov.portfolio.components

import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.span

fun FlowContent.copyToast(message: String = "Почта скопирована") {
    div(classes = "copy-toast") {
        attributes["id"] = "copy-toast"
        img(src = "/vector/toast-icon.svg", alt = "", classes = "copy-toast__icon")
        span(classes = "copy-toast__text") { +message }
    }
}
