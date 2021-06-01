package com.example.moneyinc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmpAdapater(
    private var dataSet: List<Cards>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<EmpAdapater.ViewHolder2>() {

    fun reloadItems(lista: List<Cards>){
        dataSet = lista
        notifyDataSetChanged()
    }

    inner class ViewHolder2(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener{

        val texttitular: TextView = view.findViewById(R.id.texttitular)
        val textid: TextView = view.findViewById(R.id.textid)
        val textsaldo: TextView = view.findViewById(R.id.textsaldo)

        fun bind(cards: Cards) {
            texttitular.text = cards.name_on_card
            textid.text = cards.type
            textsaldo.text = cards.number.toString()
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

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder2 {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.select_acount_view, viewGroup, false)

        return ViewHolder2(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder2, position: Int) {
        val currentItem: Cards = dataSet[position]
        viewHolder.bind(currentItem)
    }

    override fun getItemCount() = dataSet.size

}