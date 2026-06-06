package cz.bohouskovi.svatba.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import cz.bohouskovi.svatba.FootNoteTextStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

private data class TimelineItem(
    val time: String,
    val title: String,
)

private val timelineItems = listOf(
    TimelineItem("12:00–12:45", "Obřad*"),
    TimelineItem("12:45–13:30", "Gratulace, společné focení"),
    TimelineItem("13:30", "Přípitek, oběd"),
    TimelineItem("14:30", "Focení novomanželů"),
    TimelineItem("15:30", "Hod kytky, dort"),
    TimelineItem("17:00", "Hry s novomanžely, otevření rautu"),
    TimelineItem("19:00–00:00", "První tanec, grilovačka, zpívání a párty"),
)

@Composable
private fun TimelineItemView(item: TimelineItem, isLast: Boolean) {
    Div(attrs = {
        attr(
            "style",
            "display:grid;grid-template-columns:minmax(5.8rem,7.5rem) 1.25rem minmax(0,1fr);" +
                    "column-gap:clamp(0.6rem,2vw,1rem);align-items:start;position:relative;width:100%;box-sizing:border-box;"
        )
    }) {
        Div(attrs = {
            attr(
                "style",
                "font-weight:700;color:#7b4a34;font-size:clamp(0.92rem,2.4vw,1.05rem);line-height:1.35;" +
                        "letter-spacing:0.01em;padding-top:0.08rem;text-align:right;white-space:normal;"
            )
        }) {
            Text(item.time)
        }

        Div(attrs = {
            attr(
                "style",
                "position:relative;min-height:${if (isLast) "1.6rem" else "3.75rem"};display:flex;justify-content:center;"
            )
        }) {
            if (!isLast) {
                Div(attrs = {
                    attr(
                        "style",
                        "position:absolute;top:1.15rem;bottom:-0.25rem;width:2px;background:linear-gradient(180deg,#d8a48f,#ead2c6);"
                    )
                })
            }
            Div(attrs = {
                attr(
                    "style",
                    "width:0.82rem;height:0.82rem;border-radius:50%;background:#a9664f;border:0.22rem solid #fff7f2;" +
                            "box-shadow:0 0 0 1px rgba(169,102,79,0.22),0 0.35rem 0.9rem rgba(169,102,79,0.28);margin-top:0.18rem;"
                )
            })
        }

        Div(attrs = {
            attr(
                "style",
                "padding:0 0 ${if (isLast) "0" else "1.35rem"};font-size:clamp(1rem,2.6vw,1.18rem);" +
                        "line-height:1.45;color:#2f2521;font-weight:600;"
            )
        }) {
            Text(item.title)
        }
    }
}

@Composable
fun HarmonogramSection() {
    Column(
        modifier = Modifier.fillMaxWidth().id("harmonogram"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        H2 { Text("Harmonogram") }

        Div(attrs = {
            attr(
                "style",
                "width:95%;display:flex;justify-content:center;margin:1rem auto 0rem;box-sizing:border-box;"
            )
        }) {
            Div(attrs = {
                attr(
                    "style",
                    "width:100%;max-width:46rem;box-sizing:border-box;padding:clamp(1.1rem,4vw,2.2rem);" +
                            "border-radius:1.5rem;background:linear-gradient(135deg,rgba(255,255,255,0.96),rgba(255,247,241,0.9));" +
                            "border:1px solid rgba(169,102,79,0.16);box-shadow:0 1rem 2.5rem rgba(73,45,34,0.12);"
                )
            }) {
                timelineItems.forEachIndexed { index, item ->
                    TimelineItemView(item, isLast = index == timelineItems.lastIndex)
                }
            }
        }
        P(FootNoteTextStyle.toModifier().maxWidth(48.cssRem).toAttrs()) {
            Text("* Aby naše svatební fotografie zůstaly co nejkrásnější a nic nerušilo kouzlo obřadu, prosíme vás, abyste během obřadu nepoužívali mobilní telefony ani fotoaparáty. O fotografie se postará profesionální fotograf. ")
        }
    }
}
