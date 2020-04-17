package com.tccandroid.model

import org.junit.Assert.assertEquals
import org.junit.Test

class LeilaoTest {

    @Test
    fun getDescricao() {
        //criar cenário de teste
        var console = Leilao("Console")

        //executar ação esperada
        var descricaoDevolvida = console.descricao

        //testar o resultado esperado
        assertEquals("Console", descricaoDevolvida)
    }

    @Test
    fun getMaiorPreco() {
        val console = Leilao("Console")
        console.propoe(Lance(Usuario("Gustavo"), 200.00))

        val maiorLanceDevolvido = console.maiorLance

        assertEquals(200.00, maiorLanceDevolvido, 0.0001)
    }
}