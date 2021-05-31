package com.example.moneyinc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moneyinc.databinding.FragmentSelectAccountBinding
import org.w3c.dom.Text


class CustomAdapter(
    private var dataSet: List<UserInfo>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    fun reloadItems(lista: List<UserInfo>){
        dataSet = lista
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view),
    View.OnClickListener{
        val texttitular: TextView = view.findViewById(R.id.texttitular)
        val textid: TextView = view.findViewById(R.id.textid)
        val textsaldo: TextView = view.findViewById(R.id.textsaldo)

        fun bind(userInfo: UserInfo) {
            texttitular.text = userInfo.titular1
            textid.text = userInfo.id.toString()
            textsaldo.text = userInfo.saldo.toString()
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
            .inflate(R.layout.select_acount_view, viewGroup, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem: UserInfo = dataSet[position]
        viewHolder.bind(currentItem)
    }

    override fun getItemCount() = dataSet.size

}
