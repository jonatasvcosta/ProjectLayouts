package com.example.taqtile.myapplication.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.taqtile.myapplication.utils.TypefaceHelper;
import com.example.taqtile.myapplication.R;

public class CustomTextView extends TextView {
    private String mFontName;

    public CustomTextView(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);

        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.CustomTextView, defStyle, 0);

        mFontName = TypefaceHelper.getInstance().getFontName(a, getResources());

        if (mFontName != null)
            setTypeface(TypefaceHelper.getInstance().getFont(mFontName, getContext()));

        a.recycle();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        getRootView().setAlpha(enabled ? 1 : 0.5f);
    }

}
