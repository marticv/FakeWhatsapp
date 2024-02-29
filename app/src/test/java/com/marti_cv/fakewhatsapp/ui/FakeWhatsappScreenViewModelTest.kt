package com.marti_cv.fakewhatsapp.ui

import androidx.test.runner.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
class FakeWhatsappScreenViewModelTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    private lateinit var viewModel: FakeWhatsappScreenViewModel

    @Before
    fun setUp() {
        hiltRule.inject()
        viewModel = FakeWhatsappScreenViewModel()
    }

    //test function that checks the initial state
    @Test
    fun initialTest(){
        assert(viewModel.showScreen.value == false)
        assert(viewModel.isStartButtonEnabled.value == false)
        assert(viewModel.chatName.value == "")
        assert(viewModel.text.value == "")
    }

    @Test
    fun changeShowScreenStateTest(){
        viewModel.changeShowScreenState()
        assert(viewModel.showScreen.value == true)
    }

    @Test
    fun addNameTest(){
        viewModel.addName("test")
        assert(viewModel.chatName.value == "test")
    }

    @Test
    fun `If name is to long then name shortens and end with 3dots`() {
        val nameLength = viewModel.chatName.value!!.length
    }

    @Test
    fun `If name is les than 3 characters then startButton is not enabled`() {
        viewModel.addName("")
        viewModel.enableButton()
        assert(viewModel.isStartButtonEnabled.value == false)
    }

    @Test
    fun `If name is 3 or more characters then startButton is enabled`() {
        viewModel.addName("ttt")
        viewModel.enableButton()
        assert(viewModel.isStartButtonEnabled.value == true)
    }

    @Test
    fun `If text is added then MessageList increases`() {
        val initialListSize = viewModel.messageList.size
        viewModel.addMessage("text")
        assert(viewModel.messageList.size == initialListSize + 1)
    }

    @Test
    fun `If text is added then bubble is created`() {
        val initialListSize = viewModel.messageList.size
        viewModel.addMessage("text")
        assert(viewModel.messageList.size == initialListSize + 1)
    }

    @Test
    fun `If text is empty then bubble is not created`() {
        val initialListSize = viewModel.messageList.size
        viewModel.addMessage(" ")
        assert(viewModel.messageList.size == initialListSize)
    }

    @Test
    fun `If Faketext is added then MessageList increases`() {
        val initialListSize = viewModel.messageList.size
        viewModel.addMessage("text")
        assert(viewModel.messageList.size == initialListSize + 1)
    }

    @Test
    fun `If Faketext is added then bubble is created`() {
        val initialListSize = viewModel.messageList.size
        viewModel.addFakeMessage("text")
        assert(viewModel.messageList.size == initialListSize + 1)
    }

    @Test
    fun `If text is empty then Fakebubble is not created`() {
        val initialListSize = viewModel.messageList.size
        viewModel.addFakeMessage("")
        assert(viewModel.messageList.size == initialListSize)
    }


}