package com.adaptics.dashboard

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Height
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    SilkApp {
        Surface(
            SmoothColorStyle
                .toModifier()
                .backgroundColor(Color("#1c1c1c"))
                .fontFamily("Arial", "sans-serif")
                .color(Color.white)
                .textAlign(TextAlign.Center)
                .margin(0.px)
        ) {
            content()
        }
    }
}
