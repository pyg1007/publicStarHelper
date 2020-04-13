package com.yonggeun.become_star.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yonggeun.become_star.R
import kotlinx.android.synthetic.main.possesion_list.view.*

class Possession_Adapter(var data: ArrayList<String>, var itemClick: (String) -> Unit) :
    RecyclerView.Adapter<Possession_Adapter.CustomViewHolder>() {

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(s: String) {

            itemView.Possesion.text = s
            itemView.setOnClickListener {
                itemClick(s)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.possesion_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(data[position])
    }


}