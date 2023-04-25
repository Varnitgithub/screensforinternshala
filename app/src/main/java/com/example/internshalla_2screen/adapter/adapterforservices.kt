package com.example.internshalla_2screen.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internshalla_2screen.R
import com.example.internshalla_2screen.modelclasses.modelforservices

class adapterforservices(private var context: Context, private var listener: myinterface) :
    RecyclerView.Adapter<adapterforservices.myviewholder>() {
    private var item = ArrayList<modelforservices>()

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val servicename: TextView = itemView.findViewById(R.id.servicename)
        val layout: LinearLayout = itemView.findViewById(R.id.layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val viewholder = myviewholder(
            LayoutInflater.from(context).inflate(R.layout.service_layout, parent, false)
        )


        viewholder.layout.setOnClickListener {
            listener.onclick(
                item[viewholder.adapterPosition],
                position = viewholder.adapterPosition
            )
        }
        return viewholder
    }

    override fun getItemCount(): Int {
        return item.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updatelist(newlist: ArrayList<modelforservices>) {
        item.clear()
        item.addAll(newlist)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        val currentitem = item[position]
        holder.servicename.text = currentitem.service
        holder.image.setImageResource(currentitem.image)

    }

    interface myinterface {
        fun onclick(dataItem: modelforservices, position: Int)
    }
}