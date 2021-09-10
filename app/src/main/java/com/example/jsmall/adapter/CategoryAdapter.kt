package com.example.jsmall.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jsmall.R
import com.example.jsmall.modelclass.CategoryModel
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryAdapter(val context: Context, private val categoryList: ArrayList<CategoryModel>): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    inner class CategoryViewHolder(private val categoryItem : View): RecyclerView.ViewHolder(categoryItem){
        val categoryImage = categoryItem.categoryicon!!
        val categoryName = categoryItem.categoryname!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = categoryList[position]
        holder.categoryImage.setImageResource(R.drawable.ic_home)
        holder.categoryName.text = item.categoryName


    }

    override fun getItemCount(): Int {
       return categoryList.size
    }
}