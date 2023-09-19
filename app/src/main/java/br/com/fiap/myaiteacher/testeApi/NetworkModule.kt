package br.com.fiap.myaiteacher.testeApi

import com.aallam.openai.client.OpenAI
import com.aallam.openai.client.OpenAIConfig
import org.koin.dsl.module
import br.com.fiap.myaiteacher.api.API_KEY.MY_API_KEY

val networkModule = module {
    single {provideOpenAI()}
}

fun provideOpenAI(): OpenAI {

    val config = OpenAIConfig(
        token = MY_API_KEY
    )

    return OpenAI(config)
}