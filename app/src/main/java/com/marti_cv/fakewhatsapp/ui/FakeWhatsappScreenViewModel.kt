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

    private val _messageList = mutableStateListOf<MessageModel>()
    val messageList: List<MessageModel> = _messageList

    init {
        _showScreen.value = false
        _isStartButtonEnabled.value = false
        _chatName.value = ""
        _text.value = ""
    }

    /**
     * Change the value of showScreen
     */
    fun changeShowScreenState() {
        _showScreen.value = !_showScreen.value!!
    }

    /**
     * Change the chatname end to ... if chatname is more than 10
     */
    private fun addEllipsis() {
        if (_chatName.value!!.length > 10) {
            _chatName.value = chatName.value?.substring(0, 10) + "..."
        }
    }

    /**
     * Change the value of chatName and the value of isStartButtonEnabled if necessary
     */
    fun addName(name: String) {
        _chatName.value = name
        addEllipsis()
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

    /**
     * Add a message to the list
     */
    fun addMessage(text: String) {
        if (text.trim().isNotEmpty()) {
            val message = MessageModel(text = text, isFromUser = true)
            _messageList.add(message)
            _text.value = ""
        }
    }

    /**
     * Add a fake message to the list
     */
    fun addFakeMessage(text: String) {
        if (text.trim().isNotEmpty()) {
            val fakeMessage = MessageModel(text = text, isFromUser = false)
            _messageList.add(fakeMessage)
            _text.value = ""
        }
    }

    /**
     * Change the value of text depending on the user input
     */
    fun onTextChanged(userText: String) {
        _text.value = userText
    }
}