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
    phone: String,
) {
    Column(
        modifier = WitnessItemStyle,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Img(src = imageSrc, attrs = {
            attr(
                "style",
                "width:9rem;height:9rem;border-radius:50%;margin-bottom:0.75rem;object-fit:cover;"
            )
        })
        H3 { Text(name) }
        P { Text(description) }
        A(href = "tel:$phone") {
            Text(phone)
        }
    }
}

@Composable
fun KontaktySection() {
    Column(
        modifier = Modifier.id("kontakty"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(HeadlineTextStyle.toAttrs()) {
            H6 { Text("Kontakty") }
        }

        FlexBoxLayout {
            WitnessItem(
                imageSrc = "https://picsum.photos/id/1005/400/400",
                name = "Svědek ženicha",
                description = "Pomůže se vším kolem ženicha během svatebního dne.",
                phone = "+420 777 123 456"
            )
            WitnessItem(
                imageSrc = "https://picsum.photos/id/1027/400/400",
                name = "Svědkyně nevěsty",
                description = "Pomůže se vším kolem nevěsty během svatebního dne.",
                phone = "+420 777 654 321"
            )
        }
    }
}
