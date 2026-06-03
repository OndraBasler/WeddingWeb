package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import org.jetbrains.compose.web.dom.*

@Composable
private fun AboutPhotoItem(src: String) {
    Div(attrs = {
        attr("style", "display:flex;flex:0 0 auto;justify-content:center;padding:1rem;")
    }) {
        Img(src = src, attrs = {
            attr(
                "style",
                "width:14rem;aspect-ratio:9/16;object-fit:cover;border-radius:0.75rem;"
            )
            attr("alt", "Kamča a Ondra")
            attr("decoding", "async")
            attr("loading", "lazy")
        })
    }
}

@Composable
fun ONasSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .id("o-nas")
            .textAlign(TextAlign.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H2 { Text("O nás") }

        P {
            Text(
                "V pohádkách musí princ překonat devatero řek a devatero hor, ale Ondrovi stačilo přejít Stodůlecký rybník a odvážit se na Velkou horu Ohradu, aby poznal Kamču."
            )
        }

        Div(attrs = {
            attr(
                "style",
                "display:flex;flex-wrap:nowrap;justify-content:flex-start;max-width:100%;overflow-x:auto;"
            )
        }) {
            AboutPhotoItem(src = "bohousci_1.webp")
            AboutPhotoItem(src = "bohousci_2.webp")
            AboutPhotoItem(src = "bohousci_3.webp")
            AboutPhotoItem(src = "bohousci_4.webp")
            AboutPhotoItem(src = "bohousci_5.webp")
        }
    }
}
