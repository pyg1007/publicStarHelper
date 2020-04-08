package com.yonggeun.star.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yonggeun.star.R
import com.yonggeun.star.recyclerview.ColleagueInfo
import com.yonggeun.star.room.Colleague
import com.yonggeun.star.room.ColleagueViewModel
import kotlinx.android.synthetic.main.fragment_warrior.*
import kotlinx.android.synthetic.main.fragment_warrior.view.*

/**
 * A simple [Fragment] subclass.
 */
class Colleagues : Fragment() {

    private lateinit var model: ColleagueViewModel

    var listItem = ArrayList<Colleague>()
    var allItem = ArrayList<Colleague>()
    var job = "Warrior"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_warrior, container, false)
        model = ViewModelProvider(activity!!).get(ColleagueViewModel::class.java)
        model.allData.observe(activity!!, Observer {
            listItem.clear()
            allItem.clear()
            for (i: Int in it.indices) {
                allItem.add(it[i])
                if (it[i].Job == job)
                    listItem.add(it[i])
            }
            if (view.Warrior_Member.adapter != null)
                view.Warrior_Member.adapter!!.notifyDataSetChanged()
        })
        setHasOptionsMenu(true)
        expand(view)
        colleague(view, listItem)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.job, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Save -> {
                //TODO : Update
                for (i: Int in listItem.indices)
                    model.update(listItem[i])
                Toast.makeText(activity!!, "저장되었습니다.", Toast.LENGTH_SHORT).show()
            }
            R.id.Warrior -> {
                job = "Warrior"
                listItem.clear()
                for (i: Int in allItem.indices) {
                    if (allItem[i].Job == job) {
                        listItem.add(allItem[i])
                    }
                }
                Title_Layout.setBackgroundResource(R.color.Warrior)
                Title.setText(R.string.Warrior)
                Warrior_Member.adapter!!.notifyDataSetChanged()
            }
            R.id.Wizard -> {
                job = "Wizard"
                listItem.clear()
                for (i: Int in allItem.indices) {
                    if (allItem[i].Job == job) {
                        listItem.add(allItem[i])
                    }
                }
                Title_Layout.setBackgroundResource(R.color.Wizard)
                Title.setText(R.string.Wizard)
                Warrior_Member.adapter!!.notifyDataSetChanged()
            }
            R.id.thief -> {
                job = "thief"
                listItem.clear()
                for (i: Int in allItem.indices) {
                    if (allItem[i].Job == job) {
                        listItem.add(allItem[i])
                    }
                }
                Title_Layout.setBackgroundResource(R.color.Thief)
                Title.setText(R.string.Thief)
                Warrior_Member.adapter!!.notifyDataSetChanged()
            }
            R.id.Summoner -> {
                job = "Summoner"
                listItem.clear()
                for (i: Int in allItem.indices) {
                    if (allItem[i].Job == job) {
                        listItem.add(allItem[i])
                    }
                }
                Title_Layout.setBackgroundResource(R.color.Summoner)
                Title.setText(R.string.Summoner)
                Warrior_Member.adapter!!.notifyDataSetChanged()
            }
            R.id.Samurai -> {
                job = "Samurai"
                listItem.clear()
                for (i: Int in allItem.indices) {
                    if (allItem[i].Job == job) {
                        listItem.add(allItem[i])
                    }
                }
                Title_Layout.setBackgroundResource(R.color.Samurai)
                Title.setText(R.string.Samurai)
                Warrior_Member.adapter!!.notifyDataSetChanged()
            }
            R.id.Priests -> {
                job = "Priests"
                listItem.clear()
                for (i: Int in allItem.indices) {
                    if (allItem[i].Job == job) {
                        listItem.add(allItem[i])
                    }
                }
                Title_Layout.setBackgroundResource(R.color.Priests)
                Title.setText(R.string.Priests)
                Warrior_Member.adapter!!.notifyDataSetChanged()
            }
            R.id.Paladin -> {
                job = "Paladin"
                listItem.clear()
                for (i: Int in allItem.indices) {
                    if (allItem[i].Job == job) {
                        listItem.add(allItem[i])
                    }
                }
                Title_Layout.setBackgroundResource(R.color.Paladin)
                Title.setText(R.string.Paladin)
                Warrior_Member.adapter!!.notifyDataSetChanged()
            }
            R.id.Archer -> {
                job = "Archer"
                listItem.clear()
                for (i: Int in allItem.indices) {
                    if (allItem[i].Job == job) {
                        listItem.add(allItem[i])
                    }
                }
                Title_Layout.setBackgroundResource(R.color.Archer)
                Title.setText(R.string.Archer)
                Warrior_Member.adapter!!.notifyDataSetChanged()
            }
        }
        return false
    }

    private fun expand(view: View?) {
        var i = 0
        view!!.expand_view.setOnClickListener {
            i++
            if (i % 2 == 1) {
                expand_view.setImageResource(R.drawable.ic_expand_less_black_24dp)
                Warrior_Member.visibility = View.GONE
            } else {
                expand_view.setImageResource(R.drawable.ic_expand_more_black_24dp)
                Warrior_Member.visibility = View.VISIBLE
            }
        }
    }

    private fun colleague(view: View?, item: ArrayList<Colleague>) {
        view!!.Warrior_Member.setHasFixedSize(true)
        val decoration = DividerItemDecoration(activity!!, 1)
        val linearLayoutManager = LinearLayoutManager(activity)
        val colleague = ColleagueInfo(item)
        view.Warrior_Member.addItemDecoration(decoration)
        view.Warrior_Member.layoutManager = linearLayoutManager
        view.Warrior_Member.adapter = colleague
    }

}
