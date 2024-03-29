package com.marti_cv.fakewhatsapp.ui.composables.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marti_cv.fakewhatsapp.ui.theme.MyBubble
import com.marti_cv.fakewhatsapp.ui.theme.MyText


@Composable
fun MyMessage(text: String, time: String) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val maxTextWith = screenWidth * 3 / 5

    Card {
        Row(
            modifier = Modifier
                .background(MyBubble)
        ) {
            Text(
                text = text,
                color = MyText,
                modifier = Modifier
                    .padding(top = 6.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .widthIn(0.dp, maxTextWith.dp)
            )
            Text(
                text = time,
                fontSize = 10.sp,
                color = MyText,
                modifier = Modifier
                    .padding(bottom = 4.dp, end = 8.dp)
                    .align(Alignment.Bottom)
            )
        }
    }
}