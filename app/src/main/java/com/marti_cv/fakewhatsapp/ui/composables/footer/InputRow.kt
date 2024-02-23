package com.marti_cv.fakewhatsapp.ui.composables.footer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.marti_cv.fakewhatsapp.ui.theme.Background
import com.marti_cv.fakewhatsapp.ui.theme.BottomIconTint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputRow(modifier: Modifier) {
    var text: String by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(Background),
        verticalAlignment = Alignment.Bottom
    ) {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp

        Icon(
            imageVector = Icons.Filled.Mood,
            contentDescription = "emoji icon",
            tint = BottomIconTint,
            modifier = modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
        )
        TextField(
            value = text,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Background,
                textColor = BottomIconTint
            ),
            onValueChange = { text = it },
            placeholder = { Text(text = "Mensaje", color = BottomIconTint) },
            modifier = modifier.width((screenWidth*6/11).dp)
        )
        Icon(
            imageVector = Icons.Default.AttachFile,
            contentDescription = "Attach icon",
            tint = BottomIconTint,
            modifier = modifier
                .padding(vertical = 16.dp)
        )
        Icon(
            imageVector = Icons.Filled.PhotoCamera,
            contentDescription = "Camera Icon",
            tint = BottomIconTint,
            modifier = modifier
                .padding(vertical = 16.dp, horizontal = 8.dp)
        )
    }
}