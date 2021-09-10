package com.example.jsmall.ui.jsmall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsmall.R
import com.example.jsmall.adapter.CategoryAdapter
import com.example.jsmall.modelclass.CategoryModel
import kotlinx.android.synthetic.main.jsmall_fragment.*

class JsMallFragment : Fragment(R.layout.jsmall_fragment) {

    private lateinit var homeViewModel: JSMallViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list: ArrayList<CategoryModel> = ArrayList()
        list.add(CategoryModel("hi", "Electronics"))
        list.add(CategoryModel("hi", "Fashion"))
        list.add(CategoryModel("hi", "Grocery"))
        list.add(CategoryModel("hi", "Clothing"))
        list.add(CategoryModel("hi", "Plants"))
        list.add(CategoryModel("hi", "SunGlasses"))
        list.add(CategoryModel("hi", "Ornaments"))
        list.add(CategoryModel("hi", "Vegetables"))
        list.add(CategoryModel("hi", "Bikes"))
        list.add(CategoryModel("hi", "Shoo"))

        val adapter = CategoryAdapter(requireContext(),list)
        category_recycler.adapter = adapter
        category_recycler.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }
}