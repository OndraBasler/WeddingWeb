package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import org.jetbrains.compose.web.dom.*

@Composable
fun AccomodationSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("ubytovani"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        H2 { Text("Ubytování") }
        P {
            Text("Ubytování bude možné v chalupě, na špejcharu, v přístřešku anebo si můžete postavit vlastní stan v sadu. V chalupě budou spát starší členové rodiny. Na špejchar se vejde 15 lidí a v přístřešku taky asi 10 lidí. Kromě ubytování v chalupě je u všech dalších možností potřeba si dovést spacák a karimatku.")
        }
        P {
            Text(" Pokud by vám tyto možnosti nevyhovovali, je možné přespat v některém z blízkých penzionů. Doporučené penziony jsou:")
            Br()
            A(href = "https://www.slaskoukarel.cz/pension-bezdez/") {
                Text("Pension Bezděz")
            }
            Br()
            A(href = "https://www.restauracevzalesi.cz/") {
                Text("Restaurace v Zálesí")
            }
        }
        P {
            Text("Stavění stanů bude možné od 19:00, do té doby bude sad sloužit pro jiné účely (hry, focení, posezení).")
        }
    }
}
