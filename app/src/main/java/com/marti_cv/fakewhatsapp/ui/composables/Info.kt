package com.marti_cv.fakewhatsapp.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun InfoScreen(onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "App para fingir conversaciones de Whatsapp",
            modifier = Modifier.clickable { onClick() })
    }
}