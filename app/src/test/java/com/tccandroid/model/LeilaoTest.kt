package com.tccandroid.model

import org.junit.Assert.assertEquals
import org.junit.Test

class LeilaoTest {

    @Test
    fun deve_DevolverDescricao_QuandoRecebeDescricao() {
        //criar cenário de teste
        var console = Leilao("Console")

        //executar ação esperada
        var descricaoDevolvida = console.descricao

        //testar o resultado esperado
        assertEquals("Console", descricaoDevolvida)
    }

    @Test
    fun deve_DevolveMaiorLance_QuandoRecebeApenasUmLance() {
        val console = Leilao("Console")
        console.propoe(Lance(Usuario("Gustavo"), 200.00))

        val maiorLanceDevolvido = console.maiorLance

        assertEquals(200.00, maiorLanceDevolvido, 0.0001)
    }

    @Test
    fun deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        val computador = Leilao("Computador")
        computador.propoe(Lance(Usuario("Gustavo"), 1000.00))
        computador.propoe(Lance(Usuario("Maria"), 2000.00))

        val maiorValorDevolvido = computador.maiorLance

        assertEquals(2000.00, maiorValorDevolvido, 0.0001)
    }

    @Test
    fun deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        val computador = Leilao("Computador")
        computador.propoe(Lance(Usuario("Maria"), 2000.00))
        computador.propoe(Lance(Usuario("Gustavo"), 1000.00))

        val maiorValorDevolvido = computador.maiorLance

        assertEquals(2000.00, maiorValorDevolvido, 0.0001)
    }

    @Test
    fun deve_DevolveMenorLance_QuandoRecebeApenasUmLance() {
        val console = Leilao("Console")
        console.propoe(Lance(Usuario("Gustavo"), 200.00))

        val menorLanceDevolvido = console.menorLance

        assertEquals(200.00, menorLanceDevolvido, 0.0001)
    }

    @Test
    fun deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        val computador = Leilao("Computador")
        computador.propoe(Lance(Usuario("Gustavo"), 1000.00))
        computador.propoe(Lance(Usuario("Maria"), 2000.00))

        val menorValorDevolvido = computador.menorLance

        assertEquals(2000.00, menorValorDevolvido, 0.0001)
    }


    @Test
    fun deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        val computador = Leilao("Computador")
        computador.propoe(Lance(Usuario("Gustavo"), 2000.00))
        computador.propoe(Lance(Usuario("Maria"), 1000.00))


        val menorLanceDevolvido = computador.menorLance

        assertEquals(1000.00, menorLanceDevolvido, 0.0001)
    }
}