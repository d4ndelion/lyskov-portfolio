package lyskov.portfolio.layout

import kotlinx.css.CssBuilder
import kotlinx.css.height
import kotlinx.css.px
import kotlinx.css.width

internal fun buildMainCss(): String = CssBuilder().apply {

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

    // ── Case card (index page) ─────────────────────────────────────────────
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
        width = 12.px
        height = 12.px
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

}.toString()
