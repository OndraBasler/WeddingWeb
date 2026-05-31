package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.silk.style.toAttrs
import cz.bohouskovi.svatba.HeadlineTextStyle
import cz.bohouskovi.svatba.SubheadlineTextStyle
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun InformaceSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("informace"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Div(HeadlineTextStyle.toAttrs()) {
            H6 { Text("Informace") }
        }
        P {
            Text("Celá svatba bude probíhat na jednom místě, a to v Chalupě v Podbezdězí.")
            Br()
            Text("V sobotu se bude začínat obřadem ve 12:00. Prosíme všechny hosty, aby dorazili nejpozději do 11:30, abychom mohli společně zahájit obřad včas.")
            Br()
            Text("Pokud bude hezké počasí, bude obřad probíhat v sadu u chalupy. V případě deště se na obřad přesuneme do stodoly.")
            Br()
            Text("Končit budeme v neděli dopoledne v 11:00.")
        }
    }
}
