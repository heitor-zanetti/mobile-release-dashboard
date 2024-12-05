package com.adaptics.dashboard.components

import androidx.compose.runtime.Composable
import com.adaptics.dashboard.DivClass
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.textAlign
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Style
import org.jetbrains.compose.web.dom.Text

@Composable
fun DateHeader(date: String) {
    DateStyle()

    DivClass("date") {
        Text(date)
    }
}

@Composable
private fun DateStyle() = Style {
    ".date" style {
        width(100.percent)
        fontSize(1.cssRem)
        backgroundColor(Color("#2c2c2c"))
        padding(10.px)
        marginBottom(10.px)
        marginTop(60.px)
        textAlign(TextAlign.Start)
        color(Color("#9c9c9c"))
        borderRadius(10.px)
    }
}
