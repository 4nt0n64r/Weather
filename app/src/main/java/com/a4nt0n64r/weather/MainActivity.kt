package com.a4nt0n64r.weather


import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.a4nt0n64r.weather.Fragments.ExtendedDayViewFragment


class MainActivity : FragmentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment()
    }

    fun addFragment() {
        val frag = ExtendedDayViewFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_fr, frag)
            .commit()
    }


}
