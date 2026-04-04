package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable

@Composable
fun UvodSection() {
    PageSection(
        id = "uvod",
        title = "Úvod",
        description = "Vítejte na naší svatební stránce. Níže najdete všechny důležité informace."
    )
}
