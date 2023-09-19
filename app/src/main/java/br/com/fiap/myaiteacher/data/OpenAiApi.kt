package br.com.fiap.myaiteacher.data

import br.com.fiap.myaiteacher.api.API_KEY.MY_API_KEY
import br.com.fiap.myaiteacher.api.CompletionRequest
import br.com.fiap.myaiteacher.api.CompletionResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAiApi {
    @Headers("Authorization: Baerer ${MY_API_KEY}")
    @POST("v1/cmopletions")
    suspend fun getCompletion(@Body completionResponse: CompletionRequest) : Response<CompletionResponse>
}