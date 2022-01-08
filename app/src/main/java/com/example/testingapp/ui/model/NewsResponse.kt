package com.example.testingapp.ui.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsResponse (
    @SerializedName("status") val status : String,
    @SerializedName("totalResults") val totalResults : Int,
    @SerializedName("articles") val articles : List<Articles>
        ) : Parcelable