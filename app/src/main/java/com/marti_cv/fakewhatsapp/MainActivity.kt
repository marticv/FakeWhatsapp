package com.marti_cv.fakewhatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.marti_cv.fakewhatsapp.ui.FakeWhatsappScreen
import com.marti_cv.fakewhatsapp.ui.FakeWhatsappScreenViewModel
import com.marti_cv.fakewhatsapp.ui.theme.FakeWhatsappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: FakeWhatsappScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FakeWhatsappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FakeWhatsappScreen(viewModel)
                }
            }
        }
    }
}

