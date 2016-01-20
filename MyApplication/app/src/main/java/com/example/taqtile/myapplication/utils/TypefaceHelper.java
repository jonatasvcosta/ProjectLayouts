package com.example.taqtile.myapplication.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;

import java.util.HashMap;

import com.example.taqtile.myapplication.R;

public class TypefaceHelper {
    private static TypefaceHelper sInstance;
    private HashMap<Integer, Typeface> mAppFonts;

    private TypefaceHelper() {
        mAppFonts = new HashMap<>();
    }

    public static TypefaceHelper getInstance() {
        if (sInstance == null) {
            sInstance = new TypefaceHelper();
        }
        return sInstance;
    }

    public Typeface getFont(String fontName, Context context) {

        Typeface tf = mAppFonts.get(fontName.hashCode());
        if (tf == null) {

            tf = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName);
            mAppFonts.put(fontName.hashCode(), tf);
        }

        return tf;
    }

    public String getFontName(TypedArray array, Resources res) {
        return array.getString(R.styleable.CustomTextView_font_family) +
                array.getString(R.styleable.CustomTextView_font_weight) +
                "." + res.getString(R.string.font_file_extension);
    }

}
