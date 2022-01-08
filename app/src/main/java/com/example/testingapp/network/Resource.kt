package com.example.testingapp.network

sealed class Resource<out T> {
object Loading:Resource<Nothing>()

  data class  Success<out T> (val value :T):Resource<T>()
    data class Fail(val error:Throwable):Resource<Nothing>()

    val isLoading get() = this is Loading
    val success get() = (this as? Success)?.value
    val isfail get() = this is Fail

}