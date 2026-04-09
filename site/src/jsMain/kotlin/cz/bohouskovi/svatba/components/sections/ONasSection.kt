package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.toAttrs
import cz.bohouskovi.svatba.HeadlineTextStyle
import cz.bohouskovi.svatba.components.widgets.FlexBoxLayout
import org.jetbrains.compose.web.dom.*

@Composable
private fun AboutPhotoItem(src: String) {
    Div(attrs = {
        attr("style", "display:flex;justify-content:center;padding:1rem;")
    }) {
        Img(src = src, attrs = {
            attr(
                "style",
                "width:100%;max-width:14rem;aspect-ratio:9/16;object-fit:cover;border-radius:0.75rem;"
            )
        })
    }
}

@Composable
fun ONasSection() {
    Column(
        modifier = Modifier
            .id("o-nas")
            .textAlign(TextAlign.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(HeadlineTextStyle.toAttrs()) {
            H6 { Text("O nás") }
        }

        P(attrs = {
            attr("style", "max-width:48rem;margin:0 0 1.5rem 0;")
        }) {
            Text(
                "Jsme nevěsta a ženich, kteří se rozhodli říct si své ano obklopeni rodinou a přáteli. " +
                    "Těšíme se, že s vámi oslavíme tento výjimečný den plný radosti, lásky a krásných vzpomínek."
            )
        }

        FlexBoxLayout {
            AboutPhotoItem(src = "https://picsum.photos/id/1005/900/1600")
            AboutPhotoItem(src = "https://picsum.photos/id/1011/900/1600")
            AboutPhotoItem(src = "https://picsum.photos/id/1012/900/1600")
        }
    }
}
