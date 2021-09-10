package com.example.jsmall.ui.addtocart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jsmall.R

class AddToCartFragment : Fragment() {

    companion object {
        fun newInstance() = AddToCartFragment()
    }

    private lateinit var viewModel: AddToCartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_to_cart_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddToCartViewModel::class.java)
        // TODO: Use the ViewModel
    }

}