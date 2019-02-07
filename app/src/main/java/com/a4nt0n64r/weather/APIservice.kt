package com.a4nt0n64r.weather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIservice {

    //@GET("inf/meteo.php")
    @GET("4nt0n64r/pogoda/master/pogoda.php")
    fun getMeteo():Call<List<Meteo>>
}