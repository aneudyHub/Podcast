package com.example.podcast.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RoundedPositiveButton(
    modifier: Modifier = Modifier,
    textResource: Int, onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(53.dp)
            .clip(RoundedCornerShape(30.dp))
            .clickable {
                onClick()
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.background(MaterialTheme.colors.primary)
        ) {
            Text(
                text = stringResource(textResource),
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Composable
fun TertiaryButton(
    modifier: Modifier = Modifier,
    textResource: Int,
    color: Color,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        elevation = 0.dp,
        backgroundColor = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(textResource),
                style = MaterialTheme.typography.button,
                color = color
            )
            Box(
                modifier = Modifier
                    .height(2.dp)
                    .width(8.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(color)
            ) {
            }
        }
    }
}