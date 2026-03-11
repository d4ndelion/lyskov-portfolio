package lyskov.portfolio.layout

/**
 * Portfolio stylesheet — adapted from Figma design (node 1628:2292).
 *
 * Design tokens, layout, and component styles for the ilyskov.site portfolio.
 * Desktop-first (1360px content area, 1920px design canvas).
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

/* ── Design tokens ───────────────────────────────────────────────────────── */
:root {
  --c-bg:        #ffffff;
  --c-ink:       #071b31;
  --c-ink-72:    rgba(7, 27, 49, 0.72);
  --c-ink-60:    rgba(7, 27, 49, 0.60);
  --c-ink-40:    rgba(7, 27, 49, 0.40);
  --c-ink-24:    rgba(7, 27, 49, 0.24);
  --c-ink-12:    rgba(7, 27, 49, 0.12);
  --c-accent:    #d8edfa;
  --c-card:      #e8ebed;
  --c-photo-bg:  #ededed;
  --c-tag-bg:    rgba(255, 255, 255, 0.60);

  --font:        'Onest', system-ui, -apple-system, sans-serif;

  --header-h:    80px;
  --page-pad:    40px;
  --content-w:   1360px;
  --gap-section: 20px;
}

/* ── Base ─────────────────────────────────────────────────────────────────── */
html {
  scroll-behavior: smooth;
  -webkit-text-size-adjust: 100%;
}

body {
  font-family: var(--font);
  background-color: var(--c-bg);
  color: var(--c-ink);
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

img,
svg {
  display: block;
  max-width: 100%;
}

a {
  color: inherit;
  text-decoration: none;
}

/* ── Accessibility ────────────────────────────────────────────────────────── */
.skip-link {
  position: absolute;
  left: -9999px;
  top: auto;
  width: 1px;
  height: 1px;
  overflow: hidden;
}

.skip-link:focus {
  left: 0;
  top: 0;
  width: auto;
  height: auto;
  overflow: visible;
  padding: 4px 12px;
  background: var(--c-ink);
  color: #fff;
  z-index: 9999;
  outline: none;
}

:focus-visible {
  outline: 2px solid var(--c-ink);
  outline-offset: 2px;
}

/* ── Layout shell ─────────────────────────────────────────────────────────── */
.site-main {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: var(--gap-section);
}

/* ── Header ───────────────────────────────────────────────────────────────── */
.site-header {
  position: sticky;
  top: 0;
  z-index: 100;
  height: var(--header-h);
  padding: 24px var(--page-pad) 0;
  overflow: hidden;
  backdrop-filter: blur(6px);
  -webkit-backdrop-filter: blur(6px);
}

.site-header__body {
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 100%;
}

.site-header__left {
  display: flex;
  align-items: center;
  gap: 12px;
}

.site-header__logo {
  width: 18px;
  height: 18px;
  flex-shrink: 0;
}

.site-header__location {
  display: flex;
  align-items: center;
  gap: 8px;
}

.site-header__divider {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 28px;
  align-self: stretch;
}

.site-header__divider img {
  width: 10px;
  height: 10px;
}

.site-header__city {
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  white-space: nowrap;
}

.site-header__right {
  display: flex;
  align-items: center;
  gap: 12px;
}

.site-header__icon-group {
  display: flex;
  align-items: center;
}

.site-header__icon-btn {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 48px;
  height: 48px;
  flex-shrink: 0;
  transition: opacity 0.15s ease;
}

.site-header__icon-btn:hover {
  opacity: 0.6;
}

.site-header__icon-btn img {
  width: 24px;
  height: 24px;
}

.site-header__icon-btn--max img {
  width: 22px;
  height: 22px;
}

.site-header__sep {
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  opacity: 0.24;
}

.site-header__links {
  display: flex;
  align-items: center;
  gap: 4px;
}

.site-header__link {
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  padding: 0 8px;
  text-decoration: underline;
  text-underline-offset: 3px;
  transition: opacity 0.15s ease;
}

.site-header__link:hover {
  opacity: 0.6;
}

/* ── Footer ───────────────────────────────────────────────────────────────── */
.site-footer {
  padding: 0 var(--page-pad) 16px;
  overflow: hidden;
  backdrop-filter: blur(6px);
  -webkit-backdrop-filter: blur(6px);
}

.site-footer__body {
  height: 48px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.site-footer__copy {
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  color: var(--c-ink-40);
  white-space: nowrap;
}

/* ── Shared section shell ─────────────────────────────────────────────────── */
.pg-section {
  background: var(--c-bg);
  display: flex;
  flex-direction: column;
  align-items: center;
  overflow: hidden;
  padding: var(--page-pad);
}

.pg-section--about {
  padding-top: 80px;
  padding-bottom: 80px;
}

.pg-section--goodbye {
  padding-top: 80px;
  padding-bottom: 200px;
}

.pg-section__body {
  max-width: var(--content-w);
  width: 100%;
}

/* ── Sub-header badge ─────────────────────────────────────────────────────── */
.sub-badge {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  padding: 0 8px;
  background: var(--c-accent);
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  white-space: nowrap;
}

/* ── Section heading ──────────────────────────────────────────────────────── */
.section-heading {
  font-size: 36px;
  font-weight: 400;
  line-height: 44px;
  text-align: center;
  width: 720px;
}

/* ── Hero ─────────────────────────────────────────────────────────────────── */
.hero__body {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 40px;
}

.hero__avatar {
  width: 140px;
  height: 140px;
  border-radius: 50%;
  overflow: hidden;
  flex-shrink: 0;
  background: var(--c-photo-bg);
}

.hero__avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.hero__about {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 24px;
}

.hero__name-role {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 6px;
}

.hero__name {
  font-size: 40px;
  font-weight: 500;
  line-height: 48px;
  white-space: nowrap;
}

.hero__role {
  display: flex;
  align-items: flex-start;
  justify-content: center;
  gap: 6px;
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  white-space: nowrap;
}

.hero__exp-badge {
  background: var(--c-accent);
  padding: 0 8px;
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
}

.hero__bio {
  font-size: 36px;
  font-weight: 400;
  line-height: 44px;
  text-align: center;
  width: 720px;
}

.hero__video-btn {
  display: flex;
  align-items: center;
  gap: 16px;
  padding: 12px 24px 12px 12px;
  border: 1.5px solid var(--c-ink-12);
  border-radius: 32px;
  width: 400px;
  cursor: pointer;
  transition: opacity 0.15s ease;
}

.hero__video-btn:hover {
  opacity: 0.7;
}

.hero__video-preview {
  width: 120px;
  height: 80px;
  border-radius: 24px;
  overflow: hidden;
  flex-shrink: 0;
  background: rgba(7, 27, 49, 0.08);
  position: relative;
}

.hero__video-preview img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 24px;
}

.hero__video-info {
  display: flex;
  flex-direction: column;
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
}

.hero__video-title {
  white-space: nowrap;
}

.hero__video-duration {
  color: var(--c-ink-40);
  white-space: nowrap;
}

/* ── Case sections ────────────────────────────────────────────────────────── */
.case-body {
  height: 1008px;
  display: flex;
  align-items: flex-start;
  justify-content: center;
  width: 100%;
}

.case-card {
  flex: 1;
  align-self: stretch;
  display: flex;
  flex-direction: column;
  gap: 60px;
  align-items: center;
  justify-content: flex-end;
  overflow: hidden;
  padding: 120px var(--page-pad) var(--page-pad);
  border-radius: 0 40px 40px 40px;
  position: relative;
}

.case-card__cover {
  position: absolute;
  inset: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block;
  pointer-events: none;
}

.case-card::after {
  content: '';
  position: absolute;
  inset: 0;
  border-radius: inherit;
  box-shadow: inset 0 -4px 12px 0 #f8fafb;
  pointer-events: none;
}

.case-card__info {
  display: flex;
  flex-direction: column;
  gap: 40px;
  align-items: flex-start;
  width: 100%;
  position: relative;
  z-index: 1;
}

.case-card__title-desc {
  display: flex;
  gap: 24px;
  align-items: flex-start;
  font-weight: 500;
  width: 100%;
}

.case-card__title {
  flex: 1;
  font-size: 36px;
  line-height: 44px;
  color: var(--c-ink);
}

.case-card__desc {
  flex: 1;
  font-size: 20px;
  line-height: 28px;
  color: var(--c-ink-72);
}

.case-card__bottom {
  display: flex;
  align-items: center;
  gap: 24px;
  width: 100%;
}

.case-card__btn-slot {
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.case-card__tags {
  flex: 1;
  display: flex;
  gap: 8px;
  align-items: flex-start;
}

/* ── Tag pill ─────────────────────────────────────────────────────────────── */
.tag {
  background: var(--c-tag-bg);
  height: 40px;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  padding: 0 16px;
  border-radius: 1000px;
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  white-space: nowrap;
  flex-shrink: 0;
}

.tag--muted {
  color: var(--c-ink-60);
}

/* ── Button: "Смотреть кейс" ──────────────────────────────────────────────── */
.btn-case {
  display: inline-flex;
  align-items: center;
  gap: 12px;
  height: 48px;
  padding: 0 20px 0 16px;
  border-radius: 24px;
  background: #fff;
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  color: var(--c-ink);
  cursor: pointer;
  text-decoration: none;
  flex-shrink: 0;
  transition: opacity 0.15s ease;
}

.btn-case:hover {
  opacity: 0.75;
}

.btn-case img {
  width: 24px;
  height: 24px;
  flex-shrink: 0;
}

/* ── Extra cases ──────────────────────────────────────────────────────────── */
.extra-body {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 60px;
  width: 100%;
}

.extra-header {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 16px;
}

.extra-grid {
  display: flex;
  gap: 24px;
  align-items: flex-start;
  width: 100%;
}

.mini-card {
  background: var(--c-card);
  display: flex;
  flex-direction: column;
  gap: 24px;
  align-items: flex-start;
  overflow: hidden;
  padding: var(--page-pad);
  border-radius: 40px;
  flex: 1;
  position: relative;
}

.mini-card::after {
  content: '';
  position: absolute;
  inset: 0;
  border-radius: inherit;
  box-shadow: inset 0 -4px 24px 0 #f8fafb;
  pointer-events: none;
}

.mini-card__content {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 400px;
}

.mini-card__img {
  width: 504px;
  max-width: 100%;
  height: 360px;
  object-fit: cover;
  border-radius: 4px;
  box-shadow: 0 4px 60px 0 rgba(7, 27, 49, 0.16);
}

.mini-card__bottom {
  display: flex;
  flex-direction: column;
  gap: 40px;
  width: 100%;
}

.mini-card__text {
  display: flex;
  flex-direction: column;
  gap: 20px;
  font-weight: 500;
}

.mini-card__title {
  font-size: 36px;
  line-height: 44px;
  color: var(--c-ink);
  width: 100%;
}

.mini-card__desc {
  font-size: 20px;
  line-height: 28px;
  color: var(--c-ink-60);
  width: 100%;
}

.mini-card__footer {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  min-height: 48px;
}

/* ── About ────────────────────────────────────────────────────────────────── */
.about-body {
  display: flex;
  flex-direction: column;
  gap: 40px;
  align-items: center;
  width: 100%;
}

.about-photos {
  display: flex;
  gap: 24px;
  align-items: flex-start;
}

.about-photo {
  width: 286px;
  height: 200px;
  border-radius: 32px;
  overflow: hidden;
  flex-shrink: 0;
  background: var(--c-photo-bg);
  position: relative;
}

.about-photo img {
  position: absolute;
  inset: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.about-photo--sq {
  width: 200px;
  height: 200px;
}

.about-description {
  display: flex;
  flex-direction: column;
  gap: 40px;
  align-items: flex-start;
}

.about-nick {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.about-nick__name {
  font-size: 36px;
  font-weight: 500;
  line-height: 44px;
  width: 720px;
}

.about-nick__sub {
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  opacity: 0.6;
  width: 720px;
}

.about-text {
  font-size: 36px;
  font-weight: 400;
  line-height: 44px;
  width: 720px;
}

.about-text--small {
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  opacity: 0.6;
  width: 720px;
}

/* ── Goodbye ──────────────────────────────────────────────────────────────── */
.goodbye-body {
  display: flex;
  flex-direction: column;
  gap: 40px;
  align-items: center;
  max-width: var(--content-w);
  width: 100%;
}

.goodbye-gif {
  transform: rotate(-2deg);
  width: 286px;
  height: 200px;
  border-radius: 24px;
  overflow: hidden;
  position: relative;
  background: var(--c-photo-bg);
  flex-shrink: 0;
}

.goodbye-gif img {
  position: absolute;
  width: 105%;
  height: 191%;
  top: -3%;
  left: -4%;
  max-width: none;
  object-fit: cover;
}

.goodbye-text {
  display: flex;
  flex-direction: column;
  gap: 12px;
  align-items: center;
  font-weight: 500;
  text-align: center;
}

.goodbye-text__heading {
  font-size: 36px;
  line-height: 44px;
  white-space: nowrap;
}

.goodbye-text__sub {
  font-size: 20px;
  line-height: 28px;
  opacity: 0.9;
  width: 720px;
}

.goodbye-contacts {
  display: flex;
  flex-direction: column;
  gap: 12px;
  align-items: center;
  width: 100%;
  max-width: 400px;
}

.goodbye-btn-row {
  display: flex;
  gap: 12px;
  align-items: center;
  justify-content: center;
}

.btn-write {
  display: inline-flex;
  align-items: center;
  gap: 12px;
  height: 48px;
  padding: 0 20px 0 16px;
  border-radius: 24px;
  background: var(--c-ink);
  color: #fff;
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  white-space: nowrap;
  flex-shrink: 0;
  cursor: pointer;
  text-decoration: none;
  transition: opacity 0.15s ease;
}

.btn-write:hover {
  opacity: 0.75;
}

.btn-write img {
  width: 24px;
  height: 24px;
  flex-shrink: 0;
}

.icon-btn {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 48px;
  height: 48px;
  flex-shrink: 0;
  transition: opacity 0.15s ease;
}

.icon-btn:hover {
  opacity: 0.6;
}

.icon-btn img {
  width: 22px;
  height: 22px;
}

.icon-btn--linkedin img {
  width: 24px;
  height: 24px;
}

.goodbye-email {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
  height: 48px;
  padding: 0 20px;
  border: 1.5px solid var(--c-ink-12);
  border-radius: 24px;
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  white-space: nowrap;
  width: 100%;
  transition: opacity 0.15s ease;
}

.goodbye-email:hover {
  opacity: 0.7;
}

.goodbye-email img {
  width: 24px;
  height: 24px;
  flex-shrink: 0;
}

/* ── 404 page ─────────────────────────────────────────────────────────────── */
.error-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  gap: 1rem;
  min-height: 40vh;
  padding: 40px;
}

.error-page__code {
  font-size: clamp(4rem, 12vw, 8rem);
  font-weight: 800;
  line-height: 1;
  opacity: 0.12;
}

.error-page__title {
  font-size: 36px;
  font-weight: 500;
  line-height: 44px;
}

.error-page__link {
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  text-decoration: underline;
  text-underline-offset: 3px;
  color: var(--c-ink);
  transition: opacity 0.15s ease;
}

.error-page__link:hover {
  opacity: 0.6;
}
""".trimIndent()
}
