package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.components.overlay.OverlayVars
import com.varabyte.kobweb.silk.style.toAttrs
import cz.bohouskovi.svatba.HeadlineTextStyle
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun TransportInfoSection() {
    var isMapZoomed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth().id("doprava"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Div(HeadlineTextStyle.toAttrs()) {
            H6 { Text("Doprava") }
        }
        P {
            Text("Doprava je možná autem anebo velmi obtížně hromadnou dopravou do Bělé pod Bezdězem. Proto doporučujeme dopravu autem.")
        }
        P {
            Text("Pro parkování je vyhrazen dostatečný počet míst v blízkosti svatebního místa. Je velmi snadné odbočku na svatební místo přejet. Pokud pojedete od Mladé Boleslavi, sjíždí se doleva. Místo je označeno žebřiňákem s velkým nápisem \"svatba\".")
        }

        Img(src = "mapka_2026.webp", attrs = {
            attr(
                "style",
                "width:100%;max-width:48rem;aspect-ratio:16/9;object-fit:cover;border-radius:0.75rem;cursor:zoom-in;box-shadow:0 0.5rem 1.5rem rgba(0,0,0,0.18);"
            )
            attr("alt", "Mapa příjezdu a parkování")
            attr("title", "Kliknutím mapu zvětšíte")
            attr("decoding", "async")
            attr("loading", "lazy")
            onClick { isMapZoomed = true }
        })
    }

    if (isMapZoomed) {
        Overlay(
            Modifier
                .setVariable(OverlayVars.BackgroundColor, Colors.Black.copyf(alpha = 0.8f))
                .zIndex(1000)
                .onClick { isMapZoomed = false }
        ) {
            Div(attrs = {
                attr(
                    "style",
                    "width:100vw;height:100vh;display:flex;align-items:center;justify-content:center;padding:1rem;box-sizing:border-box;"
                )
            }) {
                Img(src = "mapka_2026.webp", attrs = {
                    attr(
                        "style",
                        "max-width:94vw;max-height:92vh;border-radius:0.75rem;cursor:zoom-out;box-shadow:0 1rem 3rem rgba(0,0,0,0.35);"
                    )
                    attr("alt", "Zvětšená mapa příjezdu a parkování")
                    attr("decoding", "async")
                })
            }
        }
    }
}
