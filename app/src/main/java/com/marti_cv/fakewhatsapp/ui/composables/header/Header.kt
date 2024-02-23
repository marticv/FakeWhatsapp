package com.marti_cv.fakewhatsapp.ui.composables.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marti_cv.fakewhatsapp.ui.composables.header.IconsGroup
import com.marti_cv.fakewhatsapp.ui.composables.header.UserGroup
import com.marti_cv.fakewhatsapp.ui.theme.Background


@Composable
fun Header(modifier: Modifier, onClickBack: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Background),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ) {
        UserGroup(modifier = modifier, onClickBack={onClickBack()})
        IconsGroup(modifier = modifier)
    }
}