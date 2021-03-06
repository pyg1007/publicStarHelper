package com.yonggeun.become_star.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yonggeun.become_star.R
import com.yonggeun.become_star.recyclerview.Impact_Adapter
import kotlinx.android.synthetic.main.activity_first__impact.*

class Firstimpact(
    context: Context,
    var Colleague_Type: String?,
    val onItemClick: (String) -> Unit
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first__impact)

        setRecycler()
    }

    private fun setRecycler() {
        Reinforce_List.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context)
        val array: Array<String> = when (Colleague_Type) {
            "Transcendence" -> {
                context.resources.getStringArray(R.array.transcendence_infinite)
            }
            "Defeat" -> {
                context.resources.getStringArray(R.array.Defeat_infinite)
            }
            else -> context.resources.getStringArray(R.array.deity_infinite)
        }
        val list: ArrayList<String> = ArrayList()
        for (i in array) {
            list.add(i)
        }

        Reinforce_List.layoutManager = linearLayoutManager
        val adapter =
            Impact_Adapter(list) { String ->
                onItemClick(String)
                dismiss()
            }
        Reinforce_List.adapter = adapter
    }

}
