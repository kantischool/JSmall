package com.example.jsmall

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jsmall.modelclass.DataModel
import kotlinx.android.synthetic.main.data_view.view.*

class DataAdapter(private val context : Context, private val dataList : ArrayList<DataModel>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    inner class DataViewHolder(val dataView : View): RecyclerView.ViewHolder(dataView){

        init {
            dataView.data_card.setOnClickListener {
                val cardData = dataList[adapterPosition]
                Common.data = cardData
                context.startActivity(Intent(context, DetailActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val dview = LayoutInflater.from(context).inflate(R.layout.data_view,parent,false)
        return DataViewHolder(dview)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = dataList[position]
        holder.dataView.p_price.text = data.price.toString()
        holder.dataView.pt_title.text = data.title
        Glide.with(context).load(data.image).into(holder.dataView.dataImage)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}