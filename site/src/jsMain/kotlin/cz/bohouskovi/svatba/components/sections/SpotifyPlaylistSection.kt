package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.Opacity
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toAttrs
import cz.bohouskovi.svatba.HeadlineTextStyle
import cz.bohouskovi.svatba.components.widgets.PillLinkButton
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

private const val SPOTIFY_PLAYLIST_URL = "https://open.spotify.com/playlist/5dVDLaWIyam0lDZ3kdcfop?si=2d041a3619c9405d&pt=0505e160da94c273facee1936831ed98"

@Composable
fun SpotifyPlaylistSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("playlist"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Div(HeadlineTextStyle.toAttrs()) {
            H6 { Text("Svatební playlist") }
        }

        P(
            attrs = Modifier
                .maxWidth(48.cssRem)
                .margin(top = 0.px, bottom = 1.cssRem)
                .textAlign(TextAlign.Center)
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

        P(
            attrs = Modifier
                .textAlign(TextAlign.Center)
                .fontSize(0.875.cssRem)
                .opacity(0.75)
                .toAttrs()
        ) {
            Text("Pokud by odkaz přestal fungovat, dejte nám prosím vědět.")
        }
    }
}
