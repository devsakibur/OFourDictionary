package com.example.ofourdictionary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.ofourdictionary.databinding.ActivityMainBinding
import com.example.ofourdictionary.viewmodel.DictionaryViewModel

class MainActivity:AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: DictionaryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[DictionaryViewModel::class.java]


        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    viewModel.setWord(query)
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {

                return true
            }

        })





        viewModel.inputData.observe(this){
            viewModel.getDictionaryData()
        }
        viewModel.dictionaryData.observe(this){data ->
            binding.noun.text =data[0].fl
            binding.description.text =data[0].shortdef[0]

        }

    }
}


