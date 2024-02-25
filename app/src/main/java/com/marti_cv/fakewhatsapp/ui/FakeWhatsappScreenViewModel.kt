package com.marti_cv.fakewhatsapp.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marti_cv.fakewhatsapp.model.MessageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FakeWhatsappScreenViewModel @Inject constructor() : ViewModel() {

    private val _showScreen = MutableLiveData<Boolean>()
    var showScreen: LiveData<Boolean> = _showScreen

    private val _chatName = MutableLiveData<String>()
    var chatName: LiveData<String> = _chatName

    private val _MessageList = mutableStateListOf<MessageModel>()
    val MessageList: List<MessageModel> = _MessageList

    init{
        _showScreen.value = false
    }

    fun changeShowScreenState() {
        _showScreen.value = !_showScreen.value!!
    }


}