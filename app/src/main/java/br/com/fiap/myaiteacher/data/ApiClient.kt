package br.com.fiap.myaiteacher.data

import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
object ApiClient {

    private const val BASE_URL = "https://api.openai.com/"

    private val httpClient = OkHttpClient.Builder().build()

    private val retrofit = retrofit2.Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService : OpenAiApi = retrofit.create(OpenAiApi::class.java)

}