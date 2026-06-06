package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

private val textColor = Color.rgb(0x465752)

private val infoTextModifier = Modifier
    .fontSize(1.cssRem)
    .fontWeight(FontWeight.Medium)
    .color(textColor)
    .opacity(0.8)
    .styleModifier { property("letter-spacing", "0.08em") }
    .styleModifier { property("text-transform", "uppercase") }

private val verticalDividerModifier = Modifier
    .width(1.px)
    .styleModifier { property("align-self", "stretch") }
    .backgroundColor(textColor)
    .opacity(0.35)
    .flexShrink(0)

private val horizontalDividerModifier = Modifier
    .height(1.px)
    .styleModifier { property("align-self", "stretch") }
    .backgroundColor(textColor)
    .opacity(0.35)

@Composable
fun IntroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.cssRem)
            .styleModifier { property("min-height", "100svh") },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        DecorationImage(
            src = "wedding_decoration_kno.webp",
            eager = true,
            modifier = Modifier
                .padding(leftRight = 4.cssRem)
                .styleModifier { property("max-height", "60svh") }
                .styleModifier { property("max-width", "40rem") }
                .styleModifier { property("object-fit", "contain") }
        )

        // Mobile: column with horizontal divider
        Column(
            modifier = Modifier.displayUntil(Breakpoint.MD),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Span(
                infoTextModifier
                    .textAlign(TextAlign.Center)
                    .padding(topBottom = 1.cssRem, leftRight = 2.cssRem)
                    .toAttrs()
            ) {
                Text("22. – 23. 8. 2026")
            }
            Span(horizontalDividerModifier.toAttrs()) {}
            Span(
                infoTextModifier
                    .textAlign(TextAlign.Start)
                    .padding(topBottom = 1.cssRem, leftRight = 2.cssRem)
                    .toAttrs()
            ) {
                Text("Chalupa v Podbezdězí,")
                Br()
                Text("Hlínoviště 3,")
                Br()
                Text("Bělá pod Bezdězem")
            }
        }

        // Desktop: row with vertical divider
        Row(
            modifier = Modifier.fillMaxWidth().displayIfAtLeast(Breakpoint.MD),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Span(
                infoTextModifier
                    .flex("1")
                    .textAlign(TextAlign.End)
                    .padding(leftRight = 2.cssRem)
                    .toAttrs()
            ) {
                Text("22. – 23. 8. 2026")
            }

            Span(verticalDividerModifier.toAttrs()) {}

            Span(
                infoTextModifier
                    .flex("1")
                    .textAlign(TextAlign.Start)
                    .padding(leftRight = 2.cssRem)
                    .toAttrs()
            ) {
                Text("Chalupa v Podbezdězí,")
                Br()
                Text("Hlínoviště 3,")
                Br()
                Text("Bělá pod Bezdězem")
            }
        }
    }
}
