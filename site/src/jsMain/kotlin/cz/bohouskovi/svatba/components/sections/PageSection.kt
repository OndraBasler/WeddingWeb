package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.silk.style.toAttrs
import cz.bohouskovi.svatba.HeadlineTextStyle
import cz.bohouskovi.svatba.SubheadlineTextStyle
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PageSection(id: String, title: String, description: String) {
    Column(
        modifier = Modifier.fillMaxWidth().id(id),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Div(HeadlineTextStyle.toAttrs()) {
            H6 { Text(title) }
        }
        Div(SubheadlineTextStyle.toAttrs()) {
            P { Text(description) }
        }
    }
}
