package com.example.moneyinc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moneyinc.databinding.FragmentSelectAccountBinding
import org.w3c.dom.Text


class CustomAdapter(private var dataSet: List<UserInfo>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    fun reloadItems(lista: List<UserInfo>){
        dataSet = lista
        notifyDataSetChanged()
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val texttitular: TextView = view.findViewById(R.id.texttitular)
        val textid: TextView = view.findViewById(R.id.textid)
        val btselect: TextView = view.findViewById(R.id.select)

        fun bind(userInfo: UserInfo) {
            texttitular.text = userInfo.titular1
            textid.text = userInfo.id.toString()
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.select_acount_view, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem: UserInfo = dataSet[position]
        viewHolder.bind(currentItem)
        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        //viewHolder.textView.text = dataSet[position].toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
