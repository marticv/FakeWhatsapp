package com.marti_cv.fakewhatsapp.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marti_cv.fakewhatsapp.ui.model.MessageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FakeWhatsappScreenViewModel @Inject constructor() : ViewModel() {

    private val _showScreen = MutableLiveData<Boolean>()
    val showScreen: LiveData<Boolean> = _showScreen

    private val _isStartButtonEnabled = MutableLiveData<Boolean>()
    val isStartButtonEnabled: LiveData<Boolean> = _isStartButtonEnabled

    private val _chatName = MutableLiveData<String>()
    val chatName: LiveData<String> = _chatName

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    private val _MessageList = mutableStateListOf<MessageModel>()
    val MessageList: List<MessageModel> = _MessageList

    init {
        _showScreen.value = false
        _isStartButtonEnabled.value = false
    }

    /**
     * Change the value of showScreen
     */
    fun changeShowScreenState() {
        _showScreen.value = !_showScreen.value!!
    }

    /**
     * Change the value of chatName and the value of isStartButtonEnabled if necessary
     */
    fun addName(name: String) {
        _chatName.value = name
        enableButton()
    }

    /**
     * enableButton if chatName is more than 3 letters
     */
    fun enableButton() {
        val chatNameLength = chatName.value?.length ?: 0

        if (chatNameLength >= 3) {
            _isStartButtonEnabled.value = true
        }
    }

    fun addMessage(text: String) {
        val message = MessageModel(text=text, isFromUser = true)
        _MessageList.add(message)
    }

    fun addFakeMessage(text: String) {
        val fakeMessage = MessageModel(text=text, isFromUser = false)
        _MessageList.add(fakeMessage)
    }

    fun onTextChanged(userText: String) {
        _text.value = userText
    }
}