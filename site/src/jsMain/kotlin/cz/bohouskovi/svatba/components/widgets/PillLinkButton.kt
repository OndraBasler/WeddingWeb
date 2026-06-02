package cz.bohouskovi.svatba.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text

@Composable
fun PillLinkButton(
    href: String,
    text: String,
    openInNewTab: Boolean = false,
) {
    A(href = href, attrs = {
        if (openInNewTab) {
            attr("target", "_blank")
            attr("rel", "noopener noreferrer")
        }
        attr(
            "style",
            "display:inline-block;margin:0.5rem 0 2rem;padding:0.75rem 1.25rem;border-radius:999px;" +
                "background:#7b4a34;color:white;text-decoration:none;font-weight:700;box-shadow:0 0.45rem 1rem rgba(123,74,52,0.22);"
        )
    }) {
        Text(text)
    }
}
