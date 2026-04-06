package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

val DecorationImageStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Block)
        .fillMaxWidth()
}

@Composable
fun DecorationImage(src: String) {
    Div(attrs = {
        attr("style", "width:100vw;position:relative;left:50%;right:50%;margin-left:-50vw;margin-right:-50vw;")
    }) {
        Img(src = src, attrs = DecorationImageStyle.toModifier().toAttrs())
    }
}