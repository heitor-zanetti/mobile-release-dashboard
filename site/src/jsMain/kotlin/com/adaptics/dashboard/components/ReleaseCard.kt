package com.adaptics.dashboard.components

import androidx.compose.runtime.Composable
import com.adaptics.dashboard.DivClass
import com.adaptics.dashboard.components.view_entity.ReleasePlatformViewEntity
import com.adaptics.dashboard.components.view_entity.ReleaseViewEntity
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.fontWeight
import com.varabyte.kobweb.compose.css.textAlign
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.backgroundImage
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Style
import org.jetbrains.compose.web.dom.Text

@Composable
fun ReleaseCard(viewEntity: ReleaseViewEntity) {
    CardStyle()

    val cardStyle = when (viewEntity.platformData) {
        is ReleasePlatformViewEntity.Android,
        ReleasePlatformViewEntity.Unsupported -> arrayOf("card")
        is ReleasePlatformViewEntity.Ios -> arrayOf("card", "blue")
    }

    DivClass(*cardStyle) {
        DivClass("left") {
            Img(viewEntity.platformData.platformLogo, attrs = { classes("img") })

            DivClass("info") {
                DivClass("version") { Text(viewEntity.version) }
                DivClass("title") { Text(viewEntity.organization) }
            }
        }

        DivClass("right") { Text(viewEntity.status) }
    }
}

@Composable
private fun CardStyle() = Style {
    ".card" style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.SpaceBetween)
        backgroundImage("linear-gradient(45deg, #fd2957, #7e52fe, #c611db, #fc8c1d)")
        borderRadius(10.px)
        padding(15.px)
        marginBottom(15.px)
        color(Color.white)
    }

    ".card.blue" style {
        backgroundImage("linear-gradient(45deg, #9c37a0, #754bbe, #4e47d2, #3b94d6, #33cbc6)")
    }

    ".card .left" style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
    }

    ".card .left img" style {
        width(30.px)
        marginRight(25.px)
    }

    ".card .info" style {
        textAlign(TextAlign.Left)
    }

    ".card .info .version" style {
        fontSize(0.8.cssRem)
    }

    ".card .info .title" style {
        fontSize(1.3.cssRem)
        fontWeight(FontWeight.Bold)
    }

    ".card .right" style {
        fontSize(0.8.cssRem)
        fontWeight(FontWeight.Bold)
        padding(5.px, 10.px)
        borderRadius(5.px)
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        borderRadius(20.px)
        backgroundColor(Color.black)
        color(Color.white)
    }
}