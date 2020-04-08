package com.yonggeun.star.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yonggeun.star.R
import kotlinx.android.synthetic.main.fragment_liking.*
import kotlinx.android.synthetic.main.fragment_liking.view.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class Liking : Fragment() {

    val InitLike: Int = 1300

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_liking, container, false)
        clickButton(view)
        return view
    }


    private fun clickButton(view: View?) {
        view!!.Cal.setOnClickListener {
            calculation()
        }

        view.Init.setOnClickListener {
            Liking_1.setText("")
            Liking_2.setText("")
            Liking_3.setText("")
            Event_Liking_1.setText("")
            Event_Liking_2.setText("")
            Event_Liking_3.setText("")
            Current_Heart.setText("")
            Current_Percent.setText("")
            Use_InitCard.setText("")
            Apply_Heart.setText("")
            Used_InitCard.text = ""
            Result_Heart.text = ""
            Get_InfinityCard.text = ""
            Result_Percent.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculation() {
        //일반호감도
        val likeOne: Int = try {
            Integer.parseInt(Liking_1.text.toString())
        } catch (e: NumberFormatException) {
            0
        }
        val likeTwo: Int = try {
            Integer.parseInt(Liking_1.text.toString())
        } catch (e: NumberFormatException) {
            0
        }
        val likeThree: Int = try {
            Integer.parseInt(Liking_1.text.toString())
        } catch (e: NumberFormatException) {
            0
        }

        //특수호감도
        val likeEventOne: Int = try {
            Integer.parseInt(Event_Liking_1.text.toString())
        } catch (e: NumberFormatException) {
            0
        }
        val likeEventTwo: Int = try {
            Integer.parseInt(Event_Liking_2.text.toString())
        } catch (e: NumberFormatException) {
            0
        }
        val likeEventThree: Int = try {
            Integer.parseInt(Event_Liking_3.text.toString())
        } catch (e: NumberFormatException) {
            0
        }

        val currentHeart: Int = try {
            Integer.parseInt(Current_Heart.text.toString())
        } catch (e: NumberFormatException) {
            0
        }
        val currentPercent: Double = try {
            Current_Percent.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }

        val useInitCard: Int = try {
            Integer.parseInt(Use_InitCard.text.toString())
        } catch (e: NumberFormatException) {
            0
        }
        val useLevel: Int = try {
            Integer.parseInt(Apply_Heart.text.toString())
        } catch (e: NumberFormatException) {
            0
        }

        val initMax = value(currentHeart)
        //  일반호감도 * 10 + 특수호감도 * 35 + 강화도
        val likeSum: Int =
            (likeOne + likeTwo + likeThree) * 10 + (likeEventOne + likeEventTwo + likeEventThree) * 35 + (initMax * currentPercent * 0.01).toInt()

        var count = 0 // 획득한 인피카드 수
        var initCount = 0
        var useInitCount = useInitCard
        var heart = currentHeart
        var sum = likeSum
        Log.e("like : ", likeSum.toString())
        while (true) {
            val max = value(heart)
            sum -= max
            if (sum < 0) {
                sum += max
                Log.e("sum : ", sum.toString())
                Log.e("max : ", max.toString())
                Used_InitCard.text = initCount.toString()
                Result_Heart.text = heart.toString()
                if (((sum.toDouble() / max.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().length == 5)
                    Result_Percent.text =
                        ((sum.toDouble() / max.toDouble()).roundTo2DecimalPlaces() * 100.0).toString() + "%"
                else
                    Result_Percent.text =
                        ((sum.toDouble() / max.toDouble()).roundTo2DecimalPlaces() * 100.0).toString().substring(
                            0,
                            5
                        ) + "%"
                Get_InfinityCard.text = count.toString()
                break
            }
            heart++
            if (heart >= useLevel && useLevel != 0 && useInitCount > 0) {
                heart = 0
                useInitCount--
                initCount++
            }
            count++
        }


    }

    private fun Double.roundTo2DecimalPlaces() =
        BigDecimal(this).setScale(4, BigDecimal.ROUND_HALF_UP).toDouble()

    private fun value(Heart: Int): Int {
        val init = 1300

        var count = 0
        var temp = init
        while (true) {
            if (count != 0) {
                temp += 200 + 100 * (count - 1)
            }
            if (Heart == count) {
                return temp
            } else {
                count++
            }
        }
    }
}
