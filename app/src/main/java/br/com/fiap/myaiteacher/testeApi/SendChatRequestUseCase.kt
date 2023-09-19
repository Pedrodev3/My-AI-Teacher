package br.com.fiap.myaiteacher.testeApi

class SendChatRequestUseCase(
    private val openAIRepository: OpenAIRepository,
    private val conversationRepository: ConversationRepository
) {
    suspend operator fun invoke(
        prompt:String
    ){
        val message = Message(
            text = prompt,
            isFromUser = true,
            messageStatus = MessageStatus.SENDING
        )
        val conversation = conversationRepository.addMessage(message)

        try {
            val reply = openAIRepository.sendChatRequest(conversation)
            conversationRepository.setMessageStatusToSent(message.id)
            conversationRepository.addMessage(reply)
        } catch (exception: Exception) {
            conversationRepository.setMessageStatusToSent(message.id)
        }
    }
}