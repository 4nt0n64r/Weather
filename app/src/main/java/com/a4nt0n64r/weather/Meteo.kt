package com.a4nt0n64r.weather

import android.content.Context

class Meteo {

    public lateinit var date: String
    public lateinit var tod: String
    public lateinit var temp: String
    public lateinit var pressure: String

    override fun toString(): String {
        return "$date | $tod | $temp | $pressure"
    }

    fun timeOfDay(): String {
        lateinit var s: String
        // хороший вариант, но Classifyer context does not have companion object...
//        val c = Context
//        when (tod) {
//            "0" -> s = c.getString(R.string.morning)
//            "1" -> s = c.getString(R.string.day)
//            "2" -> s = c.getString(R.string.evening)
//            "3" -> s = c.getString(R.string.night)
//        }
        when (tod) {
            "0" -> s = "Утро"
            "1" -> s = "День"
            "2" -> s = "Вечер"
            "3" -> s = "Ночь"
        }
        return s
    }

    fun pressure():String = "Давление: " + pressure.toString() + " мм. рт. ст."
}