package com.tccandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Leilao(val descricao: String) : Parcelable {
    private val lances: List<Lance>

    init {
        lances = ArrayList<Lance>()
    }
}