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
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Iframe
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

private const val SPOTIFY_PLAYLIST_ID = "5dVDLaWIyam0lDZ3kdcfop"
private const val SPOTIFY_EMBED_URL = "https://open.spotify.com/embed/playlist/$SPOTIFY_PLAYLIST_ID"

@Composable
fun SpotifyPlaylistSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("playlist").padding(bottom = 2.cssRem),
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
