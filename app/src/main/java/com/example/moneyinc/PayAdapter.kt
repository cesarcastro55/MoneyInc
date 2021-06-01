package com.example.moneyinc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PayAdapter(
    private var dataSet: List<Payments>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<PayAdapter.ViewHolder>() {

    fun reloadItems(lista: List<Payments>){
        dataSet = lista
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener{
        val valortext: TextView = view.findViewById(R.id.valortext)
        val datatext: TextView = view.findViewById(R.id.datatext)

        fun bind(payments: Payments) {
            datatext.text = "Data: " + payments.data_pagamento
            valortext.text = "Valor: " + payments.valor.toString() + "€"
        }

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.onItemClick(position)
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.paymentscell, viewGroup, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem: Payments = dataSet[position]
        viewHolder.bind(currentItem)
    }

    override fun getItemCount() = dataSet.size

}
