package com.marti_cv.fakewhatsapp.ui.composables.body

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            item {
                MyMessage(
                    text = "hi",
                    time = "18:00",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            item {
                MyMessage(
                    text = "Im fine",
                    time = "18:01",
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    }
}