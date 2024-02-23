package com.marti_cv.fakewhatsapp.ui.composables.header

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marti_cv.fakewhatsapp.ui.theme.TopIconTint

@Composable
fun IconsGroup(modifier: Modifier){
    Row() {
        Icon(
            imageVector = Icons.Filled.Videocam,
            contentDescription = "camera icon",
            tint = TopIconTint,
            modifier = modifier
                .padding(vertical = 16.dp, horizontal = 8.dp)
        )
        Icon(
            imageVector = Icons.Default.Call,
            contentDescription = "call icon",
            tint = TopIconTint,
            modifier = modifier
                .padding(vertical = 16.dp, horizontal = 8.dp)
        )
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "menu icon",
            tint = TopIconTint,
            modifier = modifier
                .padding(vertical = 16.dp, horizontal = 4.dp),
        )
    }
}