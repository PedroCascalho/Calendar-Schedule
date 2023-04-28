package com.example.exerciciocalendar

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Schedule (
    val data: String,
    val description: String
) : Parcelable