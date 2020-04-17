package com.tccandroid.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tccandroid.R
import com.tccandroid.model.Leilao
import com.tccandroid.ui.recyclerview.adapter.ListaLeilaoAdapter
import kotlinx.android.synthetic.main.activity_lista_leilao.*

class ListaLeilaoActivity : AppCompatActivity() {

    private val adapter by lazy {
        ListaLeilaoAdapter(context = applicationContext, leiloes = leiloesDeExemplo())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_leilao)

        lista_leilao_recyclerview.adapter = adapter

        adapter.quandoItemClicado = {
            val vaiParaLancesLeilao = Intent(this, LancesLeilaoActivity::class.java)
            vaiParaLancesLeilao.putExtra("leilao", it)
            startActivity(vaiParaLancesLeilao)
        }
    }

    private fun leiloesDeExemplo(): List<Leilao> {
        val console = Leilao(descricao = "Console")
        return ArrayList(listOf(console))
    }
}
