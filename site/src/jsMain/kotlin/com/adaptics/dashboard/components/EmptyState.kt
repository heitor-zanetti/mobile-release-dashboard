package com.adaptics.dashboard.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Style
import org.jetbrains.compose.web.dom.Text

@Composable
fun EmptyState() {
    EmptyStateStyle()

    Column(
        modifier = Modifier.padding {
            top(60.px)
            bottom(20.px)
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            src = "travolta.gif",
            modifier = Modifier
                .size(200.px)
                .padding { bottom(20.px) }

        )

        Text("No much going on right now. See past releases below.")
    }
}

@Composable
private fun EmptyStateStyle() = Style {

}