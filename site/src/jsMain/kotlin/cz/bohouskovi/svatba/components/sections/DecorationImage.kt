package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import cz.bohouskovi.svatba.components.widgets.ProtectedImage
import org.jetbrains.compose.web.css.DisplayStyle

val DecorationImageStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Block)
        .fillMaxWidth()
}

@Composable
fun DecorationImage(
    src: String,
    modifier: Modifier = Modifier,
    eager: Boolean = false
) {
    ProtectedImage(
        src = src,
        modifier = modifier.then(DecorationImageStyle.toModifier()),
        attrsBuilder = {
            attr("decoding", "async")
            attr("loading", if (eager) "eager" else "lazy")
            attr("fetchpriority", if (eager) "high" else "auto")
        }
    )
}