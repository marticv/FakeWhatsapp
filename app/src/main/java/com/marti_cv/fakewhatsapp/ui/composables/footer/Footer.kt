package com.marti_cv.fakewhatsapp.ui.composables.footer

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Footer(
    text: String,
    onTextChanged: (String) -> Unit,
    onCreateMessage: (String) -> Unit,
    onIconPressed: (String) -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 4.dp)
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.Bottom
    ) {
        InputRow(
            text = text,
            onTextChanged = { onTextChanged(it) },
            onIconPressed ={onIconPressed(text)},
            modifier = modifier.padding(start = 2.dp)
        )
        Spacer(modifier = modifier.width(4.dp))
        MicroButton(text = text, onCreateMessage = { onCreateMessage(text) }, modifier = modifier)
    }
}