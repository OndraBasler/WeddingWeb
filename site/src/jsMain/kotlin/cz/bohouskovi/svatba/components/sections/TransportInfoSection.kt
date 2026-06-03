package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.components.overlay.OverlayVars
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.*

@Composable
fun TransportInfoSection() {
    var isMapZoomed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth().id("doprava"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        H2 { Text("Doprava") }
        P {
            Text("Doprava je možná autem anebo velmi obtížně hromadnou dopravou do Bělé pod Bezdězem. Proto doporučujeme dopravu autem.")
        }
        P {
            Text("Pro parkování je vyhrazen dostatečný počet míst v blízkosti svatebního místa. Je velmi snadné odbočku na svatební místo přejet. Pokud pojedete od Mladé Boleslavi, sjíždí se doleva. Místo je označeno žebřiňákem s velkým nápisem \"svatba\".")
        }

        Img(src = "mapka_2026.webp", attrs = {
            attr(
                "style",
                "width:100%;max-width:48rem;border-radius:0.75rem;cursor:zoom-in;box-shadow:0 0.5rem 1.5rem rgba(0,0,0,0.18);"
            )
            attr("alt", "Mapa příjezdu a parkování")
            attr("title", "Kliknutím mapu zvětšíte")
            attr("decoding", "async")
            attr("loading", "lazy")
            onClick { isMapZoomed = true }
        })
    }

    if (isMapZoomed) {
        val isPortraitViewport = window.innerHeight > window.innerWidth
        val zoomedMapStyle = if (isPortraitViewport) {
            "max-width:92vh;max-height:94vw;border-radius:0.75rem;cursor:zoom-out;" +
                    "box-shadow:0 1rem 3rem rgba(0,0,0,0.35);transform:rotate(90deg);"
        } else {
            "max-width:94vw;max-height:92vh;border-radius:0.75rem;cursor:zoom-out;box-shadow:0 1rem 3rem rgba(0,0,0,0.35);"
        }

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
                    attr("style", zoomedMapStyle)
                    attr("alt", "Zvětšená mapa příjezdu a parkování")
                    attr("decoding", "async")
                })
            }
        }
    }
}
