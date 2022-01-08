package com.example.testingapp.network

import com.example.testingapp.ui.model.NewRequest
import com.example.testingapp.ui.model.NewsResponse
import kotlinx.coroutines.flow.Flow

interface RepoRepository {

    fun getNews(newRequest: NewRequest):Flow<Resource<NewsResponse>>
}