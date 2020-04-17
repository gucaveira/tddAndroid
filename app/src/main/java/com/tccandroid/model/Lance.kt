package com.tccandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lance(private val usuario: Usuario, private val valor: Double) : Parcelable
