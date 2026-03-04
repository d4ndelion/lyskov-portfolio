package lyskov.portfolio.layout

/**
 * Minimal, design-agnostic stylesheet.
 *
 * Design intentionally deferred to Figma delivery.
 * Provides only:
 *   • Box-model reset
 *   • Semantic layout (header / main / footer flex column)
 *   • BEM skeleton classes (no colour / typography values)
 *   • .anim-zoom  — scale on hover via transform + transition
 *   • .anim-rotate — full rotation on hover via transform + transition
 *
 * All visual tokens (colours, fonts, spacing) live in :root as CSS custom
 * properties with placeholder values — replace from Figma tokens.
 */
object Css {

    val STYLESHEET: String = """
/* ── Reset ───────────────────────────────────────────────────────────────── */
*,
*::before,
*::after {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

/* ── Design tokens (replace with Figma values) ───────────────────────────── */
:root {
  --color-bg:          #ffffff;
  --color-surface:     #f5f5f5;
  --color-text:        #111111;
  --color-text-muted:  #666666;
  --color-accent:      #0070f3;
  --color-border:      #e0e0e0;

  --font-sans:         system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
                       Roboto, Helvetica, Arial, sans-serif;
  --font-mono:         ui-monospace, "Cascadia Code", "Source Code Pro",
                       Menlo, Consolas, monospace;

  --space-xs:          0.25rem;
  --space-sm:          0.5rem;
  --space-md:          1rem;
  --space-lg:          2rem;
  --space-xl:          4rem;

  --radius:            0.375rem;
  --transition-speed:  0.3s;
  --transition-ease:   ease;
}

/* ── Base ─────────────────────────────────────────────────────────────────── */
html {
  scroll-behavior: smooth;
  -webkit-text-size-adjust: 100%;
}

body {
  font-family: var(--font-sans);
  background-color: var(--color-bg);
  color: var(--color-text);
  line-height: 1.6;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

img,
svg {
  display: block;
  max-width: 100%;
}

a {
  color: var(--color-accent);
  text-decoration: none;
}

a:hover,
a:focus-visible {
  text-decoration: underline;
}

:focus-visible {
  outline: 2px solid var(--color-accent);
  outline-offset: 2px;
}

/* ── Layout shell ─────────────────────────────────────────────────────────── */
.site-header {
  border-bottom: 1px solid var(--color-border);
  padding: var(--space-md) var(--space-lg);
}

.site-header__inner {
  display: flex;
  align-items: center;
  justify-content: space-between;
  max-width: 72rem;
  margin-inline: auto;
}

.site-nav__list {
  display: flex;
  gap: var(--space-md);
  list-style: none;
}

.site-nav__link {
  font-weight: 500;
}

.site-main {
  flex: 1;
  max-width: 72rem;
  width: 100%;
  margin-inline: auto;
  padding: var(--space-xl) var(--space-lg);
}

.site-footer {
  border-top: 1px solid var(--color-border);
  padding: var(--space-md) var(--space-lg);
  text-align: center;
  color: var(--color-text-muted);
  font-size: 0.875rem;
}

/* ── Portfolio page ───────────────────────────────────────────────────────── */
.portfolio__heading {
  font-size: clamp(1.75rem, 4vw, 3rem);
  font-weight: 700;
  line-height: 1.2;
  margin-bottom: var(--space-md);
}

.portfolio__lead {
  font-size: 1.125rem;
  color: var(--color-text-muted);
  max-width: 52ch;
}

/* ── 404 page ─────────────────────────────────────────────────────────────── */
.error-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  gap: var(--space-md);
  min-height: 40vh;
}

.error-page__code {
  font-size: clamp(4rem, 12vw, 8rem);
  font-weight: 800;
  line-height: 1;
  color: var(--color-border);
}

.error-page__title {
  font-size: 1.5rem;
  font-weight: 600;
}

/* ── Animations (transform + transition, no keyframes) ───────────────────── */

/**
 * .anim-zoom
 * Apply to any element to scale it up on hover / focus.
 */
.anim-zoom {
  transition: transform var(--transition-speed) var(--transition-ease);
}

.anim-zoom:hover,
.anim-zoom:focus-visible {
  transform: scale(1.06);
}

/**
 * .anim-rotate
 * Apply to any element (e.g. an icon) to spin it on hover / focus.
 */
.anim-rotate {
  display: inline-block;
  transition: transform var(--transition-speed) var(--transition-ease);
}

.anim-rotate:hover,
.anim-rotate:focus-visible {
  transform: rotate(360deg);
}
""".trimIndent()
}
