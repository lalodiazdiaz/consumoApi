package com.rucko.consumoapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckedTextView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*


class MyAdapter(private val myDataSet: ArrayList<Comentario>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(vista)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        var item = myDataSet[position]
        viewHolder.enlazarItem(item)

    }

    override fun getItemCount() = myDataSet.size

    class ViewHolder(val vista: View) : RecyclerView.ViewHolder(vista){
        fun enlazarItem(c:Comentario){
            vista.txtId.text = c.id.toString()
            vista.txtName.text= c.name
            vista.txtEmail.text = c.email
            vista.txtBody.text=c.body
        }
    }

}