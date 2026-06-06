package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import cz.bohouskovi.svatba.components.widgets.PillLinkButton
import org.jetbrains.compose.web.dom.*

private const val GOOGLE_FORM_EMBED_URL =
    "https://docs.google.com/forms/d/e/1FAIpQLSf4EsMY3nYfdO2HF9qIfV5jhWyDuoOy7ZZceMNDAbYovUIKkA/viewform?embedded=true"

@Composable
fun RsvpPreviewSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("rsvp"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        P {
            Text("Zde prosím vyplňte dotazník ohledně účasti na naší svatbě:")
        }
        PillLinkButton(
            href = sitePath(RSVP_PAGE_PATH),
            text = "Vyplnit RSVP",
        )
    }
}

@Composable
fun RsvpSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("rsvp"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        H2 { Text("RSVP") }
        P {
            Text("Prosíme, potvrďte nám účast vyplněním krátkého formuláře. Pomůže nám to doladit jídlo, ubytování i dopravu. Stačí, když to vyplní jeden zástupce ve skupince.")
        }

        Iframe(attrs = {
            attr("src", GOOGLE_FORM_EMBED_URL)
            attr("width", "100%")
            attr("height", "900")
            attr("frameborder", "0")
            attr("marginheight", "0")
            attr("marginwidth", "0")
            attr("title", "RSVP formulář")
            attr(
                "style",
                "width:100%;max-width:48rem;border:0;border-radius:0.75rem;background:white;box-shadow:0 0.5rem 1.5rem rgba(0,0,0,0.08);"
            )
        }) {
            Text("Načítám RSVP formulář…")
        }
        P(attrs = { attr("style", "font-size:0.95rem;") }) {
            Text("Pokud se formulář nezobrazuje správně, otevřete ho ")
            A(href = GOOGLE_FORM_EMBED_URL, attrs = {
                attr("target", "_blank")
                attr("rel", "noopener noreferrer")
            }) {
                Text("v novém okně")
            }
            Text(".")
        }
    }
}

@Composable
private fun RsvpQuestion(title: String, detail: String) {
    Li {
        Span(attrs = { attr("style", "font-weight:600;") }) {
            Text(title)
        }
        Text(" – $detail")
    }
}
