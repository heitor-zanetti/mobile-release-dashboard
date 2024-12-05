package com.adaptics.dashboard.components

import androidx.compose.runtime.Composable
import com.adaptics.dashboard.DivClass
import com.adaptics.dashboard.components.view_entity.ReleaseViewEntity
import com.adaptics.dashboard.util.getCurrentDateFormatted
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.css.fontWeight
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.minWidth
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Style
import org.jetbrains.compose.web.dom.Text

@Composable
fun ReleasePage(releaseCardItems: List<ReleaseViewEntity>) {
    val mappedReleases = releaseCardItems.groupBy { it.date }

    PageStyle()

    DivClass("dashboard") {
        H1 { Text("Mobile Release Dashboard") }
        H2 { Text("See what the Mobile Team is cooking right now!") }

        Div {
            if (!mappedReleases.keys.contains(getCurrentDateFormatted())) {
                EmptyState()
            }

            mappedReleases.forEach { (date, releases) ->
                DateHeader(date)

                releases.forEach { release ->
                    ReleaseCard(viewEntity = release)
                }
            }
        }
    }
}

@Composable
private fun PageStyle() = Style {
    ".dashboard" style {
        maxWidth(600.px)
        minWidth(600.px)
        margin(0.px, autoLength)
        minHeight(100.vh)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        justifyContent(JustifyContent.Center)
    }

    "h1" style {
        fontSize(2.cssRem)
        marginBottom(0.px)
    }

    "h2" style {
        fontSize(1.cssRem)
        fontWeight(FontWeight.Normal)
        marginBottom(10.px)
    }
}