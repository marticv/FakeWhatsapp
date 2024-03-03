package com.marti_cv.fakewhatsapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.constraintlayout.compose.ConstraintLayout
import com.marti_cv.fakewhatsapp.ui.composables.InfoScreen
import com.marti_cv.fakewhatsapp.ui.composables.body.Body
import com.marti_cv.fakewhatsapp.ui.composables.footer.Footer
import com.marti_cv.fakewhatsapp.ui.composables.header.Header
import com.marti_cv.fakewhatsapp.ui.model.MessageModel


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FakeWhatsappScreen(viewModel: FakeWhatsappScreenViewModel) {

    val showScreen by viewModel.showScreen.observeAsState(false)
    val chatName by viewModel.chatName.observeAsState("")
    val isStartButtonEnabled by viewModel.isStartButtonEnabled.observeAsState(false)
    val text by viewModel.text.observeAsState("")
    val messages: List<MessageModel> = viewModel.messageList
    val controller = LocalSoftwareKeyboardController.current

    if (showScreen) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (header, body, footer) = createRefs()

            Header(
                modifier = Modifier.constrainAs(header) { top.linkTo(parent.top) },
                onClickBack = {
                    viewModel.clearMessageList()
                    viewModel.changeShowScreenState()
                },
                chatName = chatName
            )
            Body(messageList = messages, modifier = Modifier.constrainAs(body) {
                top.linkTo(header.bottom)
            })
            Footer(text = text, onTextChanged = { viewModel.onTextChanged(it) }, onCreateMessage = {
                viewModel.addMessage(text)
                controller?.hide()
            }, onIconPressed = {
                viewModel.addFakeMessage(text)
                controller?.hide()
            }, modifier = Modifier.constrainAs(footer) { bottom.linkTo(parent.bottom) })
        }
    } else {
        InfoScreen(
            onClick = { viewModel.changeShowScreenState() },
            chatName = chatName,
            changeChatName = { viewModel.addName(it) },
            isButtonEnabled = isStartButtonEnabled
        )
    }
}
