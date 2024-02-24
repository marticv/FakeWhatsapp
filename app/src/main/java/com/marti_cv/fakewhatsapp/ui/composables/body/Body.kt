package com.marti_cv.fakewhatsapp.ui.composables.body

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.marti_cv.fakewhatsapp.R

@Composable
fun Body(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.darck_background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                MessageItem(
                    text = "lorem ipsum dolor sit amet consectetur adipiscing elit." +
                            " Duis sed dui at enim lacinia commodo.",
                    time = "12:00",
                    isFromUser = false
                )
            }
            item {
                MessageItem(
                    text = "lorem ipsum dolor sit amet.",
                    time = "12:01",
                    isFromUser = true
                )
            }
        }
    }
}