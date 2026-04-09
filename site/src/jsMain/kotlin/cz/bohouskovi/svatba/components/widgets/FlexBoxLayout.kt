package cz.bohouskovi.svatba.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun FlexBoxLayout(
    content: ContentBuilder<HTMLDivElement>
) {
    Div(
        attrs = { attr("style", "display:flex;flex-wrap:wrap;justify-content:center;") },
        content = content
    )
}