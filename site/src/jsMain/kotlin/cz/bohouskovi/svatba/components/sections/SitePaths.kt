package cz.bohouskovi.svatba.components.sections

const val RSVP_PAGE_PATH = "/rsvp"

fun sitePath(path: String): String {
    return "./${path.removePrefix("/")}"
}
