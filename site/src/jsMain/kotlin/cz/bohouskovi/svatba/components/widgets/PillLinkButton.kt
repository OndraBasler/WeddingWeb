package cz.bohouskovi.svatba.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

private val BrownColor = Color.rgb(0x7b, 0x4a, 0x34)

@Composable
fun PillLinkButton(
    href: String,
    text: String,
    openInNewTab: Boolean = false,
    bottomMargin: CSSLengthOrPercentageNumericValue = 2.cssRem,
) {
    Link(
        path = href,
        modifier = Modifier
            .display(DisplayStyle.InlineBlock)
            .margin(topBottom = 0.5.cssRem, leftRight = 0.px)
            .margin(bottom = bottomMargin)
            .padding(topBottom = 0.75.cssRem, leftRight = 1.25.cssRem)
            .borderRadius(999.px)
            .backgroundColor(BrownColor)
            .color(Colors.White)
            .textDecorationLine(TextDecorationLine.None)
            .fontWeight(FontWeight.Bold)
            .boxShadow(
                offsetX = 0.px,
                offsetY = 0.45.cssRem,
                blurRadius = 1.cssRem,
                color = Color.rgba(0x7b, 0x4a, 0x34, 0x38)
            ),
        openInternalLinksStrategy = if (openInNewTab) com.varabyte.kobweb.navigation.OpenLinkStrategy.IN_NEW_TAB else com.varabyte.kobweb.navigation.OpenLinkStrategy.IN_PLACE,
        openExternalLinksStrategy = if (openInNewTab) com.varabyte.kobweb.navigation.OpenLinkStrategy.IN_NEW_TAB else com.varabyte.kobweb.navigation.OpenLinkStrategy.IN_PLACE,
        variant = UncoloredLinkVariant,
    ) {
        Text(text)
    }
}
