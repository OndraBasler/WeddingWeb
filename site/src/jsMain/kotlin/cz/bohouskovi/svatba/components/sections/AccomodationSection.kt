package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.silk.style.toAttrs
import cz.bohouskovi.svatba.HeadlineTextStyle
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AccomodationSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("accomodation"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Div(HeadlineTextStyle.toAttrs()) {
            H6 { Text("Ubytování") }
        }
        P {
            Text("Ubytování bude možné v chalupě, na špejcharu v přístřešku v sadu a nebo si můžete postavit vlastní stan. V chalupě budou spát starší členové rodiny. Na špejchar se vejde 15 lidí a v přístřešku taky asi 10 lidí. Pokud by vám tyto možnosti nevyhovovali, je možné přespat v některém z blízkých penzionů.")
        }
        P {
            Text("Doporučené penziony jsou:")
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
