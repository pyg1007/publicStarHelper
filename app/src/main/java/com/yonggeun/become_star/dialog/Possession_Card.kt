package com.yonggeun.become_star.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yonggeun.become_star.R
import com.yonggeun.become_star.recyclerview.Possession_Adapter
import kotlinx.android.synthetic.main.activity_possesion__card.*

class Possession_Card(
    context: Context,
    var Colleague_Type: String?,
    var onItemClick: (String) -> Unit
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_possesion__card)

        setRecycler()
    }

    private fun setRecycler() {
        Possesion_List.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(context)
        val array: Array<String> = when (Colleague_Type) {
            "Transcendence" -> {
                context.resources.getStringArray(R.array.transcendence_Colleague)
            }
            "Defeat" -> {
                context.resources.getStringArray(R.array.Defeat_Colleague)
            }
            else -> context.resources.getStringArray(R.array.deity_Colleague)
        }

        val list: ArrayList<String> = ArrayList()
        for (i in array) {
            list.add(i)
        }

        Possesion_List.layoutManager = linearLayoutManager
        val adapter =
            Possession_Adapter(list) { String ->
                onItemClick(String)
                dismiss()
            }
        Possesion_List.adapter = adapter
    }
}
