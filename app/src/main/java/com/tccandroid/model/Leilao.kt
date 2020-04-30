package com.tccandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Leilao(
    val descricao: String,
    var maiorLance: Double = 0.0,
    var menorLance: Double = 0.0,
    val lances: MutableList<Lance> = mutableListOf()
) : Parcelable {

    fun propoe(lance: Lance) {
        lances.add(lance)
        if (lances.size == 1) {
            maiorLance = lance.valor
            menorLance = lance.valor
            return // forçar o retorno para o metodo de chamada, sem executar o restante do metodo propoe
        }
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
        var quantidadeMaximaLances = lances.size
        if (quantidadeMaximaLances > 3) {
            quantidadeMaximaLances = 3
        }
        return lances.subList(0, quantidadeMaximaLances)
    }
}