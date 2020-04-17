package com.tccandroid.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tccandroid.R
import com.tccandroid.model.Leilao
import com.tccandroid.ui.recyclerview.adapter.ListaLeilaoAdapter.Holder
import kotlinx.android.synthetic.main.item_leilao.view.*

class ListaLeilaoAdapter(
    val context: Context,
    val leiloes: List<Leilao>,
    var quandoItemClicado: (leilao: Leilao) -> Unit = {}
) : RecyclerView.Adapter<Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_leilao, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val leilao = pegaLeilaoPorPosicao(position)
        holder.vicula(leilao)
    }

    override fun getItemCount(): Int {
        return leiloes.size
    }

    fun pegaLeilaoPorPosicao(posicao: Int): Leilao {
        return leiloes[posicao]
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var leilao: Leilao

        init {
            itemView.setOnClickListener {
                if (::leilao.isInitialized) {
                    quandoItemClicado(leilao)
                }
            }
        }

        fun vicula(leilao: Leilao) {
            this.leilao = leilao
            itemView.item_leilao_imagem.setImageResource(R.drawable.img_indisponivel)
            itemView.item_leilao_descricao.text = leilao.descricao
            itemView.item_leilao_maior_lance.text = leilao.maiorLance.toString()
        }

    }
}
