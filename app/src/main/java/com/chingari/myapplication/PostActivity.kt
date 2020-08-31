package com.chingari.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {

    private val postTagArray = mutableListOf<PostModel>()
    private lateinit var mPostAdapter: PostAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)


        postTagArray.run {
            add(PostModel("#Dance", true))
            add(PostModel("#Funny"))
            add(PostModel("#Life"))
            add(PostModel("#Music"))
            add(PostModel("#Cute"))
            add(PostModel("#Status"))
            add(PostModel("#Fail"))
            add(PostModel("#Motivation challenge"))
            add(PostModel("#Devotional"))
        }

        rv_hashtags.run {
            layoutManager = FlexboxLayoutManager(context)
            mPostAdapter = PostAdapter(postTagArray)
            adapter = mPostAdapter
        }
    }

    fun addTags(mess:String) {
            if(!edit_container.text.contains(mess)) {
                edit_container.text.append("$mess ")
            }else {
                Toast.makeText(this, "$mess Already added", Toast.LENGTH_SHORT).show()
            }
    }
}