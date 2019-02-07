package com.a4nt0n64r.weather.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a4nt0n64r.weather.APIservice
import com.a4nt0n64r.weather.FragmentAdapter
import com.a4nt0n64r.weather.Meteo
import com.a4nt0n64r.weather.R
import kotlinx.android.synthetic.main.fragment_extended_day_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ExtendedDayViewFragment : Fragment() {

    lateinit var adapter: FragmentAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_extended_day_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = FragmentAdapter()
        list_in_fragment.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        list_in_fragment.adapter = adapter

        tv.setOnClickListener {
            getListMeteo()
            Toast.makeText(context, "A", Toast.LENGTH_SHORT).show()
        }
    }

    fun getListMeteo() {


        //val adapter = ArrayAdapter<Meteo>(applicationContext, android.R.layout.simple_list_item_1)

        val retrofit = Retrofit.Builder()
            //.baseUrl("http://icomms.ru/")
            .baseUrl("https://raw.githubusercontent.com/")
            //https://raw.githubusercontent.com/4nt0n64r/pogoda/master/pogoda.php
            .addConverterFactory(GsonConverterFactory.create())

            .build()

        val apiService = retrofit.create(APIservice::class.java)

        val call = apiService.getMeteo()

        call.enqueue(object : Callback<List<Meteo>> {
            override fun onFailure(call: Call<List<Meteo>>, t: Throwable) {
                Toast.makeText(context, "FAIL, что-то не так!", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Meteo>>, response: Response<List<Meteo>>) {
                adapter.setData(response.body())
            }
        })


    }


    fun newInstance() = ExtendedDayViewFragment()

}
