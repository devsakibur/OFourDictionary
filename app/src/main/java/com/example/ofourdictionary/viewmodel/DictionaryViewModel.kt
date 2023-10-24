package com.example.ofourdictionary.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ofourdictionary.model.DictionaryModel
import com.example.ofourdictionary.repository.DictionaryRepo
import kotlinx.coroutines.launch

class DictionaryViewModel : ViewModel() {
private val dictionaryRepo = DictionaryRepo()
var inputData = MutableLiveData<String>()
val dictionaryData = MutableLiveData<DictionaryModel>()

    fun setWord(word : String){
        inputData.value = word
    }
    fun getDictionaryData(){

        viewModelScope.launch {
            try {
                dictionaryData.value = inputData.value?.let { dictionaryRepo.getDictionary(it) }
            }catch (e : Exception){
                Log.d("TAG", "getDictionaryData: $e")
            }

        }

    }






}