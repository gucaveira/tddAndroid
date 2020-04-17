package com.tccandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tccandroid.R
import com.tccandroid.model.Leilao
import kotlinx.android.synthetic.main.activity_lances_leilao.*

class LancesLeilaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lances_leilao)

        val dadosRecebidos = intent
        if (dadosRecebidos != null) {
            val leilao = intent.extras?.getParcelable<Leilao>("leilao")
            lances_leilao_descricao.text = leilao?.descricao
            lances_leilao_maior_lance.text = leilao?.maiorLance.toString()
            lances_leilao_menor_lance.text = leilao?.menorLance.toString()
        }
    }
}