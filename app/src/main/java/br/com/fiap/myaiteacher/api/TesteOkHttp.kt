package br.com.fiap.myaiteacher.api

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

fun enviarMensagemParaChatGPT(mensagem: String): String? {
    val apiKey = "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" // Substitua pela sua chave de API do ChatGPT
    val apiUrl = "https://api.openai.com/v1/chat/completions" // URL da API do ChatGPT

    val cliente = OkHttpClient()

    // Construa o corpo da solicitação em JSON
    val json = """
        {
            "model": "gpt-3.5-turbo",
            "messages": [
                {"role": "system", "content": "Você é um assistente de bate-papo."},
                {"role": "user", "content": "$mensagem"}
            ]
        }
    """.trimIndent()

    val corpoDaSolicitacao = json.toRequestBody("application/json".toMediaType())

    // Construa a solicitação
    val solicitacao = Request.Builder()
        .url(apiUrl)
        .post(corpoDaSolicitacao)
        .addHeader("Authorization", "Bearer $apiKey")
        .build()

    // Faça a solicitação
    val resposta: Response = cliente.newCall(solicitacao).execute()

    return if (resposta.isSuccessful) {
        resposta.body?.string()
    } else {
        null
    }
}

fun main() {
    val mensagem = "Como funciona a API do ChatGPT?" // Substitua pela sua pergunta
    val resposta = enviarMensagemParaChatGPT(mensagem)

    if (resposta != null) {
        println("Resposta do ChatGPT: $resposta")
    } else {
        println("Erro ao fazer a solicitação para o ChatGPT.")
    }
}