package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.toAttrs
import cz.bohouskovi.svatba.HeadlineTextStyle
import cz.bohouskovi.svatba.components.widgets.FlexBoxLayout
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

private val UvodInfoItemStyle = Modifier
    .flex("16rem")
    .display(DisplayStyle.Flex)
    .flexDirection(FlexDirection.Column)
    .textAlign(TextAlign.Center)

@Composable
private fun UvodInfoItem(iconSrc: String, text: String) {
    Column(
        modifier = UvodInfoItemStyle,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(iconSrc)
        P { Text(text) }
    }
}

@Composable
fun UvodSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("uvod"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(HeadlineTextStyle.toAttrs()) {
            H6 { Text("Místo") }
        }

        FlexBoxLayout {
            UvodInfoItem(
                iconSrc = "ic_clock_48.svg",
                text = "22. srpna 2026\nv XX:XX hodin"
            )
            UvodInfoItem(
                iconSrc = "ic_location_pin_48.svg",
                text = "Chalupa v Podbezdězí, Hlínoviště 3,\n294 21 Bělá pod Bezdězem"
            )
        }
    }
}
