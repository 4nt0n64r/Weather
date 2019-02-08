package com.a4nt0n64r.weather

import android.database.DataSetObserver
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class FragmentAdapter : ListDelegationAdapter<List<Meteo>>() {


    init {
        delegatesManager.addDelegate(ExtendedDelegate())
    }

    fun setData(items: List<Meteo>?) {
        this.items = items
        notifyDataSetChanged()
    }
}

private class ExtendedDelegate :
    AbsListItemAdapterDelegate<Meteo, Meteo, ExtendedDelegate.ViewHolder>() {

    override fun isForViewType(item: Meteo, items: List<Meteo>, position: Int): Boolean {
        return item is Meteo
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_meteo,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(item: Meteo, viewHolder: ViewHolder, payloads: List<Any>) {
        //TODO(изменить)
        viewHolder.pressure.text = item.pressure()
        viewHolder.timeOfDay.text = item.timeOfDay()
        viewHolder.temp.text = item.temp

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //TODO(изменить)
        val pressure: TextView = itemView.findViewById(R.id.pressure_view)
        val timeOfDay: TextView = itemView.findViewById(R.id.tod)
        val temp: TextView = itemView.findViewById(R.id.temp)

    }
}


