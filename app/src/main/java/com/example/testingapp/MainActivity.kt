package com.example.testingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testingapp.network.Resource
import com.example.testingapp.ui.NewsViewModel
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit

import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor




class MainActivity : AppCompatActivity() {

     var viewModel: NewsViewModel ? = null

var name :TextView ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.textId)


      viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
bindViewModel()

    }

    private fun bindViewModel() {

viewModel?._response?.observe(this, Observer {response ->
    when (response) {
        is Resource.Success -> {
            response.success?.let {
                //bind the data to the ui
                Log.e("datata...","DAta ${it}")
                name?.text  = it.toString()
            }
        }
        is Resource.Fail -> {
            //show error message
            Toast.makeText(
                this,
                response.error.toString(),
                Toast.LENGTH_SHORT
            ).show()

            Log.e("datata...","Fail ${response.error.message.toString()}")

        }

        is Resource.Loading -> {
            Log.e("datata...","Loading ${response?.isLoading}")

            //show loader, shimmer effect etc
        }
    }
})

      /*  bind(viewModel?.isLoading) {
           Log.e("datata...","Loading ${it}")
        }
        bind(viewModel?.isFail) {
            Log.e("datata...","Fail ${it}")
        }
        bind(viewModel?.data) {
            Log.e("datata...","DAta ${it}")
        }*/
    }
}