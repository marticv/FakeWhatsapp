package com.marti_cv.fakewhatsapp.ui.composables.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marti_cv.fakewhatsapp.ui.theme.ResponseBubble
import com.marti_cv.fakewhatsapp.ui.theme.ResponseText

@Composable
fun FakeMessage(text: String, time: String) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val maxTextWith = screenWidth * 3 / 5

    Card {
        Row(
            modifier = Modifier
                .background(ResponseBubble)
        ) {
            Text(
                text = text,
                color = ResponseText,
                modifier = Modifier
                    .padding(top = 6.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .widthIn(0.dp, maxTextWith.dp)
            )
            Text(
                text = time,
                fontSize = 10.sp,
                color = ResponseText,
                modifier = Modifier
                    .padding(bottom = 4.dp, end = 8.dp)
                    .align(Alignment.Bottom)
            )
        }
    }
}