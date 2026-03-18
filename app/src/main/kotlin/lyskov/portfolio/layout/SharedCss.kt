package lyskov.portfolio.layout

import kotlinx.css.CssBuilder
import kotlinx.css.Padding
import kotlinx.css.padding
import kotlinx.css.px

internal fun buildSharedCss(): String = CssBuilder().apply {

    // ── Reset ─────────────────────────────────────────────────────────────
    rule("*, *::before, *::after") {
        put("box-sizing", "border-box")
        put("margin", "0")
        put("padding", "0")
    }

    // ── Design tokens ──────────────────────────────────────────────────────
    rule(":root") {
        put("--c-bg", "#ffffff")
        put("--c-ink", "#071b31")
        put("--c-ink-72", "rgba(7, 27, 49, 0.72)")
        put("--c-ink-60", "rgba(7, 27, 49, 0.60)")
        put("--c-ink-40", "rgba(7, 27, 49, 0.40)")
        put("--c-ink-24", "rgba(7, 27, 49, 0.24)")
        put("--c-ink-12", "rgba(7, 27, 49, 0.12)")
        put("--c-accent", "#d8edfa")
        put("--c-card", "#e8ebed")
        put("--c-photo-bg", "#ededed")
        put("--c-tag-bg", "rgba(255, 255, 255, 0.60)")
        put("--font", "'Onest', system-ui, -apple-system, sans-serif")
        put("--header-h", "80px")
        put("--page-pad", "40px")
        put("--content-w", "1360px")
        put("--gap-section", "20px")
        put("--folder-tab-h", "34px")
    }

    // ── Base ───────────────────────────────────────────────────────────────
    rule("html") {
        put("scroll-behavior", "smooth")
        put("-webkit-text-size-adjust", "100%")
    }

    rule("body") {
        put("font-family", "var(--font)")
        put("background-color", "var(--c-bg)")
        put("color", "var(--c-ink)")
        put("display", "flex")
        put("flex-direction", "column")
        put("min-height", "100vh")
    }

    rule("img, svg") {
        put("display", "block")
        put("max-width", "100%")
    }

    rule("a") {
        put("color", "inherit")
        put("text-decoration", "none")
    }

    // ── Accessibility ──────────────────────────────────────────────────────
    rule(".skip-link") {
        put("position", "absolute")
        put("left", "-9999px")
        put("top", "auto")
        put("width", "1px")
        put("height", "1px")
        put("overflow", "hidden")
    }

    rule(".skip-link:focus") {
        put("left", "0")
        put("top", "0")
        put("width", "auto")
        put("height", "auto")
        put("overflow", "visible")
        put("padding", "4px 12px")
        put("background", "var(--c-ink)")
        put("color", "#fff")
        put("z-index", "9999")
        put("outline", "none")
    }

    rule(":focus-visible") {
        put("outline", "2px solid var(--c-ink)")
        put("outline-offset", "2px")
    }

    // ── Layout shell ───────────────────────────────────────────────────────
    rule(".site-main") {
        put("flex", "1")
        put("display", "flex")
        put("flex-direction", "column")
        put("gap", "var(--gap-section)")
    }

    // ── Header ─────────────────────────────────────────────────────────────
    rule(".site-header") {
        put("position", "sticky")
        put("top", "0")
        put("z-index", "100")
        put("height", "var(--header-h)")
        put("padding", "24px var(--page-pad) 0")
        put("overflow", "hidden")
        put("backdrop-filter", "blur(6px)")
        put("background", "linear-gradient(to left, rgba(255, 255, 255, 1) 0%, rgba(255, 255, 255, 0) 100%)")
        put("-webkit-backdrop-filter", "blur(6px)")
    }

    rule(".site-header__body") {
        put("display", "flex")
        put("align-items", "center")
        put("justify-content", "space-between")
        put("height", "100%")
    }

    rule(".site-header__left") {
        put("display", "flex")
        put("align-items", "center")
        put("gap", "12px")
    }

    rule(".site-header__logo") {
        put("width", "18px")
        put("height", "18px")
        put("flex-shrink", "0")
    }

    rule(".site-header__location") {
        put("display", "flex")
        put("align-items", "center")
        put("gap", "8px")
    }

    rule(".site-header__divider") {
        put("display", "flex")
        put("align-items", "center")
        put("justify-content", "center")
        put("width", "28px")
        put("align-self", "stretch")
    }

    rule(".site-header__divider img") {
        put("width", "10px")
        put("height", "10px")
    }

    rule(".site-header__city") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("white-space", "nowrap")
    }

    rule(".site-header__right") {
        put("display", "flex")
        put("align-items", "center")
        put("gap", "12px")
    }

    rule(".site-header__icon-group") {
        put("display", "flex")
        put("align-items", "center")
    }

    rule(".site-header__icon-btn") {
        put("display", "flex")
        put("align-items", "center")
        put("justify-content", "center")
        put("width", "48px")
        put("height", "48px")
        put("flex-shrink", "0")
        put("transition", "opacity 0.15s ease")
    }

    rule(".site-header__icon-btn:hover") {
        put("opacity", "0.6")
    }

    rule(".site-header__icon-btn img") {
        put("width", "24px")
        put("height", "24px")
    }

    rule(".site-header__icon-btn--max img") {
        put("width", "22px")
        put("height", "22px")
    }

    rule(".site-header__sep") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("opacity", "0.24")
    }

    rule(".site-header__links") {
        put("display", "flex")
        put("align-items", "center")
        put("gap", "4px")
    }

    rule(".site-header__link") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("padding", "0 8px")
        put("text-decoration", "underline")
        put("text-underline-offset", "3px")
        put("transition", "opacity 0.15s ease")
    }

    rule(".site-header__link:hover") {
        put("opacity", "0.6")
    }

    // ── Footer ─────────────────────────────────────────────────────────────
    rule(".site-footer") {
        put("padding", "0 var(--page-pad) 16px")
        put("overflow", "hidden")
        put("backdrop-filter", "blur(6px)")
        put("-webkit-backdrop-filter", "blur(6px)")
    }

    rule(".site-footer__body") {
        put("height", "48px")
        put("display", "flex")
        put("align-items", "center")
        put("justify-content", "center")
    }

    rule(".site-footer__copy") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("color", "var(--c-ink-40)")
        put("white-space", "nowrap")
    }

    // ── Shared section shell ───────────────────────────────────────────────
    rule(".pg-section") {
        put("background", "var(--c-bg)")
        put("display", "flex")
        put("flex-direction", "column")
        put("align-items", "center")
        put("overflow", "clip")
        put("padding", "var(--page-pad)")
    }

    rule(".pg-section--about") {
        put("padding-top", "80px")
        put("padding-bottom", "80px")
    }

    rule(".pg-section--goodbye") {
        put("padding-top", "80px")
        put("padding-bottom", "200px")
    }

    rule(".pg-section__body") {
        put("max-width", "var(--content-w)")
        put("width", "100%")
    }

    // ── Tag pill ───────────────────────────────────────────────────────────
    rule(".tag") {
        put("background", "var(--c-tag-bg)")
        put("height", "40px")
        put("display", "inline-flex")
        put("align-items", "center")
        put("justify-content", "center")
        put("padding", "0 16px")
        put("border-radius", "1000px")
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("white-space", "nowrap")
        put("flex-shrink", "0")
    }

    rule(".tag--muted") {
        put("color", "var(--c-ink-60)")
    }

    rule(".tag-row") {
        put("display", "flex")
        put("flex-wrap", "wrap")
        put("gap", "8px")
    }

    // ── Goodbye ────────────────────────────────────────────────────────────
    rule(".goodbye-body") {
        put("display", "flex")
        put("flex-direction", "column")
        put("gap", "40px")
        put("align-items", "center")
        put("max-width", "var(--content-w)")
        put("width", "100%")
    }

    rule(".goodbye-gif") {
        put("transform", "rotate(-2deg)")
        put("width", "286px")
        put("height", "200px")
        put("border-radius", "24px")
        put("overflow", "hidden")
        put("position", "relative")
        put("background", "var(--c-photo-bg)")
        put("flex-shrink", "0")
    }

    rule(".goodbye-gif img") {
        put("position", "absolute")
        put("width", "105%")
        put("height", "191%")
        put("top", "-3%")
        put("left", "-4%")
        put("max-width", "none")
        put("object-fit", "cover")
    }

    rule(".goodbye-text") {
        put("display", "flex")
        put("flex-direction", "column")
        put("gap", "12px")
        put("align-items", "center")
        put("font-weight", "500")
        put("text-align", "center")
    }

    rule(".goodbye-text__heading") {
        put("font-size", "36px")
        put("line-height", "44px")
        put("white-space", "nowrap")
    }

    rule(".goodbye-text__sub") {
        put("font-size", "20px")
        put("line-height", "28px")
        put("opacity", "0.9")
        put("width", "720px")
    }

    rule(".goodbye-contacts") {
        put("display", "flex")
        put("flex-direction", "column")
        put("gap", "12px")
        put("align-items", "center")
        put("width", "fit-content")
        put("max-width", "100%")
    }

    rule(".goodbye-btn-row") {
        put("display", "flex")
        put("gap", "12px")
        put("align-items", "center")
        put("justify-content", "center")
        put("width", "100%")
    }

    rule(".btn-write") {
        put("display", "inline-flex")
        put("align-items", "center")
        put("gap", "12px")
        put("height", "48px")
        put("padding", "0 20px 0 16px")
        put("border-radius", "24px")
        put("background", "var(--c-ink)")
        put("color", "#fff")
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("white-space", "nowrap")
        put("flex-shrink", "0")
        put("cursor", "pointer")
        put("text-decoration", "none")
        put("transition", "opacity 0.15s ease")
    }

    rule(".btn-write:hover") {
        put("opacity", "0.75")
    }

    rule(".btn-write img") {
        put("width", "24px")
        put("height", "24px")
        put("flex-shrink", "0")
    }

    rule(".icon-btn") {
        put("display", "flex")
        put("align-items", "center")
        put("justify-content", "center")
        put("width", "48px")
        put("height", "48px")
        put("flex-shrink", "0")
        put("transition", "opacity 0.15s ease")
    }

    rule(".icon-btn:hover") {
        put("opacity", "0.6")
    }

    rule(".icon-btn img") {
        put("width", "22px")
        put("height", "22px")
    }

    rule(".icon-btn--linkedin img") {
        put("width", "24px")
        put("height", "24px")
    }

    rule(".goodbye-email") {
        put("display", "flex")
        put("align-items", "center")
        put("justify-content", "center")
        put("gap", "10px")
        put("height", "48px")
        put("padding", "0 20px")
        put("border", "1.5px solid var(--c-ink-12)")
        put("border-radius", "24px")
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("white-space", "nowrap")
        put("width", "100%")
        put("transition", "border-color 0.15s ease")
    }

    rule(".goodbye-email:hover") {
        put("border-color", "var(--c-ink)")
    }

    rule(".goodbye-email__icon") {
        put("display", "block")
        put("width", "24px")
        put("height", "24px")
        put("flex-shrink", "0")
        put("background-color", "#9CA4AD")
        put("-webkit-mask-image", "url('/vector/copy-icon.svg')")
        put("mask-image", "url('/vector/copy-icon.svg')")
        put("mask-size", "contain")
        put("mask-repeat", "no-repeat")
        put("mask-position", "center")
        put("transition", "background-color 0.15s ease")
    }

    rule(".goodbye-email:hover .goodbye-email__icon") {
        put("background-color", "var(--c-ink)")
    }

    // ── Copy toast ─────────────────────────────────────────────────────────
    rule(".copy-toast") {
        padding = Padding(16.px, 20.px)
        put("position", "fixed")
        put("top", "100px")
        put("right", "24px")
        put("display", "flex")
        put("align-items", "center")
        put("gap", "16px")
        put("background", "#ffffff")
        put("border", "1.5px solid var(--c-ink-12)")
        put("border-radius", "24px")
        put("z-index", "9999")
        put("opacity", "0")
        put("transform", "translateY(-12px)")
        put("transition", "opacity 0.2s ease, transform 0.2s ease")
        put("pointer-events", "none")
    }

    rule(".copy-toast--visible") {
        put("opacity", "1")
        put("transform", "translateY(0)")
        put("pointer-events", "auto")
    }

    rule(".copy-toast__icon") {
        put("width", "28px")
        put("height", "28px")
        put("flex-shrink", "0")
    }

    rule(".copy-toast__text") {
        put("font-family", "var(--font)")
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("color", "var(--c-ink)")
        put("white-space", "nowrap")
    }

    // ── 404 page ───────────────────────────────────────────────────────────
    rule(".error-page") {
        put("display", "flex")
        put("flex-direction", "column")
        put("align-items", "center")
        put("justify-content", "center")
        put("text-align", "center")
        put("gap", "1rem")
        put("min-height", "40vh")
        put("padding", "40px")
    }

    rule(".error-page__code") {
        put("font-size", "clamp(4rem, 12vw, 8rem)")
        put("font-weight", "800")
        put("line-height", "1")
        put("opacity", "0.12")
    }

    rule(".error-page__title") {
        put("font-size", "36px")
        put("font-weight", "500")
        put("line-height", "44px")
    }

    rule(".error-page__link") {
        put("font-size", "20px")
        put("font-weight", "500")
        put("line-height", "28px")
        put("text-decoration", "underline")
        put("text-underline-offset", "3px")
        put("color", "var(--c-ink)")
        put("transition", "opacity 0.15s ease")
    }

    rule(".error-page__link:hover") {
        put("opacity", "0.6")
    }

}.toString()
