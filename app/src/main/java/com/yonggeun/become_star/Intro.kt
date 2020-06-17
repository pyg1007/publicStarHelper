package com.yonggeun.become_star

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yonggeun.become_star.room.ColleagueViewModel


class Intro : AppCompatActivity() {

    var nextActivityHandler : Handler? = null
    var sharedPreferences : SharedPreferences? = null
    private lateinit var model: ColleagueViewModel
    private var thread : Thread? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        model = ViewModelProvider(this).get(ColleagueViewModel::class.java)

        nextActivityHandler = NextActivityHandler(this)
        sharedPreferences = getSharedPreferences("First_Start", 0)

        thread = ThreadClass()
        (thread as ThreadClass).start()
    }

    inner class ThreadClass : Thread(){
        override fun run() {
            SystemClock.sleep(3000)
            val check : Boolean = sharedPreferences!!.getBoolean("First", true)

            if (check){
                first()
                sharedPreferences!!.edit().putBoolean("First", false).apply()
                nextActivityHandler?.sendEmptyMessage(1000)
            }else
                nextActivityHandler?.sendEmptyMessage(1000)
        }
    }

    private fun first(){
        //TODO : 초월 Transcendence 패왕 Defeat 신위 Deity
        //TODO : 데이터들
    }

    private class NextActivityHandler(private val activity: Activity) : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if (msg.what == 1000){
                val intent = Intent(activity, MainActivity::class.java)
                activity.startActivity(intent)
                activity.finish()
            }
        }
    }

    override fun onBackPressed() {

    }

    override fun onDestroy() {
        if(thread!!.isAlive)
            thread!!.interrupt()
        super.onDestroy()
    }
}
