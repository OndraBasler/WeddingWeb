package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun InformaceSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("informace"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        H2 { Text("Základní informace") }
        P {
            Text("Svatba bude probíhat na Chalupě v Podbezdězí.")
            Br()
            Text("V sobotu se bude začínat obřadem ve 12:00. Prosíme všechny hosty, aby dorazili nejpozději do 11:30, abychom mohli společně zahájit obřad včas.")
            Br()
            Text("Pokud bude hezké počasí, bude obřad probíhat v sadu u chalupy. V případě deště se na obřad přesuneme do stodoly.")
            Br()
            Text("Končit budeme v neděli dopoledne okolo 11:00.")
        }
        P {
            Text("Budeme rádi, když zvolíte oblečení, ve kterém se cítíte dobře a které se hodí ke slavnostní příležitosti. Formální dress code nestanovujeme – přijďte tak, jak to cítíte.")
        }
    }
}
