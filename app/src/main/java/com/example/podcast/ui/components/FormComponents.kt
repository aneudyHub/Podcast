package com.example.podcast.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.podcast.R


@Composable
fun EditText(
    titleResource: Int,
    placeHolderResource: Int = 0,
    value: String,
    keyboardOptions: KeyboardOptions,
    onErrorResource: Int? = null,
    leadingIcon: @Composable (() -> Unit)?,
    onChangedListener: (String) -> Unit,
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    val passwordVisibilityIcon =
        if (isPasswordVisible) R.drawable.baseline_visibility_off else R.drawable.baseline_visibility
    val isPasswordTextField = keyboardOptions.keyboardType == KeyboardType.Password
    Column(
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = titleResource),
                style = MaterialTheme.typography.caption
            )
            if (onErrorResource != null) {
                Text(
                    text = stringResource(id = onErrorResource),
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.error
                )
            }

        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(17.dp)),
        )
        {
            TextField(
                value = TextFieldValue(text = value, selection = TextRange(value.length)),
                onValueChange = {
                    onChangedListener(it.text)
                },
                placeholder = {
                    PlaceholderCustom(textResource = placeHolderResource)
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.body2,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    textColor = MaterialTheme.colors.onSurface
                ),
                visualTransformation = if (isPasswordTextField && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = keyboardOptions,
                leadingIcon = leadingIcon,
                trailingIcon = {
                    if (isPasswordTextField)
                        Icon(
                            painter = painterResource(id = passwordVisibilityIcon),
                            contentDescription = "",
                            modifier = Modifier.clickable {
                                isPasswordVisible = !isPasswordVisible
                            })
                },
                isError = onErrorResource != null
            )

        }
    }

}

@Composable
fun PlaceholderCustom(
    textResource: Int = 0
) {
    Text(
        text = if (textResource == 0) "" else stringResource(id = textResource),
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onSurface
    )
}