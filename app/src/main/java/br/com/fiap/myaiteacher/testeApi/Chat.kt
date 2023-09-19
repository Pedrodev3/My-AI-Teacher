package br.com.fiap.myaiteacher.testeApi

import com.aallam.openai.api.chat.ChatCompletion
import com.aallam.openai.api.chat.ChatCompletionChunk
import kotlinx.coroutines.flow.Flow

public interface Chat {

    /**
     * Creates a completion for the chat message.
     */
    public suspend fun chatCompletion(request: ChatCompletionRequest): ChatCompletion

    /**
     * Stream variant of [chatCompletion].
     */
    public fun chatCompletions(request: ChatCompletionRequest): Flow<ChatCompletionChunk>
}