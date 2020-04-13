package com.yonggeun.become_star.fragment

import android.annotation.SuppressLint
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.yonggeun.become_star.R
import kotlinx.android.synthetic.main.fragment_weapon.*
import kotlinx.android.synthetic.main.fragment_weapon.view.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class Weapon : Fragment() {

    var initRank: String? = null
    var initStandard: Int = 0
    var step: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_weapon, container, false)

        init(view)
        calClick(view)
        return view
    }

    private fun init(view: View?) {

        if (Build.VERSION.SDK_INT >= 29) {
            view!!.Level.background.colorFilter =
                BlendModeColorFilter(R.color.spinner, BlendMode.DST_IN)
        } else {
            view!!.Level.background.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(activity!!, R.color.spinner),
                PorterDuff.Mode.DST_IN
            )
        }

        view.Radio_Group.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.Radio_C -> {
                    initRank = "C"
                    initStandard = 3
                    view.full_shame.text = initStandard.toString()
                    view.Level.adapter = ArrayAdapter(
                        activity!!,
                        R.layout.spinner_item,
                        activity!!.resources.getStringArray(R.array.C_Rank_Weapon)
                    )
                    view.Level.onItemSelectedListener = listener
                }
                R.id.Radio_B -> {
                    initRank = "B"
                    initStandard = 6
                    view.full_shame.text = initStandard.toString()
                    view.Level.adapter = ArrayAdapter(
                        activity!!,
                        R.layout.spinner_item,
                        activity!!.resources.getStringArray(R.array.B_Rank_Weapon)
                    )
                    view.Level.onItemSelectedListener = listener
                }
                R.id.Radio_A -> {
                    initRank = "A"
                    initStandard = 12
                    view.full_shame.text = initStandard.toString()
                    view.Level.adapter = ArrayAdapter(
                        activity!!,
                        R.layout.spinner_item,
                        activity!!.resources.getStringArray(R.array.A_Rank_Weapon)
                    )
                    view.Level.onItemSelectedListener = listener
                }
                R.id.Radio_S -> {
                    initRank = "S"
                    initStandard = 24
                    view.full_shame.text = initStandard.toString()
                    view.Level.adapter = ArrayAdapter(
                        activity!!,
                        R.layout.spinner_item,
                        activity!!.resources.getStringArray(R.array.S_Rank_Weapon)
                    )
                    view.Level.onItemSelectedListener = listener
                }
                R.id.Radio_SS -> {
                    initRank = "SS"
                    initStandard = 48
                    view.full_shame.text = initStandard.toString()
                    view.Level.adapter = ArrayAdapter(
                        activity!!,
                        R.layout.spinner_item,
                        activity!!.resources.getStringArray(R.array.SS_Rank_Weapon)
                    )
                    view.Level.onItemSelectedListener = listener
                }
                R.id.Radio_SSS -> {
                    initRank = "SSS"
                    initStandard = 96
                    view.full_shame.text = initStandard.toString()
                    view.Level.adapter = ArrayAdapter(
                        activity!!,
                        R.layout.spinner_item,
                        activity!!.resources.getStringArray(R.array.SSS_Rank_Weapon)
                    )
                    view.Level.onItemSelectedListener = listener
                }
            }
        }
    }

    private fun calClick(v: View?) {
        v!!.Cal.setOnClickListener {
            val point: Int = try {
                Integer.parseInt(Point.text.toString())
            } catch (e: NumberFormatException) {
                0
            }
            val c: Int = try {
                Integer.parseInt(Rank_C.text.toString()) * 3
            } catch (e: NumberFormatException) {
                0
            }
            val b: Int = try {
                Integer.parseInt(Rank_B.text.toString()) * 15
            } catch (e: NumberFormatException) {
                0
            }
            val a: Int = try {
                Integer.parseInt(Rank_A.text.toString()) * 45
            } catch (e: NumberFormatException) {
                0
            }
            val s: Int = try {
                Integer.parseInt(Rank_S.text.toString()) * 117
            } catch (e: NumberFormatException) {
                0
            }
            val ss: Int = try {
                Integer.parseInt(Rank_SS.text.toString()) * 285
            } catch (e: NumberFormatException) {
                0
            }
            val sss: Int = try {
                Integer.parseInt(Rank_SSS.text.toString()) * 669
            } catch (e: NumberFormatException) {
                0
            }

            calculation(point, c, b, a, s, ss, sss)
        }
    }

    private val listener: AdapterView.OnItemSelectedListener =
        object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                step = position
            }
        }

    private fun Double.roundTo2DecimalPlaces() =
        BigDecimal(this).setScale(4, BigDecimal.ROUND_HALF_UP).toDouble()

    @SuppressLint("SetTextI18n")
    private fun calculation(point: Int, c: Int, b: Int, a: Int, s: Int, ss: Int, sss: Int) {
        var max: Int = 0
        var rank = initRank
        var standard = initStandard
        full_shame.text = standard.toString()
        when (rank) {
            "C" -> {
                step *= 3
                max = 12
            }
            "B" -> {
                step *= 6
                max = 30
            }
            "A" -> {
                step *= 12
                max = 72
            }
            "S" -> {
                step *= 24
                max = 168
            }
            "SS" -> {
                step *= 48
                max = 384
            }
            "SSS" -> {
                step *= 96
                max = 864
            }
        }

        var sum = step + point + c + b + a + s + ss + sss

        while (true) {
            if (standard != 0) {
                val share: Int = sum / standard
                val reminder: Int = sum % standard
                if (rank.equals("C")) {
                    if (share >= 4) {
                        sum -= max
                        rank = "B"
                        standard = 6
                        full_shame.text = standard.toString()
                        max = 30
                    } else {
                        Result_Rank.text = rank + "급 " + share + "강"
                        shame.text = reminder.toString()
                        if (((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().length <= 5)
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString() + "%"
                        else
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().substring(
                                    0,
                                    5
                                ) + "%"
                        break
                    }
                } else if (rank.equals("B")) {
                    if (share >= 5) {
                        sum -= max
                        rank = "A"
                        standard = 12
                        full_shame.text = standard.toString()
                        max = 72
                    } else {
                        Result_Rank.text = rank + "급 " + share + "강"
                        shame.text = reminder.toString()
                        if (((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().length <= 5)
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString() + "%"
                        else
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().substring(
                                    0,
                                    5
                                ) + "%"
                        break
                    }
                } else if (rank.equals("A")) {
                    if (share >= 6) {
                        sum -= max
                        rank = "S"
                        standard = 24
                        full_shame.text = standard.toString()
                        max = 168
                    } else {
                        Result_Rank.text = rank + "급 " + share + "강"
                        shame.text = reminder.toString()
                        if (((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().length <= 5)
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString() + "%"
                        else
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().substring(
                                    0,
                                    5
                                ) + "%"
                        break
                    }
                } else if (rank.equals("S")) {
                    if (share >= 7) {
                        sum -= max
                        rank = "SS"
                        standard = 48
                        full_shame.text = standard.toString()
                        max = 384
                    } else {
                        Result_Rank.text = rank + "급 " + share + "강"
                        shame.text = reminder.toString()
                        if (((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().length <= 5)
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString() + "%"
                        else
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().substring(
                                    0,
                                    5
                                ) + "%"
                        break
                    }
                } else if (rank.equals("SS")) {
                    if (share >= 8) {
                        sum -= max
                        rank = "SSS"
                        standard = 96
                        full_shame.text = standard.toString()
                        max = 864
                    } else {
                        Result_Rank.text = rank + "급 " + share + "강"
                        shame.text = reminder.toString()
                        if (((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().length <= 5)
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString() + "%"
                        else
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().substring(
                                    0,
                                    5
                                ) + "%"
                        break
                    }
                } else if (rank.equals("SSS")) {
                    if (share >= 9) {
                        sum -= max
                        rank = "U"
                        standard = 192
                        full_shame.text = standard.toString()
                        max = 1920
                    } else {
                        Result_Rank.text = rank + "급 " + share + "강"
                        shame.text = reminder.toString()
                        if (((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().length <= 5)
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString() + "%"
                        else
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().substring(
                                    0,
                                    5
                                ) + "%"
                        break
                    }
                } else if (rank.equals("U")) {
                    if (share >= 10) {
                        sum -= max
                        rank = "I"
                        standard = 384
                        full_shame.text = standard.toString()
                        max = 4224
                    } else {
                        Result_Rank.text = rank + "급 " + share + "강"
                        shame.text = reminder.toString()
                        if (((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().length <= 5)
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString() + "%"
                        else
                            percent.text =
                                ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().substring(
                                    0,
                                    5
                                ) + "%"
                        break
                    }
                } else if (rank.equals("I")) {
                    Result_Rank.text = rank + "급 " + share + "강"
                    shame.text = reminder.toString()
                    if (((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().length <= 5)
                        percent.text =
                            ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString() + "%"
                    else
                        percent.text =
                            ((reminder.toDouble() / standard.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().substring(
                                0,
                                5
                            ) + "%"
                    break
                }
            }else
                break
        }
    }
}
