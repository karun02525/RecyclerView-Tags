package com.chingari.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_tag_property_type.view.*


class PostAdapter(var list: List<PostModel>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_tag_property_type, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cnt=itemView.context
        @SuppressLint("SetTextI18n", "NewApi")
        fun bindItems(model: PostModel) {
            itemView.apply {
                tv_level.text = model.text

                tv_level.setOnClickListener {
                    (cnt as PostActivity).addTags(model.text)
                }
            }
        }
    }

}

