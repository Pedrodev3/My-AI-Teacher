package br.com.fiap.myaiteacher.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "http://universities.hipolabs.com/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getListaDeUniversidadesService(): UniversidadeService {
        return retrofitFactory.create(UniversidadeService::class.java)
    }
}