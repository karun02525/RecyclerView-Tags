package com.chingari.myapplication.newChange

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chingari.myapplication.R
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val propertyTypeArray = mutableListOf<PropertyTypeModel>()

    private val inputTagArray = mutableListOf<InputTagModel>()
    private lateinit var mInputTagsAdapter: InputTagsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        propertyTypeArray.run {
            add(
                PropertyTypeModel(
                    "Dance",
                    true
                )
            )
            add(PropertyTypeModel("Funny"))
            add(PropertyTypeModel("Life"))
            add(PropertyTypeModel("Music"))
            add(PropertyTypeModel("Cute"))
            add(PropertyTypeModel("Status"))
            add(PropertyTypeModel("Fail"))
            add(PropertyTypeModel("Motivation challenge"))
            add(PropertyTypeModel("Devotional"))
        }


        var layoutManager = FlexboxLayoutManager(baseContext)
        rv_input_container.layoutManager = layoutManager
        mInputTagsAdapter =
            InputTagsAdapter(inputTagArray)
        rv_input_container.adapter = mInputTagsAdapter



        property_type_container.run {
            layoutManager = FlexboxLayoutManager(context)
            adapter =
                PropertyTypeAdapter(
                    propertyTypeArray
                )

        }
    }

    fun addTags() {
        for (i in propertyTypeArray) {
            if (i.isSelected) {
                inputTagArray.add(
                    InputTagModel(
                        i.text
                    )
                )
                mInputTagsAdapter.notifyDataSetChanged()
            }
        }

    }
}