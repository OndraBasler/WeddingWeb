package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import cz.bohouskovi.svatba.components.widgets.PillLinkButton
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.*

private const val SPOTIFY_PLAYLIST_ID = "1ctD6iljDZ7sM7icHFXtSk"
private const val SPOTIFY_EMBED_URL = "https://open.spotify.com/embed/playlist/$SPOTIFY_PLAYLIST_ID"

@Composable
fun SpotifyPlaylistSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("playlist").padding(bottom = 2.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        H2 { Text("Taneční playlist") }

        P(
            attrs = Modifier
                .maxWidth(48.cssRem)
                .toAttrs()
        ) {
            Text("Pomozte nám roztančit večer! Pokud máte písničku, na kterou si chcete zatancovat, přidejte ji prosím do našeho společného Spotify playlistu.")
        }

        PillLinkButton(
            href = "https://open.spotify.com/playlist/1ctD6iljDZ7sM7icHFXtSk?si=615e96ac10e34847&pt=e75cc8d41a80906e485e65ef8901c938",
            text = "Přidej písničku",
            openInNewTab = true,
            bottomMargin = 0.cssRem,
        )

        Small(
            attrs = Modifier
                .maxWidth(48.cssRem)
                .padding(topBottom = 0.5.cssRem, leftRight = 1.cssRem)
                .toAttrs()
        ) {
            Text("Pokud odkaz přestane fungovat, dejte nám prosím vědět.")
        }

        Iframe(attrs = Modifier.padding(leftRight = 1.cssRem).toAttrs{
            attr("src", SPOTIFY_EMBED_URL)
            attr("width", "100%")
            attr("height", "380")
            attr("frameborder", "0")
            attr("allow", "autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture")
            attr("loading", "lazy")
            style {
                property("max-width", "48rem")
                property("border-radius", "12px")
            }
        })
    }
}
