package lyskov.portfolio.components

import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.script
import kotlinx.html.unsafe
import lyskov.portfolio.model.Case
import lyskov.portfolio.model.CaseSection

fun FlowContent.imageBlock(case: Case) {
    val bg = if (case.backgroundImage.isNotEmpty())
        "background: url('${case.backgroundImage}') center/cover no-repeat, linear-gradient(180deg, ${case.color} 0%, ${case.colorEnd} 100%);"
    else
        "background: linear-gradient(180deg, ${case.color} 0%, ${case.colorEnd} 100%);"
    val sizeStyle = "width: 1360px; height: 800px;"
    val mobileImageClass = if (case.isMobileCase) "mobile-image" else "web-image"
    div {
        div(classes = "case-img-block $mobileImageClass") {
            attributes["style"] = bg + sizeStyle
            if (case.covers.isNotEmpty()) {
                img(src = case.covers.first(), alt = "", classes = "case-img-block__img")
            }
            if (case.covers.size > 1) {
                val srcsJs = case.covers.joinToString(",") { "\"$it\"" }
                script {
                    unsafe {
                        raw(
                            """
                        (function(el){
                          var srcs=[$srcsJs];
                          var img=el.querySelector('.case-img-block__img');
                          var cur=0;
                          setInterval(function(){
                            cur=(cur+1)%srcs.length;
                            img.src=srcs[cur];
                          },${case.slideInterval});
                        })(document.currentScript.parentElement);
                        """.trimIndent()
                        )
                    }
                }
            }
        }
    }
}

fun FlowContent.imageBlock(block: CaseSection.ImageBlock) {
    val bgStyle = if (block.accent.isNotEmpty())
        "background: linear-gradient(180deg, var(--c-card) 0%, ${block.accent}1F 100%);"
    else
        "background: var(--c-card);"
    val sizeStyle = "width: 1360px; height: 800px;"
    val mobileImageClass = if (block.isMobileCase) "mobile-image" else "web-image"

    if (block.placeholders.isNotEmpty()) {
        div(classes = "case-img-block case-img-block--placeholder") {
            attributes["style"] = bgStyle
            block.placeholders.forEach { w ->
                div(classes = "case-img-block__ph-row") {
                    attributes["style"] = "width: $w;"
                }
            }
        }
    } else {
        val paddingClass = if (!block.innerPadding) "no-padding" else ""
        div {
            div(classes = "case-img-block $mobileImageClass $paddingClass") {
                attributes["style"] = bgStyle
                if (block.image.isNotEmpty()) {
                    img(src = block.image, alt = "", classes = "case-img-block__img")
                } else {
                    div {
                        attributes["style"] = sizeStyle
                    }
                }
            }
            if (!block.description.isNullOrEmpty()) {
                p(classes = "case-img-description") {
                    +block.description
                }
            }
        }
    }
}
