package com.kgk.task3.ui

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.kgk.task3.R
import com.kgk.task3.base.BaseActivity
import com.kgk.task3.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity() {
    private lateinit var activityBinding: ActivityMainBinding
    private val baseURL = "https://rameshpersonal.000webhostapp.com/images/Task3/"

    override fun initView() {
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun initData() {
        val listImage = ArrayList<String>()
        for (i in 1..50) {
            listImage.add("$baseURL$i.png")
        }
        recyclerView.layoutManager = GridLayoutManager(this, 10)
        recyclerView.adapter = HomeAdapter(this, listImage)
    }
}