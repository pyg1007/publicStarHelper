package com.yonggeun.become_star.recyclerview

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.yonggeun.become_star.R
import com.yonggeun.become_star.dialog.Firstimpact
import com.yonggeun.become_star.dialog.Possession_Card
import com.yonggeun.become_star.room.Colleague
import kotlinx.android.synthetic.main.colleague.view.*

class ColleagueInfo(var Info: ArrayList<Colleague>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val header: Int = 0
    private val item: Int = 1

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class ItemViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {

        fun bind(model: Colleague) {
            var reinforce: Int = 0
            var have: Int = 0
            val full: Int = setFull(model)
            var cal: Int

            itemView.colleague_Name.text = model.Colleague_Name
            itemView.First_Impact.text = model.First_Impact
            itemView.First_Impact.setOnClickListener {
                val firstImpact = Firstimpact(
                    context,
                    model.Colleague_Type
                ) { String ->
                    itemView.First_Impact.text = String
                    model.First_Impact = String
                    cal = full
                    reinforce = getCount(model, itemView.First_Impact.text.toString())
                    cal = cal - have - reinforce
                    setText(cal)
                }
                firstImpact.show()
                dialogResize(firstImpact, 0.6f, 0.4f)
            }

            itemView.Possesion_infiniteCard.text = model.Possession_infiniteCard.toString()
            itemView.Possesion_infiniteCard.setOnClickListener {
                val possession = Possession_Card(
                    context,
                    model.Colleague_Type
                ) { String ->
                    itemView.Possesion_infiniteCard.text = String
                    model.Possession_infiniteCard = Integer.parseInt(String)
                    cal = full
                    have = Integer.parseInt(itemView.Possesion_infiniteCard.text.toString())
                    cal = cal - have - reinforce
                    setText(cal)
                }
                possession.show()
                dialogResize(possession, 0.6f, 0.4f)
            }

            cal = full
            reinforce = getCount(model, itemView.First_Impact.text.toString())
            have = Integer.parseInt(itemView.Possesion_infiniteCard.text.toString())
            cal = cal - reinforce - have
            setText(cal)
        }

        private fun dialogResize(dialog: Dialog, horizontal: Float, vertical: Float) {
            val windowManager: WindowManager =
                context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val disPlay: Display = windowManager.defaultDisplay
            val point = Point()
            disPlay.getSize(point)

            val window: Window = dialog.window!!

            val x: Int = (point.x * horizontal).toInt()
            val y: Int = (point.y * vertical).toInt()

            window.setLayout(x, y)
        }


        private fun getCount(model: Colleague, s: String): Int {
            when (model.Colleague_Type) {
                "Transcendence" -> {
                    when (s) {
                        "초월" -> {
                            return 0
                        }
                        "패왕" -> {
                            return 1
                        }
                        "ARCH" -> {
                            return 2
                        }
                        "Infinite" -> {
                            return 3
                        }
                        "Infinite 1" -> {
                            return 4
                        }
                        "Infinite 2" -> {
                            return 5
                        }
                        "Infinite 3" -> {
                            return 6
                        }
                        "Infinite 4" -> {
                            return 8
                        }
                        "Infinite 5" -> {
                            return 10
                        }
                        "Infinite 6" -> {
                            return 12
                        }
                        "Infinite 7" -> {
                            return 15
                        }
                        "Infinite 8" -> {
                            return 18
                        }
                        "Infinite 9" -> {
                            return 21
                        }
                        "Infinite 10" -> {
                            return 25
                        }
                    }
                }
                "Defeat" -> {
                    when (s) {
                        "패왕" -> {
                            return 0
                        }
                        "ARCH" -> {
                            return 1
                        }
                        "Infinite" -> {
                            return 2
                        }
                        "Infinite 1" -> {
                            return 3
                        }
                        "Infinite 2" -> {
                            return 4
                        }
                        "Infinite 3" -> {
                            return 5
                        }
                        "Infinite 4" -> {
                            return 7
                        }
                        "Infinite 5" -> {
                            return 9
                        }
                        "Infinite 6" -> {
                            return 11
                        }
                        "Infinite 7" -> {
                            return 14
                        }
                        "Infinite 8" -> {
                            return 17
                        }
                        "Infinite 9" -> {
                            return 20
                        }
                        "Infinite 10" -> {
                            return 24
                        }
                    }
                }
                else -> {
                    when (s) {
                        "ARCH" -> {
                            return 0
                        }
                        "Infinite" -> {
                            return 1
                        }
                        "Infinite 1" -> {
                            return 2
                        }
                        "Infinite 2" -> {
                            return 3
                        }
                        "Infinite 3" -> {
                            return 4
                        }
                        "Infinite 4" -> {
                            return 6
                        }
                        "Infinite 5" -> {
                            return 8
                        }
                        "Infinite 6" -> {
                            return 10
                        }
                        "Infinite 7" -> {
                            return 13
                        }
                        "Infinite 8" -> {
                            return 16
                        }
                        "Infinite 9" -> {
                            return 19
                        }
                        "Infinite 10" -> {
                            return 23
                        }
                    }
                }
            }
            return 0
        }

        private fun setFull(model: Colleague): Int {
            return when {
                model.Colleague_Type!! == "Transcendence" -> {
                    25
                }
                model.Colleague_Type!! == "Defeat" -> {
                    24
                }
                else -> {
                    23
                }
            }
        }

        private fun setText(cal: Int) {
            when {
                cal > 10 -> {
                    itemView.need_CardCount.text = cal.toString()
                    itemView.need_CardCount.setTextColor(Color.WHITE)
                }
                cal > 5 -> {
                    itemView.need_CardCount.text = cal.toString()
                    itemView.need_CardCount.setTextColor(Color.GREEN)
                }
                else -> {
                    itemView.need_CardCount.text = cal.toString()
                    itemView.need_CardCount.setTextColor(Color.RED)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0)
            header
        else
            item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.header, parent, false)
            HeaderViewHolder(view)
        } else {
            val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.colleague, parent, false)
            ItemViewHolder(
                view,
                parent.context
            )
        }
    }

    override fun getItemCount(): Int {
        return Info.size + 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type: Int = getItemViewType(position)
        if (type == item) {
            if (holder is ItemViewHolder) {
                holder.bind(Info[position - 1])
            }
        }
    }


}