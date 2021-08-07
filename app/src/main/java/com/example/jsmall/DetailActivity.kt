package com.example.jsmall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val da = Common.data

        category.text = da!!.category
        priced.text = da.price.toString()
        titled.text = da.title
        desd.text = da.description
        Glide.with(this).load(da.image).placeholder(R.drawable.ic_baseline_image_24).into(imageView)
    }
}