package com.tccandroid.model

import org.junit.Assert.assertEquals
import org.junit.Test


class LeilaoTest {

    private val console = Leilao("Console")
    private val usuarioGustavo = Usuario("Gustavo")
    private val usuarioMaria: Usuario = Usuario("Maria")
    private val delta = 0.0001


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
        console.propoe(Lance(usuarioGustavo, 200.00))

        val maiorLanceDevolvido = console.maiorLance

        assertEquals(200.00, maiorLanceDevolvido, delta)
    }

    @Test
    fun deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        console.propoe(Lance(usuarioGustavo, 1000.00))
        console.propoe(Lance(usuarioGustavo, 2000.00))

        val maiorValorDevolvido = console.maiorLance

        assertEquals(2000.00, maiorValorDevolvido, delta)
    }

    @Test
    fun deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        console.propoe(Lance(usuarioMaria, 2000.00))
        console.propoe(Lance(usuarioGustavo, 1000.00))

        val maiorValorDevolvido = console.maiorLance

        assertEquals(2000.00, maiorValorDevolvido, delta)
    }

    @Test
    fun deve_DevolveMenorLance_QuandoRecebeApenasUmLance() {
        console.propoe(Lance(usuarioGustavo, 200.00))

        val menorLanceDevolvido = console.menorLance

        assertEquals(200.00, menorLanceDevolvido, delta)
    }

    @Test
    fun deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        console.propoe(Lance(usuarioMaria, 1000.00))
        console.propoe(Lance(usuarioGustavo, 2000.00))

        val menorValorDevolvido = console.menorLance

        assertEquals(1000.00, menorValorDevolvido, delta)
    }

    @Test
    fun deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        console.propoe(Lance(usuarioMaria, 2000.00))
        console.propoe(Lance(usuarioGustavo, 1000.00))


        val menorLanceDevolvido = console.menorLance

        assertEquals(1000.00, menorLanceDevolvido, delta)
    }

    @Test
    fun deve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances() {
        console.propoe(Lance(usuarioGustavo, 100.00))
        console.propoe(Lance(usuarioMaria, 200.00))
        console.propoe(Lance(usuarioGustavo, 300.00))

        val tresMaioresLancesDevolvidos = console.tresMaioresLance()

        assertEquals(3, tresMaioresLancesDevolvidos.size)
        assertEquals(300.00, tresMaioresLancesDevolvidos[0].valor, delta)
        assertEquals(200.00, tresMaioresLancesDevolvidos[1].valor, delta)
        assertEquals(100.00, tresMaioresLancesDevolvidos[2].valor, delta)
    }
}