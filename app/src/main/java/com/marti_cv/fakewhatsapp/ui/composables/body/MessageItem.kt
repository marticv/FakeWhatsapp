package com.marti_cv.fakewhatsapp.ui.composables.body

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marti_cv.fakewhatsapp.ui.model.MessageModel

@Composable
fun MessageItem(message: MessageModel) {
    val text = message.text
    val time = message.time
    val isFromUser = message.isFromUser

    Row(
        modifier = Modifier.fillMaxWidth().padding(12.dp),
        horizontalArrangement = if (isFromUser) {
            Arrangement.End
        } else {
            Arrangement.Start
        }
    ) {
        if (isFromUser) {
            MyMessage(text = text, time = time)
        } else {
            FakeMessage(text = text, time = time)
        }
    }
}