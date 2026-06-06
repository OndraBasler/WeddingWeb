package cz.bohouskovi.svatba

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.events.Event

private const val INITIAL_RESOURCE_TIMEOUT_MS = 5_000

@InitSilk
fun initStyles(ctx: InitSilkContext) {
    ctx.stylesheet.apply {
        registerStyleBase("body") { Modifier.scrollBehavior(ScrollBehavior.Smooth) }
    }
}

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    var resourcesReady by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        waitForInitialResources { resourcesReady = true }
    }

    SilkApp {
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh)) {
            Div(attrs = {
                attr(
                    "style",
                    "min-height:100vh;opacity:${if (resourcesReady) "1" else "0"};" +
                        "transition:opacity 700ms ease;"
                )
            }) {
                content()
            }

            if (!resourcesReady) {
                InitialLoadingScreen()
            }
        }
    }
}

@Composable
private fun InitialLoadingScreen() {
    Div(attrs = {
        attr(
            "style",
            "position:fixed;inset:0;z-index:9999;display:flex;align-items:center;justify-content:center;" +
                "background:#FBFCF7;color:#7b4a34;font-family:Quicksand,-apple-system,BlinkMacSystemFont," +
                "Segoe UI,sans-serif;transition:opacity 300ms ease;"
        )
    }) {
        Div(attrs = {
            attr(
                "style",
                "padding:1rem 1.5rem;border-radius:999px;background:rgba(255,255,255,0.72);" +
                    "box-shadow:0 0.75rem 2rem rgba(123,74,52,0.16);font-weight:600;letter-spacing:0.02em;"
            )
        }) {
            Text("Načítáme svatební web…")
        }
    }
}

private fun waitForInitialResources(onReady: () -> Unit) {
    var isReady = false

    fun finish() {
        if (!isReady) {
            isReady = true
            onReady()
        }
    }

    val timeout = window.setTimeout({ finish() }, INITIAL_RESOURCE_TIMEOUT_MS)

    waitForWindowLoad {
        waitForFonts {
            waitForInitialImages {
                window.clearTimeout(timeout)
                finish()
            }
        }
    }
}

private fun waitForWindowLoad(onLoaded: () -> Unit) {
    if (document.asDynamic().readyState == "complete") {
        onLoaded()
        return
    }

    window.addEventListener(
        type = "load",
        callback = { onLoaded() },
        options = js("{ once: true }")
    )
}

private fun waitForFonts(onLoaded: () -> Unit) {
    val fontsReady = document.asDynamic().fonts?.ready

    if (fontsReady == null) {
        onLoaded()
        return
    }

    fontsReady.then(
        onFulfilled = { onLoaded() },
        onRejected = { onLoaded() }
    )
}

private fun waitForInitialImages(onLoaded: () -> Unit) {
    val images = buildList {
        val documentImages = document.images

        for (index in 0 until documentImages.length) {
            val image = documentImages.item(index) as? HTMLImageElement ?: continue
            val isLazy = image.getAttribute("loading") == "lazy"
            val rect = image.getBoundingClientRect()
            val isNearViewport = rect.top < window.innerHeight + 400

            if (!isLazy && isNearViewport && image.src.isNotBlank()) {
                add(image)
            }
        }
    }

    if (images.isEmpty()) {
        onLoaded()
        return
    }

    var pendingImages = images.size

    fun markImageComplete() {
        pendingImages -= 1
        if (pendingImages == 0) {
            onLoaded()
        }
    }

    images.forEach { image: HTMLImageElement ->
        if (image.complete && image.naturalWidth > 0) {
            markImageComplete()
        } else {
            waitForImage(image, ::markImageComplete)
        }
    }
}

private fun waitForImage(image: HTMLImageElement, onLoaded: () -> Unit) {
    val decode = image.asDynamic().decode

    if (decode != null) {
        image.asDynamic().decode().then(
            onFulfilled = { onLoaded() },
            onRejected = { onLoaded() }
        )
        return
    }

    val listener: (Event) -> Unit = { onLoaded() }
    val options = js("{ once: true }")
    image.addEventListener("load", listener, options)
    image.addEventListener("error", listener, options)
}
