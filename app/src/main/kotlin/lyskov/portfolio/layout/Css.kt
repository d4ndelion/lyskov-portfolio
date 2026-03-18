package lyskov.portfolio.layout

import kotlinx.css.CssBuilder

object Css {

    val STYLESHEET: String by lazy { buildStylesheet() }

    @Suppress("LongMethod")
    private fun buildStylesheet(): String = CssBuilder().apply {

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

        // ── Sub-header badge ───────────────────────────────────────────────────
        rule(".sub-badge") {
            put("display", "inline-flex")
            put("align-items", "center")
            put("justify-content", "center")
            put("padding", "0 8px")
            put("background", "var(--c-accent)")
            put("font-size", "20px")
            put("font-weight", "500")
            put("line-height", "28px")
            put("white-space", "nowrap")
        }

        // ── Section heading ────────────────────────────────────────────────────
        rule(".section-heading") {
            put("font-size", "36px")
            put("font-weight", "400")
            put("line-height", "44px")
            put("text-align", "center")
            put("width", "720px")
        }

        // ── Hero ───────────────────────────────────────────────────────────────
        rule(".hero__body") {
            put("display", "flex")
            put("flex-direction", "column")
            put("align-items", "center")
            put("gap", "40px")
        }

        rule(".hero__avatar") {
            put("width", "140px")
            put("height", "140px")
            put("overflow", "hidden")
            put("flex-shrink", "0")
            put("background-color", "transparent")
        }

        rule(".hero__avatar img") {
            put("width", "100%")
            put("height", "100%")
            put("object-fit", "cover")
        }

        rule(".hero__about") {
            put("display", "flex")
            put("flex-direction", "column")
            put("align-items", "center")
            put("gap", "24px")
        }

        rule(".hero__name-role") {
            put("display", "flex")
            put("flex-direction", "column")
            put("align-items", "center")
            put("gap", "6px")
        }

        rule(".hero__name") {
            put("font-size", "40px")
            put("font-weight", "500")
            put("line-height", "48px")
            put("white-space", "nowrap")
        }

        rule(".hero__role") {
            put("display", "flex")
            put("align-items", "flex-start")
            put("justify-content", "center")
            put("gap", "6px")
            put("font-size", "20px")
            put("font-weight", "500")
            put("line-height", "28px")
            put("white-space", "nowrap")
        }

        rule(".hero__exp-badge") {
            put("background", "var(--c-accent)")
            put("padding", "0 8px")
            put("font-size", "20px")
            put("font-weight", "500")
            put("line-height", "28px")
        }

        rule(".hero__bio") {
            put("font-size", "36px")
            put("font-weight", "400")
            put("line-height", "44px")
            put("text-align", "center")
            put("width", "720px")
        }

        rule(".hero__video-btn") {
            put("display", "flex")
            put("align-items", "center")
            put("gap", "16px")
            put("padding", "12px 24px 12px 12px")
            put("border", "1.5px solid var(--c-ink-12)")
            put("border-radius", "32px")
            put("width", "400px")
            put("cursor", "pointer")
            put("transition", "opacity 0.15s ease")
        }

        rule(".hero__video-btn:hover") {
            put("opacity", "0.7")
        }

        rule(".hero__video-preview") {
            put("width", "120px")
            put("height", "80px")
            put("border-radius", "24px")
            put("overflow", "hidden")
            put("flex-shrink", "0")
            put("background", "rgba(7, 27, 49, 0.08)")
            put("position", "relative")
        }

        rule(".hero__video-preview img") {
            put("width", "100%")
            put("height", "100%")
            put("object-fit", "cover")
            put("border-radius", "24px")
        }

        rule(".hero__video-info") {
            put("display", "flex")
            put("flex-direction", "column")
            put("font-size", "20px")
            put("font-weight", "500")
            put("line-height", "28px")
        }

        rule(".hero__video-title") {
            put("white-space", "nowrap")
        }

        rule(".hero__video-duration") {
            put("color", "var(--c-ink-40)")
            put("white-space", "nowrap")
        }

        // ── Case sections ──────────────────────────────────────────────────────
        rule(".case-body") {
            put("height", "calc(1008px + var(--folder-tab-h))")
            put("display", "flex")
            put("width", "100%")
        }

        rule(".case-card") {
            put("flex", "1")
            put("height", "100%")
            put("display", "flex")
            put("flex-direction", "column")
            put("justify-content", "flex-end")
            put("padding", "calc(120px + var(--folder-tab-h)) var(--page-pad) var(--page-pad)")
            put("position", "relative")
        }

        rule(".case-card__body, .case-card__back") {
            put("position", "absolute")
            put("pointer-events", "none")
            put("inset", "var(--folder-tab-h) 0 0")
        }

        rule(".case-card__back") {
            put("z-index", "0")
            put("opacity", "48%")
            put("height", "60px")
            put("margin-top", "36px")
            put("clip-path", "polygon( 0% 65.574%,0% 65.574%,0.054% 54.937%,0.211% 44.847%,0.462% 35.439%,0.798% 26.847%,1.212% 19.206%,1.694% 12.652%,2.236% 7.319%,2.829% 3.343%,3.466% 0.858%,4.137% 0%,92.327% 0%,92.327% 0%,92.666% 0.22%,93% 0.874%,93.329% 1.95%,93.649% 3.44%,93.961% 5.331%,94.262% 7.614%,94.551% 10.279%,94.826% 13.314%,95.086% 16.711%,95.329% 20.457%,100% 98.556%,0% 98.556%,0% 65.574% )")
        }

        rule(".case-card__body") {
            put("z-index", "1")
            put("clip-path", "polygon(97.059% 5.964%, 97.059% 5.964%, 97.536% 6.016%, 97.988% 6.167%, 98.41% 6.408%, 98.796% 6.731%, 99.139% 7.129%, 99.432% 7.592%, 99.672% 8.113%, 99.85% 8.684%, 99.962% 9.295%, 100% 9.94%, 100% 96.024%, 100% 96.024%, 99.962% 96.669%, 99.85% 97.281%, 99.672% 97.851%, 99.432% 98.372%, 99.139% 98.835%, 98.796% 99.233%, 98.41% 99.556%, 97.988% 99.797%, 97.536% 99.948%, 97.059% 100%, 2.941% 100%, 2.941% 100%, 2.464% 99.948%, 2.012% 99.797%, 1.59% 99.556%, 1.204% 99.233%, 0.861% 98.835%, 0.567% 98.372%, 0.328% 97.851%, 0.15% 97.281%, 0.038% 96.669%, 0% 96.024%, 0% 3.976%, 0% 3.976%, 0.038% 3.331%, 0.15% 2.719%, 0.328% 2.149%, 0.567% 1.628%, 0.861% 1.165%, 1.204% 0.767%, 1.59% 0.444%, 2.012% 0.203%, 2.464% 0.052%, 2.941% 0%, 30.391% 0%, 30.391% 0%, 30.731% 0.018%, 31.067% 0.07%, 31.397% 0.157%, 31.721% 0.277%, 32.037% 0.43%, 32.343% 0.615%, 32.638% 0.832%, 32.921% 1.078%, 33.19% 1.354%, 33.445% 1.66%, 36.765% 5.964%, 97.059% 5.964%)")
            put("box-shadow", "inset 0 -4px 12px #f8fafb")
        }

        rule(".case-card__cover") {
            put("position", "absolute")
            put("left", "0")
            put("right", "0")
            put("top", "var(--folder-tab-h)")
            put("bottom", "0")
            put("object-fit", "cover")
            put("display", "block")
            put("z-index", "4")
            put("pointer-events", "none")
        }

        rule(".case-card__info") {
            put("display", "flex")
            put("flex-direction", "column")
            put("gap", "40px")
            put("align-items", "flex-start")
            put("width", "100%")
            put("position", "relative")
            put("z-index", "5")
        }

        rule(".case-card__title-desc") {
            put("display", "flex")
            put("gap", "24px")
            put("align-items", "flex-start")
            put("font-weight", "500")
            put("width", "100%")
        }

        rule(".case-card__title") {
            put("flex", "1")
            put("font-size", "36px")
            put("line-height", "44px")
            put("color", "var(--c-ink)")
        }

        rule(".case-card__desc") {
            put("flex", "1")
            put("font-size", "20px")
            put("line-height", "28px")
            put("color", "var(--c-ink-72)")
        }

        rule(".case-card__bottom") {
            put("display", "flex")
            put("align-items", "center")
            put("gap", "24px")
            put("width", "100%")
        }

        rule(".case-card__btn-slot") {
            put("flex", "1")
            put("display", "flex")
            put("flex-direction", "column")
            put("align-items", "flex-start")
        }

        rule(".case-card__tags") {
            put("flex", "1")
            put("display", "flex")
            put("gap", "8px")
            put("align-items", "flex-start")
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

        // ── Button: "Смотреть кейс" ────────────────────────────────────────────
        rule(".btn-case") {
            put("display", "inline-flex")
            put("align-items", "center")
            put("gap", "12px")
            put("height", "48px")
            put("padding", "0 20px 0 16px")
            put("border-radius", "24px")
            put("background", "#fff")
            put("font-size", "20px")
            put("font-weight", "500")
            put("line-height", "28px")
            put("color", "var(--c-ink)")
            put("cursor", "pointer")
            put("text-decoration", "none")
            put("flex-shrink", "0")
            put("transition", "opacity 0.15s ease")
        }

        rule(".btn-case:hover") {
            put("opacity", "0.75")
        }

        rule(".btn-case img") {
            put("width", "24px")
            put("height", "24px")
            put("flex-shrink", "0")
        }

        // ── Extra cases ────────────────────────────────────────────────────────
        rule(".extra-body") {
            put("display", "flex")
            put("flex-direction", "column")
            put("align-items", "center")
            put("gap", "60px")
            put("width", "100%")
        }

        rule(".extra-header") {
            put("display", "flex")
            put("flex-direction", "column")
            put("align-items", "center")
            put("gap", "16px")
        }

        rule(".extra-grid") {
            put("display", "flex")
            put("gap", "24px")
            put("align-items", "flex-start")
            put("width", "100%")
        }

        rule(".mini-card") {
            put("background", "var(--c-card)")
            put("display", "flex")
            put("flex-direction", "column")
            put("gap", "24px")
            put("align-items", "flex-start")
            put("overflow", "hidden")
            put("padding", "var(--page-pad)")
            put("border-radius", "40px")
            put("flex", "1")
            put("position", "relative")
        }

        rule(".mini-card::after") {
            put("content", "''")
            put("position", "absolute")
            put("inset", "0")
            put("border-radius", "inherit")
            put("box-shadow", "inset 0 -4px 24px 0 #f8fafb")
            put("pointer-events", "none")
        }

        rule(".mini-card__content") {
            put("display", "flex")
            put("align-items", "center")
            put("justify-content", "center")
            put("width", "100%")
            put("height", "400px")
        }

        rule(".mini-card__img") {
            put("width", "504px")
            put("max-width", "100%")
            put("height", "360px")
            put("object-fit", "cover")
            put("border-radius", "4px")
        }

        rule(".mini-card__bottom") {
            put("display", "flex")
            put("flex-direction", "column")
            put("gap", "40px")
            put("width", "100%")
        }

        rule(".mini-card__text") {
            put("display", "flex")
            put("flex-direction", "column")
            put("gap", "20px")
            put("font-weight", "500")
        }

        rule(".mini-card__title") {
            put("font-size", "36px")
            put("line-height", "44px")
            put("color", "var(--c-ink)")
            put("width", "100%")
        }

        rule(".mini-card__desc") {
            put("font-size", "20px")
            put("line-height", "28px")
            put("color", "var(--c-ink-60)")
            put("width", "100%")
        }

        rule(".mini-card__footer") {
            put("display", "flex")
            put("align-items", "center")
            put("justify-content", "space-between")
            put("width", "100%")
            put("min-height", "48px")
        }

        // ── About ──────────────────────────────────────────────────────────────
        rule(".about-body") {
            put("display", "flex")
            put("flex-direction", "column")
            put("gap", "40px")
            put("align-items", "center")
            put("width", "100%")
        }

        rule(".about-photos") {
            put("display", "flex")
            put("gap", "24px")
            put("align-items", "flex-start")
        }

        rule(".about-photo") {
            put("width", "286px")
            put("height", "200px")
            put("border-radius", "32px")
            put("overflow", "hidden")
            put("flex-shrink", "0")
            put("background", "var(--c-photo-bg)")
            put("position", "relative")
        }

        rule(".about-photo img") {
            put("position", "absolute")
            put("inset", "0")
            put("width", "100%")
            put("height", "100%")
            put("object-fit", "cover")
        }

        rule(".about-photo--sq") {
            put("width", "200px")
            put("height", "200px")
            put("background-color", "transparent")
        }

        rule(".about-description") {
            put("display", "flex")
            put("flex-direction", "column")
            put("gap", "40px")
            put("align-items", "center")
            put("text-align", "center")
        }

        rule(".about-nick") {
            put("display", "flex")
            put("flex-direction", "column")
            put("gap", "8px")
        }

        rule(".about-nick__name") {
            put("font-size", "36px")
            put("font-weight", "500")
            put("line-height", "44px")
            put("width", "720px")
        }

        rule(".about-nick__sub") {
            put("font-size", "20px")
            put("font-weight", "500")
            put("line-height", "28px")
            put("opacity", "0.6")
            put("width", "720px")
        }

        rule(".about-text") {
            put("font-size", "36px")
            put("font-weight", "400")
            put("line-height", "44px")
            put("width", "720px")
            put("white-space", "pre-line")
        }

        rule(".about-text--small") {
            put("font-size", "20px")
            put("font-weight", "500")
            put("line-height", "28px")
            put("opacity", "0.6")
            put("width", "720px")
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
            put("transition", "opacity 0.15s ease")
        }

        rule(".goodbye-email:hover") {
            put("opacity", "0.7")
        }

        rule(".goodbye-email img") {
            put("width", "24px")
            put("height", "24px")
            put("flex-shrink", "0")
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
}
