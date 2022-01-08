package com.example.testingapp.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewRequest(val q:String,val from:String,val sortBy:String,val ApiKey:String) : Parcelable
