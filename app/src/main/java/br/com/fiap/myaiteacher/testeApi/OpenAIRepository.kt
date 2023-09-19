package br.com.fiap.myaiteacher.testeApi

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI

@OptIn(BetaOpenAI::class)
class OpenAIRepository(private val openAI: OpenAI) {
    suspend fun  sendChatRequest(
        conversation: Conversation
    ) : Message {
        val chatCompletionRequest = ChatCompletionRequest(
            model = ModelId("gpt-3.5-turbo"),
            messages = conversation.toChatMessages(),
        )

        val chatMessage = openAI.chatCompletion(chatCompletionRequest).choices.first().message
            ?: throw NoChoiceAvailableException()

        return Message(
            text = chatMessage.content,
            isFromUser = chatMessage.role == ChatRole.User,
            messageStatus = MessageStatus.SENT
        )
    }

    private fun Conversation.toChatMessages() = this.list
        .filterNot { it.messageStatus == MessageStatus.Error }
        .map {
            ChatMessage(
                content = it.text,
                role = if (it.isFromUser) { ChatRole.User } else { ChatRole.Assistant }
            )
        }
}

class NoChoiceAvailableException : Exception()