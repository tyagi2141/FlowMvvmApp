package com.example.testingapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





object Api {

    // Base url of the api
    private  val BASE_URL = "https://newsapi.org/"


 fun ApiService(): NetworkService {
     val interceptor = HttpLoggingInterceptor()
     interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
     val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

     val retrofit = Retrofit.Builder()
         .baseUrl(BASE_URL)
         .client(client)
         .addConverterFactory(GsonConverterFactory.create())
         .build()

     return retrofit.create(NetworkService::class.java)

 }

}