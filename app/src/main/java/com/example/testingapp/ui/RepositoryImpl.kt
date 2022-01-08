package com.example.testingapp.ui

import com.example.testingapp.network.Api
import com.example.testingapp.network.NetworkService
import com.example.testingapp.network.RepoRepository
import com.example.testingapp.network.Resource
import com.example.testingapp.ui.model.NewRequest
import com.example.testingapp.ui.model.NewsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(val networkService: Api) : RepoRepository {
    override fun getNews(
      newRequest: NewRequest
    ): Flow<Resource<NewsResponse>> = flow {
        emit(Resource.Loading)
        val resource = try {
            val response = networkService.ApiService().getComments(newRequest.q, newRequest.from, newRequest.sortBy, newRequest.ApiKey)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Fail(e)
        }
        emit(resource)
    }
}