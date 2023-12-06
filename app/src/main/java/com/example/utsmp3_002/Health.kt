package com.example.utsmp3_002

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Health(
    val photo: Int,
    val name: String
) : Parcelable
