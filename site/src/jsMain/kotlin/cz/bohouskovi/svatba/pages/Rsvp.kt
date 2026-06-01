package cz.bohouskovi.svatba.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import cz.bohouskovi.svatba.components.sections.DecorationImage
import cz.bohouskovi.svatba.components.sections.RsvpSection

@Page("/rsvp")
@Layout(".components.layouts.PageLayout")
@Composable
fun RsvpPage() {
    Column(Modifier.fillMaxWidth()) {
        DecorationImage("wedding_decoration_apples.webp")
        RsvpSection()
        DecorationImage("wedding_decoration_field.webp")
    }
}
