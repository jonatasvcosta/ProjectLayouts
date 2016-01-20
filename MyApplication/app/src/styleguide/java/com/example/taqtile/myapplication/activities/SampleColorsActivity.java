package com.example.taqtile.myapplication.activities;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.taqtile.myapplication.components.CustomTextView;
import com.example.taqtile.myapplication.R;

public class SampleColorsActivity extends AppCompatActivity {

    private Resources mResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_sample);
        setupTextViews();
    }

    private void setupTextViews() {
        setupPaletteColorsTextViews();
        setupGrayScaleColorsTextViews();
        setupBlackAndWhiteColorsTextViews();
    }

    private void setupBlackAndWhiteColorsTextViews() {
        setTextViewText(R.id.activity_colors_black,
                R.string.activity_colors_black, R.color.color_black);
        setTextViewText(R.id.activity_colors_white,
                R.string.activity_colors_white, R.color.color_white);
    }

    private void setupGrayScaleColorsTextViews() {
        setTextViewText(R.id.activity_colors_lightest_gray,
                R.string.activity_colors_lightest_gray, R.color.color_gray_lightest);
        setTextViewText(R.id.activity_colors_lighter_gray,
                R.string.activity_colors_lighter_gray, R.color.color_gray_lighter);
        setTextViewText(R.id.activity_colors_gray,
                R.string.activity_colors_gray, R.color.color_gray);
        setTextViewText(R.id.activity_colors_darker_gray,
                R.string.activity_colors_darker_gray, R.color.color_gray_darker);
        setTextViewText(R.id.activity_colors_darkest_gray,
                R.string.activity_colors_darkest_gray, R.color.color_gray_darkest);
    }

    private void setupPaletteColorsTextViews() {
        setTextViewText(R.id.activity_colors_primary_color,
                R.string.activity_colors_primary, R.color.color_primary);
        setTextViewText(R.id.activity_colors_secondary_color,
                R.string.activity_colors_secondary, R.color.color_secondary);
        setTextViewText(R.id.activity_colors_accessory_color,
                R.string.activity_colors_accessory, R.color.color_accessory);
        setTextViewText(R.id.activity_colors_alert_color,
                R.string.activity_colors_alert, R.color.color_alert);
        setTextViewText(R.id.activity_colors_call_to_action_color,
                R.string.activity_colors_call_to_action, R.color.color_call_to_action);
        setTextViewText(R.id.activity_colors_neutral_color,
                R.string.activity_colors_neutral, R.color.color_neutral);
        setTextViewText(R.id.activity_colors_success_color,
                R.string.activity_colors_success, R.color.color_success);
    }

    @SuppressLint("SetTextI18n")
    private void setTextViewText(int textViewId, int stringResId, int colorResId) {
        if (mResources == null)
            mResources = getResources();

        ((CustomTextView) findViewById(textViewId)).setText(
                mResources.getString(stringResId) + " - " +
                        Integer.toHexString(ContextCompat.getColor(this, colorResId))
                                .toUpperCase());
    }

}