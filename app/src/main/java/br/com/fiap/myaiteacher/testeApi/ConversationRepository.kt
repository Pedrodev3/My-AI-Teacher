package br.com.fiap.myaiteacher.testeApi

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID

class ConversationRepository {
    private var messagesList = mutableListOf(
        Message(
            text = "Hi, how can i help?",
            isFromUser = false,
            messageStatus = MessageStatus.SENT
        )
    )

    private val _conversationFlow = MutableStateFlow(
        value = Conversation(list = messagesList)
    )
    val conversationFlow = _conversationFlow.asStateFlow()

    fun addMessage(message: Message) : Conversation {
        messagesList.add(message)
        return updateConversationFlow(messagesList)
    }

    fun resendMessage(message: Message) : Conversation {
        messagesList.remove(message)
        messagesList.add(message)
        return updateConversationFlow(messagesList)
    }

    fun setMessageStatusToSent(messageId: String) {
        val index = messagesList.indexOfFirst { it.id == messageId }
        if (index != -1) {
            messagesList[index] = messagesList[index].copy(messageStatus = MessageStatus.SENT)
        }

        updateConversationFlow(messagesList)
    }

    fun setMessageStatusToError(messageId: String) {
        val index = messagesList.indexOfFirst { it.id == messageId }
        if (index != -1) {
            messagesList[index] = messagesList[index].copy(messageStatus = MessageStatus.Error)
        }

        updateConversationFlow(messagesList)
    }

    private fun updateConversationFlow(messagesList: List<Message>) : Conversation {
        val conversation = Conversation(list = messagesList)
        _conversationFlow.value = conversation

        return conversation
    }

}

class Conversation(
    val list: List<Message>
)

data class Message(
    val id: String = UUID.randomUUID().toString(),
    val text: String?,
    val isFromUser: Boolean,
    val messageStatus: MessageStatus = MessageStatus.SENDING
)

sealed class MessageStatus {
    object SENDING : MessageStatus()
    object SENT : MessageStatus()
    object Error: MessageStatus()
}