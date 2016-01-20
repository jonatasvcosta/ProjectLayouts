package com.example.taqtile.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taqtile.myapplication.activities.SampleActivitiesActivity;
import com.example.taqtile.myapplication.activities.SampleColorsActivity;
import com.example.taqtile.myapplication.activities.SampleControlsActivity;
import com.example.taqtile.myapplication.activities.SampleTypographyActivity;
import com.example.taqtile.myapplication.R;
import com.example.taqtile.myapplication.components.CustomMainActivitySampleItem;

import java.util.ArrayList;

public class SampleMainActivityAdapter extends RecyclerView.Adapter<SampleMainActivityAdapter.ViewHolder>
        implements CustomMainActivitySampleItem.SelectionItemListener {

    private ArrayList mArrayList;
    private Context mContext;

    public SampleMainActivityAdapter(Context context, ArrayList<String> items) {
        mArrayList = items;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component_main_activity_sample_item, parent, false);
        ViewHolder vH = new ViewHolder(v);
        return vH;
    }

    @Override
    public void onBindViewHolder(SampleMainActivityAdapter.ViewHolder holder, int position) {
        holder.mCustomMainActivitySampleItem.setContent(mArrayList, position);
    }

    @Override
    public int getItemCount() {
        return (mArrayList != null ? mArrayList.size() : 0);
    }

    @Override
    public void onItemClick(View itemView, final int position) {
        switch (position) {
            case 0:
                mContext.startActivity(new Intent(mContext, SampleColorsActivity.class));
                break;
            case 1:
                mContext.startActivity(new Intent(mContext, SampleTypographyActivity.class));
                break;
            case 2:
                mContext.startActivity(new Intent(mContext, SampleControlsActivity.class));
                break;
            case 3:
                mContext.startActivity(new Intent(mContext, SampleActivitiesActivity.class));
                break;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CustomMainActivitySampleItem mCustomMainActivitySampleItem;

        public ViewHolder(View itemView) {
            super(itemView);
            mCustomMainActivitySampleItem = new CustomMainActivitySampleItem(mContext, itemView);
            mCustomMainActivitySampleItem.setListener(SampleMainActivityAdapter.this);
        }
    }
}

