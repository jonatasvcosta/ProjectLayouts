package com.example.taqtile.myapplication.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.taqtile.myapplication.R;

import java.util.ArrayList;

public class CustomMainActivitySampleItem extends LinearLayout {
    private Context mContext;
    private SelectionItemListener mSelectionItemListener;

    private TextView mTextView;
    private LinearLayout mLinearLayout;
    private int mPosition = -1;

    public CustomMainActivitySampleItem(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public CustomMainActivitySampleItem(Context context, View itemView) {
        super(context);
        mContext = context;
        init(itemView);
    }

    public CustomMainActivitySampleItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }


    public CustomMainActivitySampleItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.component_main_activity_sample_item, this);
        mTextView = (TextView) findViewById(R.id.component_main_activity_sample_item_title);
        mLinearLayout = (LinearLayout)
                findViewById(R.id.component_main_activity_sample_item_container);
    }

    private void init(View itemView) {
        mTextView = (TextView) itemView.findViewById(R.id.component_main_activity_sample_item_title);
        mLinearLayout = (LinearLayout)
                itemView.findViewById(R.id.component_main_activity_sample_item_container);
        handleMyEvents();
    }

    public void setContent(ArrayList<String> arrayList, int position) {
        final String selectionOptions = arrayList.get(position);
        mTextView.setText(selectionOptions);
        mPosition = position;
    }

    public void handleMyEvents() {
        mLinearLayout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mSelectionItemListener != null)
                            mSelectionItemListener.onItemClick(mLinearLayout, mPosition);
                    }
                });
    }

    public void setListener(SelectionItemListener listener) {
        this.mSelectionItemListener = listener;
    }

    public interface SelectionItemListener {
        void onItemClick(View itemView, int position);
    }

}
