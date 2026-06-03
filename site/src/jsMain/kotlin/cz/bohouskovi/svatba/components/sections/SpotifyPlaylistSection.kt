package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toAttrs
import cz.bohouskovi.svatba.FootNoteTextStyle
import cz.bohouskovi.svatba.components.widgets.PillLinkButton
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

private const val SPOTIFY_PLAYLIST_URL =
    "https://open.spotify.com/playlist/5dVDLaWIyam0lDZ3kdcfop?si=2d041a3619c9405d&pt=0505e160da94c273facee1936831ed98"

@Composable
fun SpotifyPlaylistSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("playlist"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        H2 { Text("Svatební playlist") }

        P(
            attrs = Modifier
                .maxWidth(48.cssRem)
                .toAttrs()
        ) {
            Text("Pomozte nám roztančit večer! Pokud máte písničku, která podle vás nesmí na svatbě chybět, přidejte ji prosím do našeho společného Spotify playlistu.")
        }

        PillLinkButton(
            href = SPOTIFY_PLAYLIST_URL,
            text = "Přidat písničku na Spotify",
            openInNewTab = true,
            bottomMargin = 0.cssRem,
        )

        P(FootNoteTextStyle.toAttrs()) {
            Text("Pokud by odkaz přestal fungovat, dejte nám prosím vědět.")
        }
    }
}
