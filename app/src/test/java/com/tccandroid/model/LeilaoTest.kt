package com.tccandroid.model

import org.junit.Assert.assertEquals
import org.junit.Test

class LeilaoTest {

    @Test
    fun getDescricaoQuandoRecebeDescricaoDevolverDescricao() {
        //criar cenário de teste
        var console = Leilao("Console")

        //executar ação esperada
        var descricaoDevolvida = console.descricao

        //testar o resultado esperado
        assertEquals("Console", descricaoDevolvida)
    }

    @Test
    fun getMaiorLanceQuandoRecebeApenasUmLanceDevolveMaiorLance() {
        val console = Leilao("Console")
        console.propoe(Lance(Usuario("Gustavo"), 200.00))

        val maiorLanceDevolvido = console.maiorLance

        assertEquals(200.00, maiorLanceDevolvido, 0.0001)
    }

    @Test
    fun getMaiorLanceQuandoRecebeMaisDeUmLanceEmOrdemCrescenteDevolveMaiorLance() {
        val computador = Leilao("Computador")
        computador.propoe(Lance(Usuario("Gustavo"), 1000.00))
        computador.propoe(Lance(Usuario("Maria"), 2000.00))

        val maiorValorDevolvido = computador.maiorLance

        assertEquals(2000.00, maiorValorDevolvido, 0.0001)
    }

    @Test
    fun getMaiorLanceQuandoRecebeMaisDeUmLanceEmOrdemDecrescenteDevolveMaiorLance() {
        val computador = Leilao("Computador")
        computador.propoe(Lance(Usuario("Maria"), 2000.00))
        computador.propoe(Lance(Usuario("Gustavo"), 1000.00))

        val maiorValorDevolvido = computador.maiorLance

        assertEquals(2000.00, maiorValorDevolvido, 0.0001)
    }
}