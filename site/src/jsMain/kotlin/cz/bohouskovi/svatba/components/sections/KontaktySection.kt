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
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

private val WitnessItemStyle = Modifier
    .flex("18rem")
    .display(DisplayStyle.Flex)
    .flexDirection(FlexDirection.Column)
    .alignItems(AlignItems.Center)
    .textAlign(TextAlign.Center)
    .padding(1.cssRem)

@Composable
private fun WitnessItem(
    imageSrc: String,
    name: String,
    description: String,
) {
    Column(
        modifier = WitnessItemStyle,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Img(src = imageSrc, attrs = {
            attr(
                "style",
                "width:9rem;height:9rem;aspect-ratio:1/1;border-radius:50%;margin-bottom:0.75rem;object-fit:cover;"
            )
            attr("alt", name)
            attr("decoding", "async")
            attr("loading", "lazy")
        })
        H3 { Text(name) }
        P { Text(description) }
    }
}

@Composable
fun WitnessSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("svedci"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(HeadlineTextStyle.toAttrs()) {
            H6 { Text("Svědci") }
        }

        FlexBoxLayout {
            WitnessItem(
                imageSrc = "tomik.png",
                name = "Tomáš Pavlín - svědek ženicha",
                description = "S Tomíkem (prosím, oslovujte ho tak) se známe od střední. Společně jsme velcí odborníci na přetváření Silvestrovských chat v sauny a pojízdných aut v nepojízdná. Taky jsme proluštili nespočet letních nocí, takže pokud byste potřebovali poradit s luštěním svatební šifry, obraťte se na něj!",
            )
            WitnessItem(
                imageSrc = "zuzka.png",
                name = "Zuzka Tipková - svědkyně nevěsty",
                description = "Se Zuzkou se známe asi 10 let. Poznaly jsme se na vysoké škole. Za tu dobu jsme spolu zvládly překonat útrapy vysokoškolského studia, cestovat a nedávno jsme dokonce překonávaly strach z řízení s pomocí kondičních jízd. Zuzky si vážím, protože je to člověk, který vás rád vyslechne a podpoří a zároveň se s ní hodně nasmějete. Taky jako jedna z mála vydrží poslouchat moje dlouhá vyprávění. \uD83D\uDE00",
            )
        }
    }
}
