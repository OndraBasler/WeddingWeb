package cz.bohouskovi.svatba.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.core.Page
import kotlinx.browser.window

@Page
@Composable
fun SvatbaPage() {
    LaunchedEffect(Unit) {
        window.location.replace("./")
    }
}
