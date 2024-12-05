package com.adaptics.dashboard

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

@Composable
fun DivClass(vararg classes: String, block: @Composable () -> Unit) {
    Div(attrs = {classes(*classes)}) {
        block()
    }
}