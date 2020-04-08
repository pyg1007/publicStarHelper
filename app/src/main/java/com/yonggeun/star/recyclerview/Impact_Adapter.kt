package com.yonggeun.star.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yonggeun.star.R
import kotlinx.android.synthetic.main.reinforce_list.view.*

class Impact_Adapter(var data: ArrayList<String>, val itemClick: (String) -> Unit) :
    RecyclerView.Adapter<Impact_Adapter.CustomViewHolder>() {


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(s: String) {

            itemView.Reinforce.text = s
            itemView.setOnClickListener() {
                itemClick(s)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.reinforce_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(data[position])
    }


}