package com.tccandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Usuario(private val nome: String) : Parcelable