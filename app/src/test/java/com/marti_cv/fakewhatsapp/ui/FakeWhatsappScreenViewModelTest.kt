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


    lateinit var viewModel: FakeWhatsappScreenViewModel

    @Before
    fun setUp() {
        hiltRule.inject()
        viewModel = FakeWhatsappScreenViewModel()
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

}