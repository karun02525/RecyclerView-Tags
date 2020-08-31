package com.chingari.myapplication.newChange

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.chingari.myapplication.R
import kotlinx.android.synthetic.main.layout_tag_property_type.view.*


class PropertyTypeAdapter(var list: List<PropertyTypeModel>) :
    RecyclerView.Adapter<PropertyTypeAdapter.ViewHolder>() {
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
        fun bindItems(model: PropertyTypeModel) {
            itemView.apply {
                tv_level.text = "#"+model.text

                if (model.isSelected)
                    selected(true, tv_level, cnt)
                else
                    selected(false, tv_level, cnt)

                tv_level.setOnClickListener {
                    (cnt as MainActivity).addTags()
                    model.isSelected = !model.isSelected
                    val allUnSelected = list.stream().anyMatch { o: PropertyTypeModel -> o.isSelected }
                    for (i in list) {
                        if (i.text == "Any" && i.isSelected) {
                            i.isSelected = false
                        }
                        if (!allUnSelected && i.text == "Any") {
                            i.isSelected = true
                        }
                    }

                    if (model.isSelected)
                        selected(true, tv_level, cnt)
                    else
                        selected(false, tv_level, cnt)

                    notifyDataSetChanged()
                }
            }
        }

        private fun selected(flag: Boolean, tv: TextView, cnt: Context) {
            if (flag) {
                tv.background = getDrawable(cnt,
                    R.drawable.tag_any_selected_blue_rectangle
                )
                tv.setTextColor(Color.WHITE)

            } else {
                tv.background = getDrawable(cnt,
                    R.drawable.tag_any_unselected_white_rectangle
                )
                tv.setTextColor(Color.BLACK)
            }
        }

    }

}

