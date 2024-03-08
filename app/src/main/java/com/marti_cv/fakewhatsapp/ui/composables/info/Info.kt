package com.marti_cv.fakewhatsapp.ui.composables.info

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.marti_cv.fakewhatsapp.ui.theme.BottomButton


@Composable
fun InfoScreen(
    onClick: () -> Unit,
    changeChatName: (String) -> Unit,
    chatName: String,
    isDefaultImageSelected: Boolean,
    isButtonEnabled: Boolean,
    imageUri: Uri,
    onUriCHanged: (Uri) -> Unit,
    onPhotoClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        InfoGroup()
        Spacer(modifier = Modifier.padding(12.dp))
        PhotoGroup(
            isDefaultImageSelected,
            imageUri,
            onUriCHanged = { onUriCHanged(it) },
            onPhotoClicked = { onPhotoClicked() })
        Spacer(modifier = Modifier.padding(12.dp))
        ChatNameGroup(
            chatName = chatName,
            changeChatName = changeChatName,
            onClick = { onClick() },
            isButtonEnabled = isButtonEnabled
        )
    }
}