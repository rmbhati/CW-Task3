package com.kgk.task3.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.kgk.task3.R
import com.kgk.task3.databinding.RowHomeBinding
import kotlinx.android.synthetic.main.row_home.view.*

class HomeAdapter(
    private val context: Context, private val dataList: List<String>,
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(itemView: RowHomeBinding) : RecyclerView.ViewHolder(itemView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.row_home, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(context).load(dataList[position]).placeholder(circularProgressDrawable)
            .error(circularProgressDrawable).into(holder.itemView.img)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}