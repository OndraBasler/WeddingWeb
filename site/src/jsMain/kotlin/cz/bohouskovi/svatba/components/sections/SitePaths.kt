package cz.bohouskovi.svatba.components.sections

import kotlinx.browser.window

const val RSVP_PAGE_PATH = "/rsvp"

private val pagePaths = setOf(RSVP_PAGE_PATH)

fun sitePath(path: String): String {
    val normalizedPath = if (path.startsWith("/")) path else "/$path"
    return currentSiteBasePath() + normalizedPath
}

private fun currentSiteBasePath(): String {
    val currentPath = window.location.pathname
        .removeSuffix("/")
        .removeSuffix("/index.html")

    if (currentPath.isEmpty() || currentPath == "/") return ""

    return pagePaths
        .firstOrNull { pagePath -> currentPath == pagePath || currentPath.endsWith(pagePath) }
        ?.let { pagePath -> currentPath.removeSuffix(pagePath) }
        ?: currentPath
}
