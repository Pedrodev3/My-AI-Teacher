package br.com.fiap.myaiteacher.model

import com.google.gson.annotations.SerializedName

data class Message(
    val message : String,
    val sentBY : String,
    val timestamp : String
){
    companion object{
        const val SENT_BY_ME = "sent_me"
        const val SENT_BY_BOT = "sent_bot"
    }
}