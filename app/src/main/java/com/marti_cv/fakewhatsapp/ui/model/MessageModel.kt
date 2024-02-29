package com.marti_cv.fakewhatsapp.ui.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class MessageModel(val id:Long=System.currentTimeMillis(), val text: String, val isFromUser: Boolean){
    private val formatter = DateTimeFormatter.ofPattern("HH:mm")
    val time:String = LocalDateTime.now().format(formatter)
}
