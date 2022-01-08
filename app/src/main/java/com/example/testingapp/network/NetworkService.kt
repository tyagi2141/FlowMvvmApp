package com.example.testingapp.network

import com.example.testingapp.ui.model.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NetworkService {


    //https://newsapi.org/v2/everything?
    // q=tesla&
    // from=2021-12-07&
    // sortBy=publishedAt&
    // apiKey=32b461267acb4fa9b752b2b783856ab0

    @GET("v2/everything")
    suspend fun getComments
                (@Query("q") id: String,
                 @Query("from") from: String,
                 @Query("sortBy") sortBy: String,
                 @Query("apiKey") apiKey: String
    ): NewsResponse

    //MY TODO https://newsapi.org/everything?q=tesla&from=2021-12-07&sortBy=publishedAt&apiKey=32b461267acb4fa9b752b2b783856ab0
   // SERVER TODO  https://newsapi.org/v2/everything?q=tesla&from=2021-12-08&sortBy=publishedAt&apiKey=32b461267acb4fa9b752b2b783856ab0
    //             https://newsapi.org/v2/everything/v2/everything?q=tesla&from=2021-12-08&sortBy=publishedAt&apiKey=32b461267acb4fa9b752b2b783856ab0
}