package com.example.jsmall.ui.mygift

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jsmall.R

class MyGiftFragment : Fragment() {

    companion object {
        fun newInstance() = MyGiftFragment()
    }

    private lateinit var viewModel: MyGiftViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_gift_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyGiftViewModel::class.java)
        // TODO: Use the ViewModel
    }

}