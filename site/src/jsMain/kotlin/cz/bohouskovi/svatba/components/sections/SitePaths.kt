package cz.bohouskovi.svatba.components.sections

import kotlinx.browser.window

const val RSVP_PAGE_PATH = "/rsvp"

private const val LOCAL_BASE_URL = "http://localhost:8080"
private const val GITHUB_PAGES_BASE_URL = "https://ondrabasler.github.io/WeddingWeb"

fun sitePath(path: String): String {
    val normalizedPath = if (path.startsWith("/")) path else "/$path"
    return currentBaseUrl() + normalizedPath
}

private fun currentBaseUrl(): String {
    val currentUrl = window.location.href.removeSuffix("/")

    return when {
        currentUrl.startsWith(GITHUB_PAGES_BASE_URL) -> GITHUB_PAGES_BASE_URL
        currentUrl.startsWith(LOCAL_BASE_URL) -> LOCAL_BASE_URL
        else -> window.location.origin
    }
}
