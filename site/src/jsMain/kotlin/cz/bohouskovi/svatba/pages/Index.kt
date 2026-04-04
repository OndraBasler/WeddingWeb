package cz.bohouskovi.svatba.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import cz.bohouskovi.svatba.components.sections.*
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.vh

@InitRoute
fun initHomePage(ctx: InitRouteContext) {
}

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    Column(Modifier.fillMaxWidth().padding(bottom = 20.vh)) {
        UvodSection()
        ONasSection()
        InformaceSection()
        HarmonogramSection()
        RsvpSection()
        GalerieSection()
        KontaktySection()
    }
}
