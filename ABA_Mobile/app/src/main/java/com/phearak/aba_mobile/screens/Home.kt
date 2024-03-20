package com.phearak.aba_mobile.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phearak.aba_mobile.ui.theme.Primary
import com.phearak.aba_mobile.ui.theme.Secondary

@Composable
fun Home(){
    val screen = LocalConfiguration.current.screenWidthDp.dp

    Column() {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Secondary)
                ) {
                    Layout(
                        content = {
                            IconWithText(Icons.Rounded.AccountBox, "Accounts", Brush.horizontalGradient(listOf(Primary, Color.White)))
                            IconWithText(Icons.Rounded.Email, "Cards", Brush.horizontalGradient(listOf(Primary, Color.White)))
                            IconWithText(Icons.Rounded.AccountBox, "Payment", Brush.horizontalGradient(listOf(Primary, Color.White)))
                            IconWithText(Icons.Rounded.AccountBox, "New Account", Brush.horizontalGradient(listOf(Color.White, Primary)))
                            IconWithText(Icons.Rounded.AccountBox, "E-Cash", Brush.horizontalGradient(listOf(Color.White, Primary)))
                            IconWithText(Icons.Rounded.AccountBox, "Transfer", Brush.horizontalGradient(listOf(Color.White, Primary)))
                            IconWithText(Icons.Rounded.AccountBox, "ABA Scan", Brush.horizontalGradient(listOf(Color.White, Primary)))
                            IconWithText(Icons.Rounded.AccountBox, "Loans", Brush.horizontalGradient(listOf(Color.White, Primary)))
                            IconWithText(Icons.Rounded.AccountBox, "Services", Brush.horizontalGradient(listOf(Color.White, Primary)))
                        }
                    ) { measurables, constraints ->
                        val itemWidth = constraints.maxWidth / 3
                        val itemConstraints = constraints.copy(
                            minWidth = itemWidth,
                            maxWidth = itemWidth,
                            minHeight = itemWidth,
                            maxHeight = itemWidth
                        )

                        val placeables = measurables.map { measurable ->
                            measurable.measure(itemConstraints)
                        }

                        layout(constraints.maxWidth, constraints.maxHeight) {
                            var xPosition = 0
                            var yPosition = 0

                            placeables.forEach { placeable ->
                                placeable.placeRelative(xPosition, yPosition)
                                xPosition += itemWidth

                                if (xPosition >= constraints.maxWidth) {
                                    xPosition = 0
                                    yPosition += itemWidth
                                }
                            }
                        }
                    }
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(50.dp)
            ){
                Text(text = "Hello")
            }
        }
    }
}

@Composable
fun IconWithText(icon: ImageVector, label: String, gradient: Brush,) {
    val screen = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = Modifier
            .width(screen / 3)
            .aspectRatio(1f)
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            drawRect(
                brush = gradient,
                size = size,
                style = Stroke(width = 0.5.dp.toPx())
            )
        }

        Column(
            modifier = Modifier
                .matchParentSize()
                .padding(0.5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Icon(
            icon,
            tint = Color.White,
            contentDescription = "Notifications",
            modifier = Modifier
                .width(screen / 3)
                .aspectRatio(2.7f)
        )
        Text(
            text = label,
            color = Color.White,
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
        }
    }
}
