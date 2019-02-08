package com.a4nt0n64r.weather


import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.a4nt0n64r.weather.Fragments.ExtendedDayViewFragment


class MainActivity : FragmentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateDayWeather()

    }

    fun updateDayWeather() {
        val frag = ExtendedDayViewFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.ext_fragment_place, frag)
            .commit()
        val s = getString(R.string.morning)
    }


}
