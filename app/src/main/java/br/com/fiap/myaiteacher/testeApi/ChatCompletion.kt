package br.com.fiap.myaiteacher.testeApi

import com.aallam.openai.api.chat.ChatChoice
import com.aallam.openai.api.core.Usage
import com.aallam.openai.api.model.ModelId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ChatCompletion(
    /**
     * A unique id assigned to this completion
     */
    @SerialName("id") public val id: String,
    /**
     * The creation time in epoch milliseconds.
     */
    @SerialName("created") public val created: Int,

    /**
     * The model used.
     */
    @SerialName("model") public val model: ModelId,

    /**
     * A list of generated completions
     */
    @SerialName("choices") public val choices: List<ChatChoice>,

    /**
     * Text completion usage data.
     */
    @SerialName("usage") public val usage: Usage? = null,
)