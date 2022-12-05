package com.example.module1.inputComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

object InputComponents {

    @Composable
    fun CustomInput(
        modifier: Modifier = Modifier,
        text: String = "",
        enabled: Boolean = true,
        onChange: (String) -> Unit = {},
        onDone: ((String) -> Unit)? = null
    ) {
        Column(
            modifier = Modifier
                .then(modifier)
        ) {
            InputTextField(
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 12.dp
                ),
                text = text,
                enabled = enabled,
                onChange = onChange,
                onDone = onDone
            )
        }
    }

    @Composable
    fun InputTextField(
        modifier: Modifier = Modifier,
        text: String = "",
        enabled: Boolean = true,
        onChange: (String) -> Unit = {},
        onDone: ((String) -> Unit)? = null
    ) {
        var inputValue by remember {
            mutableStateOf(
                TextFieldValue(
                    text = text,
                    selection = TextRange(text.length)
                )
            )
        }

        BasicTextField(
            modifier = Modifier
                .then(modifier)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = if (onDone != null) KeyboardActions(onDone = { onDone.invoke(text) }) else KeyboardActions(),
            value = inputValue,
            enabled = enabled,
            onValueChange = { newValue ->
                inputValue = newValue.copy(
                    newValue.text
                )
                onChange.invoke(inputValue.text)
            },
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(horizontal = 20.dp, vertical = 12.dp)


            ) {
                it.invoke()
            }
        }
    }
}
