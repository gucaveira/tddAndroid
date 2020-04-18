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
        calculaMairLance(lance.valor)
        calculaMenorLance(lance.valor)
    }

    private fun calculaMenorLance(lanceValor: Double) {
        if (lanceValor < menorLance) {
            menorLance = lanceValor
        }
    }

    private fun calculaMairLance(lanceValor: Double) {
        if (lanceValor > maiorLance) {
            maiorLance = lanceValor
        }
    }
}