package com.example.testingapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingapp.network.Api
import com.example.testingapp.network.Resource
import com.example.testingapp.ui.model.NewRequest
import com.example.testingapp.ui.model.NewsResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NewsViewModel  : ViewModel() {


    private val repoRepository = RepositoryImpl(
        Api
    )

    var _response: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private val _param = MutableStateFlow(
        NewRequest(
            "tesla",
            "2021-12-08",
            "publishedAt",
            "32b461267acb4fa9b752b2b783856ab0"
        )
    )
  /*  private val param: Flow<NewRequest> = _param

    private val submitEvent = MutableSharedFlow<Unit>()

    @ExperimentalCoroutinesApi
    private val resource =
        submitEvent.map { _param.value }.flatMapLatest { repoRepository.getNews(it) }.stateIn(
            viewModelScope,
            SharingStarted.Eagerly, Resource.Loading
        )
*/


    init {
        fetchResult()
    }



    private fun fetchResult() {
        _response.value = Resource.Loading
        if (true) {
            try {
                val response = repoRepository.getNews(_param.value)

                viewModelScope.launch {
                    response.collect {
                        _response.value = it

                    }
                }


            } catch (e: Exception) {
                _response.value = Resource.Fail(e)
            }
        } else {
          //  _response.value = Resource.Fail("No Internet connection !")
        }
    }
}