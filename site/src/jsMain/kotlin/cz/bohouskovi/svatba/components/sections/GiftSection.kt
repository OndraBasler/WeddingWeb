package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import org.jetbrains.compose.web.dom.*

@Composable
fun GiftSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("dary"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        H2 { Text("Dary") }

        P {
            Text("S dary si nemusíte dělat starosti, veškeré vybavení domácnosti máme a jiné hmotné dary nepotřebujeme.")
            Br()
            Text("Pokud byste nám chtěli udělat radost, můžete na svatbu upéct něco sladkého ke kávě.")
            Br()
            Text("Pokud byste nás chtěli podpořit finančně, můžete tak učinit na místě nebo pomocí QR kódu níže.")
        }

        Img(src = "qr_code.webp", attrs = {
            attr("alt", "QR kód pro platbu")
            attr("style", "width:12rem;height:12rem;object-fit:contain;")
        })
    }
}
