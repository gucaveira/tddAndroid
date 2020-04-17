package com.tccandroid.model

import org.junit.Assert.*
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
}