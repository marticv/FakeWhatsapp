package com.marti_cv.fakewhatsapp.ui.composables.footer

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marti_cv.fakewhatsapp.ui.theme.BottomButton
import com.marti_cv.fakewhatsapp.ui.theme.TopIconTint

@Composable
fun MicroButton(modifier: Modifier,text:String, onCreateMessage:(String)->Unit) {
    FilledIconButton(
        onClick = { onCreateMessage(text) },
        colors = IconButtonDefaults.filledIconButtonColors(containerColor = BottomButton),
        modifier = modifier.size(56.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Mic,
            contentDescription = "micro icon",
            tint = TopIconTint
        )
    }
}