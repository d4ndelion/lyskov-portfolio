package lyskov.portfolio.layout

import kotlinx.css.Align
import kotlinx.css.Color
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.FlexWrap
import kotlinx.css.FontWeight
import kotlinx.css.JustifyContent
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.Position
import kotlinx.css.alignContent
import kotlinx.css.alignItems
import kotlinx.css.aspectRatio
import kotlinx.css.background
import kotlinx.css.backgroundColor
import kotlinx.css.borderRadius
import kotlinx.css.boxShadow
import kotlinx.css.color
import kotlinx.css.display
import kotlinx.css.em
import kotlinx.css.flexDirection
import kotlinx.css.flexWrap
import kotlinx.css.fontSize
import kotlinx.css.fontWeight
import kotlinx.css.gap
import kotlinx.css.height
import kotlinx.css.justifyContent
import kotlinx.css.letterSpacing
import kotlinx.css.lineHeight
import kotlinx.css.margin
import kotlinx.css.opacity
import kotlinx.css.padding
import kotlinx.css.position
import kotlinx.css.properties.AspectRatio
import kotlinx.css.properties.BoxShadow
import kotlinx.css.properties.lh
import kotlinx.css.px
import kotlinx.css.width

internal fun buildCaseCss(): String = CssBuilder().apply {

    // ── Header: avatar + breadcrumb ────────────────────────────────────────
    rule(".site-header__avatar") {
        put("width", "40px")
        put("height", "40px")
        put("border-radius", "100px")
        put("object-fit", "cover")
        put("flex-shrink", "0")
    }

    rule(".site-header__breadcrumb") {
        put("display", "flex")
        put("align-items", "center")
        put("gap", "4px")
    }

    rule(".site-header__chevron") {
        put("width", "24px")
        put("height", "24px")
        put("flex-shrink", "0")
        put("opacity", "0.4")
    }

    rule(".site-header__breadcrumb-text") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("color", "var(--c-ink)")
        put("opacity", "0.6")
        put("white-space", "nowrap")
    }

    // ── Case page layout ───────────────────────────────────────────────────
    rule(".case-page") {
        put("display", "flex")
        put("flex-direction", "column")
        put("align-items", "center")
    }

    rule(".case-page__body") {
        gap = 60.px
        put("display", "flex")
        put("flex-direction", "column")
        put("width", "100%")
        put("max-width", "var(--content-w)")
        put("padding", "40px var(--page-pad)")
    }

    // ── Case head info ─────────────────────────────────────────────────────
    rule(".case-head-info") {
        put("display", "flex")
        put("flex-direction", "column")
        put("gap", "24px")
    }

    rule(".case-tags") {
        put("display", "flex")
        put("flex-wrap", "wrap")
        put("gap", "8px")
    }

    rule(".case-title") {
        put("font-size", "36px")
        put("font-weight", "500")
        put("line-height", "44px")
        put("color", "var(--c-ink)")
        put("max-width", "720px")
    }

    rule(".case-desc") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("color", "var(--c-ink)")
        put("max-width", "800px")
    }

    rule(".case-links-row") {
        put("display", "flex")
        put("flex-wrap", "wrap")
        put("gap", "12px")
    }

    rule(".case-warning") {
        fontSize = 20.px
        put("line-height", "28px")
        put("color", "var(--c-ink-40)")
    }

    // ── External link card ─────────────────────────────────────────────────
    rule(".case-ext-link") {
        put("display", "inline-flex")
        put("align-items", "center")
        put("gap", "12px")
        put("padding", "16px 20px 16px 16px")
        put("border", "1.5px solid var(--c-ink-12)")
        put("border-radius", "24px")
        put("color", "var(--c-ink)")
        put("text-decoration", "none")
        put("transition", "border-color 0.15s ease, background 0.15s ease")
        put("cursor", "pointer")
    }

    rule(".case-ext-link:hover") {
        put("border-color", "var(--c-ink)")
    }

    rule(".case-ext-link__info") {
        put("display", "flex")
        put("align-items", "center")
        put("gap", "12px")
    }

    rule(".case-ext-link__icon") {
        put("width", "24px")
        put("height", "24px")
        put("flex-shrink", "0")
    }

    rule(".case-ext-link__label") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("white-space", "nowrap")
    }

    rule(".case-ext-link__arrow") {
        put("width", "12px")
        put("height", "12px")
        put("flex-shrink", "0")
    }

    rule(".case-back-link") {
        put("align-self", "flex-start")
    }

    // ── Image block ────────────────────────────────────────────────────────
    rule(".case-img-block") {
        put("width", "100%")
        put("min-height", "400px")
        put("border-radius", "40px")
        put("overflow", "hidden")
        put("display", "flex")
        put("align-items", "center")
        put("justify-content", "center")
        put("position", "relative")
        padding = Padding(60.px)
    }

    rule(".case-img-block__img") {
        put("width", "100%")
        put("height", "100%")
        put("object-fit", "cover")
        put("border-radius", "12px")
    }

    rule(".case-img-description") {
        margin = Margin(top = 24.px)
        opacity = .6
        width = 800.px
        fontSize = 20.px
        lineHeight = 28.px.lh
        color = Color("#071B31")
        fontWeight = FontWeight.normal
    }

    rule(".case-img-block--placeholder") {
        put("flex-direction", "column")
        put("align-items", "stretch")
        put("justify-content", "flex-start")
        put("gap", "24px")
        put("padding", "40px")
    }

    rule(".case-img-block__ph-row") {
        put("height", "204px")
        put("background", "rgba(7, 27, 49, 0.06)")
        put("border-radius", "12px")
        put("flex-shrink", "0")
    }

    // ── Text section ───────────────────────────────────────────────────────
    rule(".case-text-section") {
        put("display", "flex")
        put("flex-direction", "column")
        put("gap", "24px")
    }

    rule(".case-section-heading") {
        put("font-size", "36px")
        put("font-weight", "500")
        put("line-height", "44px")
        put("color", "var(--c-ink)")
        put("max-width", "720px")
        put("scroll-margin-top", "calc(var(--header-h) + 24px)")
    }

    rule(".case-heading-icon") {
        margin = Margin(horizontal = 22.px)
        put("display", "inline-block")
        put("width", "16px")
        put("height", "16px")
        put("vertical-align", "middle")
        put("position", "relative")
        put("top", "-1px")
    }

    rule(".case-para") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("color", "var(--c-ink)")
        put("max-width", "800px")
        put("white-space", "pre-line")
    }

    rule(".case-para--muted") {
        put("opacity", "0.72")
    }

    rule(".text-highlight") {
        put("display", "inline")
        put("padding", "0 6px")
    }

    // ── Ordered list ───────────────────────────────────────────────────────
    rule(".case-list") {
        put("display", "flex")
        put("flex-direction", "column")
        put("gap", "0")
        put("padding-left", "28px")
    }

    rule(".case-list__item") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
    }

    rule(".case-list--ul") {
        put("list-style-type", "disc")
    }

    // ── Step list ──────────────────────────────────────────────────────────
    rule(".case-steps") {
        put("display", "flex")
        put("flex-direction", "column")
        put("gap", "12px")
    }

    rule(".case-step") {
        put("display", "inline-flex")
        put("align-items", "center")
        put("justify-content", "space-between")
        put("gap", "12px")
        put("padding", "16px 20px 16px 16px")
        put("border", "1.5px solid var(--c-ink-12)")
        put("border-radius", "24px")
        put("max-width", "500px")
        put("text-decoration", "none")
        put("transition", "border-color 0.15s, background 0.15s")
    }

    rule("a.case-step:hover") {
        put("border-color", "var(--c-ink)")
    }

    rule(".case-step__label") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("color", "var(--c-ink)")
        put("white-space", "nowrap")
    }

    rule(".case-step__arrow") {
        put("width", "12px")
        put("height", "12px")
        put("flex-shrink", "0")
    }

    // ── Card grid (story/job cards) ────────────────────────────────────────

    rule(".card-grid-wrap") {
        put("display", "flex")
        gap = 24.px
        put("flex-direction", "column")
        put("padding", "40px")
        put("border-radius", "40px")
        put("background", "var(--c-card)")
    }

    rule(".card-grid") {
        display = Display.flex
        alignContent = Align.center
        justifyContent = JustifyContent.center
        flexWrap = FlexWrap.wrap
        gap = 24.px
        background = "var(--c-card)"
    }

    rule(".story-card") {
        height = 204.px
        width = 204.px
        aspectRatio = AspectRatio(1, 1)
        display = Display.flex
        flexDirection = FlexDirection.column
        justifyContent = JustifyContent.spaceBetween
        boxShadow += BoxShadow(Color.black.changeAlpha(.2), 0.px, 0.px, 10.px, 0.px)
        padding = Padding(16.px)
    }

    rule(".story-card__text") {
        put("font-family", "'Inter', system-ui, -apple-system, sans-serif")
        put("font-size", "14px")
        put("line-height", "20px")
        put("color", "rgba(7, 27, 49, 0.90)")
        letterSpacing = (-0.2).px
    }

    rule(".story-card__author") {
        put("font-size", "13px")
        put("font-weight", "500")
        put("line-height", "18px")
        put("color", "rgba(7, 27, 49, 0.55)")
        put("margin-top", "auto")
    }

    rule(".story-card__ordinal") {
        position = Position.absolute
        margin = Margin(162.px)
        display = Display.flex
        alignItems = Align.center
        justifyContent = JustifyContent.center
        backgroundColor = Color.white
        borderRadius = 1.em
        width = 32.px
        height = 32.px
    }

    rule(".story-card__bottom") {
        display = Display.flex
        justifyContent = JustifyContent.spaceBetween
    }

}.toString()
