package com.yonggeun.star

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yonggeun.star.fragment.Colleagues
import com.yonggeun.star.fragment.Liking
import com.yonggeun.star.fragment.Weapon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        settingUI()
    }

    private fun settingUI() {
        supportFragmentManager.beginTransaction().replace(
            R.id.frame,
            Colleagues()
        ).commitAllowingStateLoss()
        setToolbar()

        Bottom.setOnNavigationItemSelectedListener(this)
    }

    private fun setToolbar() {
        setSupportActionBar(Toolbar)
        Toolbar.setTitle(R.string.app_name)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Colleague -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frame,
                    Colleagues()
                ).commitAllowingStateLoss()
                return true
            }
            R.id.Liking -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frame,
                    Liking()
                ).commitAllowingStateLoss()
                return true
            }
            R.id.weapon -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frame,
                    Weapon()
                ).commitAllowingStateLoss()
                return true
            }
        }
        return false
    }
}
