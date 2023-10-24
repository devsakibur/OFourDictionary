package com.example.ofourdictionary.network

import com.example.ofourdictionary.model.DictionaryModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


const val baseUrl = "https://www.dictionaryapi.com/api/v3/references/learners/json/"


val retrofit  = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()





interface DictionaryApi{

    @GET
    suspend fun getApiUrl(@Url endUrl : String): DictionaryModel

}




object DictionaryRetrofit {
    val dictionaryApi : DictionaryApi by lazy{
        retrofit.create(DictionaryApi::class.java)
    }
}