package com.marti_cv.fakewhatsapp.ui.composables.info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatNameGroup(
    chatName: String,
    changeChatName: (String) -> Unit,
    onClick: () -> Unit,
    isButtonEnabled: Boolean
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Elige el nombre que se mostrará en el chat. Minimo 3 caracteres")
        TextField(
            value = chatName,
            onValueChange = { changeChatName(it) },
            maxLines = 1,
            singleLine = true
        )
        Text(text = "Nombre en el chat: $chatName")
        Button(
            onClick = { onClick() },
            enabled = isButtonEnabled
        ) {
            Text(text = "Continuar")
        }
    }
}