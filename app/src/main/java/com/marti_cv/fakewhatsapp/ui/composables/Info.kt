package com.marti_cv.fakewhatsapp.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(
    onClick: () -> Unit,
    changeChatName: (String) -> Unit,
    chatName: String,
    isButtonEnabled: Boolean
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "App para fingir conversaciones de Whatsapp. Introduce el nombre del chat.")
        TextField(
            value = chatName,
            onValueChange = { changeChatName(it) },
            maxLines = 1,
            singleLine = true)
        Text(text = "Nombre en el chat: $chatName")
        Button(
            onClick = { onClick() },
            enabled = isButtonEnabled
        ) {
            Text(text = "Continuar")
        }
    }
}