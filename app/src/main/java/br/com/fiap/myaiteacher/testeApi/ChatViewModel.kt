package br.com.fiap.myaiteacher.testeApi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ChatViewModel(
    private val sendChatRequestUseCase: SendChatRequestUseCase,
    private val observeMessagesUseCase: ObserveMessagesUseCase,
    private val resentChatRequestUseCase: ResendMessageUseCase
) : ViewModel() {

    private val _conversation = MutableLiveData<Conversation>()
    val conversation: LiveData<Conversation> = _conversation

    private val _isSendingMessage = MutableLiveData<Boolean>()
    val isSendingMessage: LiveData<Boolean> = _isSendingMessage

    init {
        observeMessageList()
    }

    private fun observeMessageList() {
        viewModelScope.launch {
            observeMessagesUseCase.invoke().collect { conversation ->
                _conversation.postValue(conversation)

                _isSendingMessage.postValue(
                    conversation.list.any { it.messageStatus == MessageStatus.SENDING })
            }
        }
    }

    fun sendMessage(prompt: String) {
        viewModelScope.launch {
            sendChatRequestUseCase(
                prompt
            )
        }
    }

    fun resendMessage(message: Message) {
        viewModelScope.launch {
            resentChatRequestUseCase(
                message
            )
        }
    }

}