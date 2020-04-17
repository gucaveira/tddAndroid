package com.tccandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Leilao(
    val descricao: String,
    var maiorLance: Double = Double.NEGATIVE_INFINITY,
    var menorLance: Double = Double.POSITIVE_INFINITY
) : Parcelable {

    private val lances: List<Lance>

    init {
        lances = ArrayList<Lance>()
    }

    fun propoe(lance: Lance) {
        val lanceValor = lance.valor
        if (lanceValor > maiorLance) {
            maiorLance = lanceValor
        }
        if (lanceValor < menorLance) {
            menorLance = lanceValor
        }
    }
}