package br.com.fiap.myaiteacher.services

import br.com.fiap.myaiteacher.model.ListaDeUniversidades
import br.com.fiap.myaiteacher.model.Universidade
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversidadeService {

    //http://universities.hipolabs.com/search?name
    @GET("search?")
    fun getListaDeUniversidades(@Query("name") name: String): Call<List<Universidade>>
}