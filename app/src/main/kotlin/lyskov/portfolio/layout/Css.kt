package lyskov.portfolio.layout

object Css {
    /** Stylesheet for the main (index) page and 404. */
    val MAIN_STYLESHEET: String by lazy { buildSharedCss() + buildMainCss() }

    /** Stylesheet for case pages. */
    val CASE_STYLESHEET: String by lazy { buildSharedCss() + buildCaseCss() }
}
