package com.example.ofourdictionary.repository

import com.example.ofourdictionary.model.DictionaryModel
import com.example.ofourdictionary.network.DictionaryRetrofit

class DictionaryRepo {

    suspend fun getDictionary(inputWord : String): DictionaryModel {
        val endUrl = "$inputWord?key=f20fc0bb-f6d1-4545-9a8d-839a5f553b42"
        return DictionaryRetrofit.dictionaryApi.getApiUrl(endUrl)
    }

}