package com.marti_cv.fakewhatsapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.marti_cv.fakewhatsapp.ui.composables.body.Body
import com.marti_cv.fakewhatsapp.ui.composables.footer.Footer
import com.marti_cv.fakewhatsapp.ui.composables.header.Header
import com.marti_cv.fakewhatsapp.ui.composables.InfoScreen


@Composable
fun FakeWhatsappScreen() {
    var showScreen: Boolean by rememberSaveable {
        mutableStateOf(false)
    }

    if (showScreen) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (header, body, footer) = createRefs()

            Header(modifier = Modifier.constrainAs(header) { top.linkTo(parent.top) },
                onClickBack = { showScreen = !showScreen })
            Body(modifier = Modifier.constrainAs(body) {top.linkTo(header.bottom)})
            Footer(modifier = Modifier.constrainAs(footer) { bottom.linkTo(parent.bottom) })
        }

    } else {
        InfoScreen {
            showScreen = !showScreen
        }
    }
}

@Preview
@Composable
fun FakeWhatsappScreenPreview() {
    Header(modifier = Modifier, onClickBack = {})
}
