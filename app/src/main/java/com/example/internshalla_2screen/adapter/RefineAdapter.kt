package com.example.internshalla_2screen.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internshalla_2screen.R
import com.example.internshalla_2screen.modelclasses.refinemodel

class RefineAdapter(private var context: Context, private var listener:myinterface): RecyclerView.Adapter<RefineAdapter.myviewholder>() {
        private var item = ArrayList<refinemodel>()

        inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val coffee : TextView = itemView.findViewById(R.id.coffee)
            val layout : LinearLayout = itemView.findViewById(R.id.refinelayout)

        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
            val viewholder =  myviewholder(
                LayoutInflater.from(context).
                inflate(R.layout.refinemodel,parent,false))


            viewholder.layout.setOnClickListener {
                listener.onclick(item[viewholder.adapterPosition], position = viewholder.adapterPosition)
            }
            return viewholder
        }
        override fun getItemCount(): Int {
            return item.size
        }
        @SuppressLint("NotifyDataSetChanged")
        fun updatelist(newlist:ArrayList<refinemodel>){
            item.clear()
            item.addAll(newlist)
            notifyDataSetChanged()
        }

        override fun onBindViewHolder(holder: myviewholder, position: Int) {
            val currentitem = item[position]
           holder.coffee.text = currentitem.itemname

        }
        interface  myinterface{
            fun onclick(dataItem: refinemodel,position: Int)
        }
    }
