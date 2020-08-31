package com.chingari.myapplication.java;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.chingari.myapplication.R;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;

public class PostActivityDemo extends AppCompatActivity {


    private HashTagsAdapter adapter;
    private ArrayList<HashTagsModel> modelList;
    private EditText edit_container;
    private RecyclerView rv_hashtags;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        edit_container=findViewById(R.id.edit_container);
        rv_hashtags=findViewById(R.id.rv_hashtags);

        initArray();
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setAlignItems(AlignItems.CENTER);
        rv_hashtags.setLayoutManager(layoutManager);
        adapter = new HashTagsAdapter(this, modelList);
        rv_hashtags.setAdapter(adapter);

    }

    private void initArray() {
        modelList=new ArrayList<>();
        modelList.add(new HashTagsModel("\uD83C\uDFC6 #Dance"));
        modelList.add(new HashTagsModel("#Funny"));
        modelList.add(new HashTagsModel("#Life"));
        modelList.add(new HashTagsModel("\uD83D\uDE03 #Smileys & People"));
        modelList.add(new HashTagsModel("#Fail"));
        modelList.add(new HashTagsModel("\uD83E\uDD70 #Smiling Face with Hearts"));
        modelList.add(new HashTagsModel("#Status"));
        modelList.add(new HashTagsModel("\uD83D\uDC4D #Thumbs Up"));
        modelList.add(new HashTagsModel("#Devotional"));
        modelList.add(new HashTagsModel("\uD83D\uDC4D #"));
        modelList.add(new HashTagsModel("#Motivation challenge"));
        modelList.add(new HashTagsModel("#Music"));
        modelList.add(new HashTagsModel("\uD83C\uDF82 #Birthday"));
        modelList.add(new HashTagsModel("#Bollywood"));
        modelList.add(new HashTagsModel("\uD83D\uDC95 #Hearts"));
        modelList.add(new HashTagsModel("#News"));
        modelList.add(new HashTagsModel("\uD83D\uDC98 #Valentine’s Day"));
    }

    void addTags(String tags){
        if(!edit_container.getText().toString().contains(tags)) {
            edit_container.append(tags+" ");
        }else {
            Toast.makeText(this, tags+" already added", Toast.LENGTH_SHORT).show();
        }
    }
}
