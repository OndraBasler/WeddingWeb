package cz.bohouskovi.svatba.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Img
import org.w3c.dom.HTMLImageElement

@Composable
fun ProtectedImage(
    src: String,
    alt: String = "",
    modifier: Modifier = Modifier,
    attrsBuilder: (AttrsScope<HTMLImageElement>.() -> Unit)? = null
) {
    val protectedModifier = modifier.styleModifier {
        property("-webkit-user-drag", "none")
        property("user-drag", "none")
    }
    Img(src = src, attrs = protectedModifier.toAttrs {
        attr("alt", alt)
        attr("draggable", "false")
        onContextMenu { it.preventDefault() }
        attrsBuilder?.invoke(this)
    })
}
