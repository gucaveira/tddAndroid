package com.tccandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lance(private val usuario: Usuario, val valor: Double) : Parcelable
