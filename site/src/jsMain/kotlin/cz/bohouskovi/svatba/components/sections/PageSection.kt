package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import cz.bohouskovi.svatba.HeadlineTextStyle
import cz.bohouskovi.svatba.SubheadlineTextStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PageSection(id: String, title: String, description: String) {
    Div(Modifier.id(id).toAttrs()) {
        Div(HeadlineTextStyle.toAttrs()) {
            H2 { Text(title) }
        }
        Div(SubheadlineTextStyle.toAttrs()) {
            P { Text(description) }
        }
    }
}
