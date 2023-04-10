package com.example.podcast.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.podcast.R


@Composable
fun RoundedPositiveButton(
    modifier: Modifier = Modifier,
    textResource: Int,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(53.dp)
            .clip(RoundedCornerShape(30.dp))
            .clickable(enabled = isEnabled) {
                onClick()
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.background(
                if (isEnabled) MaterialTheme.colors.primary else MaterialTheme.colors.primary.copy(
                    alpha = 0.5f
                )
            )
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


@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(58.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .clickable {
                onClick()
            },
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painterResource(id = R.drawable.ic_google), contentDescription = "google button")
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = stringResource(R.string.google),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Composable
fun FacebookButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(58.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .clickable {
                onClick()
            },
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = R.drawable.ic_facebook),
                contentDescription = "google button"
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = stringResource(R.string.facebook),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}