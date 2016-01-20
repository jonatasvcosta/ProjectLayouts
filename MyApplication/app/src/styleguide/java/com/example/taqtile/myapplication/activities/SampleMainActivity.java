package com.example.taqtile.myapplication.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.taqtile.myapplication.adapters.SampleMainActivityAdapter;
import com.example.taqtile.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;


public class SampleMainActivity extends AppCompatActivity {

    private ArrayList mArrayList = new ArrayList();

    private RecyclerView mRecyclerView;
    private SampleMainActivityAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sample);

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_main_sample_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        setStyleGuidesOptions(mArrayList);

        mRecyclerAdapter = new SampleMainActivityAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    private void setStyleGuidesOptions(ArrayList mArrayList) {
        Resources res = getResources();
        String[] styleGuideOptions = res.getStringArray(R.array.activity_main_sample_items);
        Collections.addAll(mArrayList, styleGuideOptions);
    }


}
