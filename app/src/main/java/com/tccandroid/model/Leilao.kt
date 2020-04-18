package com.tccandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Leilao(
    val descricao: String,
    var maiorLance: Double = Double.NEGATIVE_INFINITY,
    var menorLance: Double = Double.POSITIVE_INFINITY,
    val lances: MutableList<Lance> = mutableListOf()
) : Parcelable {

    fun propoe(lance: Lance) {
        lances.add(lance)
        //ser for 0 igual, se for 1 maior, se for -1 menor, Colecions sort
        lances.sortByDescending { it.valor }
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

    fun tresMaioresLance(): List<Lance> {
        return lances.subList(0, 3)
    }
}