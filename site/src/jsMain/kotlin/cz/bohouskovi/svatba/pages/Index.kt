package cz.bohouskovi.svatba.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.maxSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import cz.bohouskovi.svatba.components.sections.*
import org.jetbrains.compose.web.css.cssRem

@InitRoute
fun initHomePage(@Suppress("UNUSED_PARAMETER") ctx: InitRouteContext) {
}

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DecorationImage(
            src = "wedding_decoration_kno.webp",
            eager = true,
            modifier = Modifier.padding(leftRight = 4.cssRem).maxSize(40.cssRem)
        )
        IntroSection()
        AboutUsSection()
        InformaceSection()
        RsvpPreviewSection()
        DecorationImage("wedding_decoration_apples.webp")
        TransportInfoSection()
        AccomodationSection()
        HarmonogramSection()
        DecorationImage("wedding_decoration_field.webp")
        GiftSection()
        WitnessSection()
        SpotifyPlaylistSection()
        DecorationImage("wedding_decoration_grass.webp")
    }
}
