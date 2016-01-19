package com.example.taqtile.myapplication.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.Button;

import com.example.taqtile.myapplication.utils.TypefaceHelper;
import com.example.taqtile.myapplication.R;

import java.util.ArrayList;

public class CustomButton extends Button {

    private Resources mResources;

    public CustomButton(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private int getColorInt(String intColor) {
        return Color.parseColor("#" + intColor);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        mResources = getResources();
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        setNewTypeface(attrs, defStyleAttr);
        setMixinTextColor();
    }

    private void setMixinTextColor() {

        int defaultColor = getCurrentTextColor();
        int maskColorDisabled = ContextCompat.getColor(getContext(),
                R.color.color_mask_disabled);
        int maskColorHighlighted = ContextCompat.getColor(getContext(),
                R.color.color_mask_highlighted);

        ColorStrings colorStrings = new ColorStrings(defaultColor, maskColorDisabled,
                maskColorHighlighted);

        setColorStateList(calculateColor(colorStrings));

    }

    private ArrayList<String> calculateColor(ColorStrings colorStrings) {

        ArrayList<String> finalColors = new ArrayList<>();

        float valueOfDefaultAlpha = floatAlpha(colorStrings.getmDefaultColorParsed().get(0));
        float valueOfDisabledAlpha = floatAlpha(colorStrings.getmMaskColorDisabledParsed().get(0));
        float valueOfHighlightedAlpha = floatAlpha(colorStrings.getmMaskColorHighlightedParsed().get(0));

        String defaultColor = Integer.toHexString(colorStrings.getmDefaultColor());

        String disabledColor =
                getResultingAlpha(valueOfDisabledAlpha, valueOfDefaultAlpha) +

                        getHexParsedRGB(valueOfDisabledAlpha,
                                valueOfDefaultAlpha,
                                colorStrings.getmMaskColorDisabledParsed().get(1),
                                colorStrings.getmDefaultColorParsed().get(1)) +
                        getHexParsedRGB(valueOfDisabledAlpha,
                                valueOfDefaultAlpha,
                                colorStrings.getmMaskColorDisabledParsed().get(2),
                                colorStrings.getmDefaultColorParsed().get(2)) +
                        getHexParsedRGB(valueOfDisabledAlpha,
                                valueOfDefaultAlpha,
                                colorStrings.getmMaskColorDisabledParsed().get(3),
                                colorStrings.getmDefaultColorParsed().get(3));

        String highlightedColor =
                getResultingAlpha(valueOfHighlightedAlpha, valueOfDefaultAlpha) +

                        getHexParsedRGB(valueOfHighlightedAlpha,
                                valueOfDefaultAlpha,
                                colorStrings.getmMaskColorHighlightedParsed().get(1),
                                colorStrings.getmDefaultColorParsed().get(1)) +
                        getHexParsedRGB(valueOfHighlightedAlpha,
                                valueOfDefaultAlpha,
                                colorStrings.getmMaskColorHighlightedParsed().get(2),
                                colorStrings.getmDefaultColorParsed().get(2)) +
                        getHexParsedRGB(valueOfHighlightedAlpha,
                                valueOfDefaultAlpha,
                                colorStrings.getmMaskColorHighlightedParsed().get(3),
                                colorStrings.getmDefaultColorParsed().get(3));

        finalColors.add(0, defaultColor);
        finalColors.add(1, disabledColor);
        finalColors.add(2, highlightedColor);

        return finalColors;
    }

    private String getResultingAlpha(float alphaA, float alphaB) {
        return Integer.toHexString((int) (255 * (alphaA + alphaB * (1 - alphaA))));
    }

    private String getHexParsedRGB(float alphaA, float alphaB, String valueA, String valueB) {
        String parsedRGB = Integer.toHexString((int) (alphaA *
                Integer.parseInt(valueA, 16)
                + Integer.parseInt(valueB, 16) *
                alphaB * (1 - alphaA)));

        return (parsedRGB.equals("0")) ? "00" : parsedRGB;
    }

    private String getAlpha(int Color) {
        return Integer.toHexString(Color).substring(0, 2);
    }

    private String getRedColor(int Color) {
        return Integer.toHexString(Color).substring(2, 4);
    }

    private String getGreenColor(int Color) {
        return Integer.toHexString(Color).substring(4, 6);
    }

    private String getBlueColor(int Color) {
        return Integer.toHexString(Color).substring(6, 8);
    }

    private float floatAlpha(String alpha) {
        return ((float) Integer.parseInt(alpha, 16) / 255);
    }

    private void setColorStateList(ArrayList<String> finalColors) {
        ColorStateList states = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_enabled},
                        new int[]{android.R.attr.state_pressed},
                        new int[]{}
                },
                new int[]{
                        getColorInt(finalColors.get(1)),
                        getColorInt(finalColors.get(2)),
                        getColorInt(finalColors.get(0)),
                }
        );

        setTextColor(states);
    }

    private void setNewTypeface(AttributeSet attrs, int defStyleAttr) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.CustomTextView, defStyleAttr, 0);

        String fontName = TypefaceHelper.getInstance().getFontName(a, getResources());

        if (fontName != null)
            setTypeface(TypefaceHelper.getInstance().getFont(fontName, getContext()));

        a.recycle();
    }

    private class ColorStrings {

        private int mDefaultColor;
        private ArrayList<String> mDefaultColorParsed = new ArrayList<>();
        private ArrayList<String> mMaskColorDisabledParsed = new ArrayList<>();
        private ArrayList<String> mMaskColorHighlightedParsed = new ArrayList<>();

        public ColorStrings(int defaultColor, int maskColorDisabled, int maskColorHighlighted) {

            mDefaultColor = defaultColor;

            mDefaultColorParsed.add(0, getAlpha(defaultColor));
            mDefaultColorParsed.add(1, getRedColor(defaultColor));
            mDefaultColorParsed.add(2, getGreenColor(defaultColor));
            mDefaultColorParsed.add(3, getBlueColor(defaultColor));

            mMaskColorDisabledParsed.add(0, getAlpha(maskColorDisabled));
            mMaskColorDisabledParsed.add(1, getRedColor(maskColorDisabled));
            mMaskColorDisabledParsed.add(2, getGreenColor(maskColorDisabled));
            mMaskColorDisabledParsed.add(3, getBlueColor(maskColorDisabled));

            mMaskColorHighlightedParsed.add(0, getAlpha(maskColorHighlighted));
            mMaskColorHighlightedParsed.add(1, getRedColor(maskColorHighlighted));
            mMaskColorHighlightedParsed.add(2, getGreenColor(maskColorHighlighted));
            mMaskColorHighlightedParsed.add(3, getBlueColor(maskColorHighlighted));
        }


        public int getmDefaultColor() {
            return mDefaultColor;
        }

        public ArrayList<String> getmDefaultColorParsed() {
            return mDefaultColorParsed;
        }

        public ArrayList<String> getmMaskColorDisabledParsed() {
            return mMaskColorDisabledParsed;
        }

        public ArrayList<String> getmMaskColorHighlightedParsed() {
            return mMaskColorHighlightedParsed;
        }


    }

}
