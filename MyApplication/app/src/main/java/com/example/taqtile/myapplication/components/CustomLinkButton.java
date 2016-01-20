package com.example.taqtile.myapplication.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

import com.example.taqtile.myapplication.utils.TypefaceHelper;
import com.example.taqtile.myapplication.R;

public class CustomLinkButton extends Button {

    public CustomLinkButton(Context context) {
        super(context);
        setNewTypeface(null, 0);
    }

    public CustomLinkButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setNewTypeface(attrs, 0);
    }

    public CustomLinkButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setNewTypeface(attrs, defStyleAttr);
    }

    private void setNewTypeface(AttributeSet attrs, int defStyleAttr) {
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);

        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.CustomTextView, defStyleAttr, 0);

        String fontName = TypefaceHelper.getInstance().getFontName(a, getResources());

        if (fontName != null)
            setTypeface(TypefaceHelper.getInstance().getFont(fontName, getContext()));

        a.recycle();
    }

}

