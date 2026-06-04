package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

private val textColor = Color.rgb(0x465752)

private val infoTextModifier = Modifier
    .flex("1")
    .fontSize(1.1.cssRem)
    .fontWeight(FontWeight.SemiBold)
    .color(textColor)

private val dividerModifier = Modifier
    .width(1.px)
    .styleModifier { property("align-self", "stretch") }
    .backgroundColor(textColor)
    .opacity(0.6)
    .flexShrink(0)

@Composable
fun IntroSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Span(
            infoTextModifier.textAlign(TextAlign.End)
                .padding(topBottom = 0.5.cssRem, leftRight = 1.5.cssRem)
                .toAttrs()
        ) {
            Text("22. – 23. 8. 2026")
        }

        Span(dividerModifier.toAttrs()) {}

        Span(
            infoTextModifier.textAlign(TextAlign.Start)
                .padding(topBottom = 0.5.cssRem, leftRight = 1.5.cssRem)
                .toAttrs()
        ) {
            Text("Chalupa v Podbezdězí,\nHlínoviště 3, 294 21 Bělá pod Bezdězem")
        }
    }
}
