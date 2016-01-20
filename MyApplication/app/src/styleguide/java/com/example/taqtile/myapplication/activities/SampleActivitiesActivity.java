package com.example.taqtile.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;

import com.example.taqtile.myapplication.R;
import com.example.taqtile.myapplication.components.CustomButton;

public class SampleActivitiesActivity extends AppCompatActivity {

    ArrayList<Class> mClasses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_sample);

        setupActivitiesArray();
        addButtons();
    }

    private void setupActivitiesArray() {
        Collections.addAll(mClasses,
                SampleColorsActivity.class
        );
        Collections.addAll(mClasses, EnergiaLivreActivity.class);
        Collections.addAll(mClasses, MenuEnergiaLivreActivity.class);
        Collections.addAll(mClasses, LoginActivity.class);
        Collections.addAll(mClasses, CriarContaActivity.class);
        Collections.addAll(mClasses, TutorialActivity.class);
        Collections.addAll(mClasses, DefaultDrawerTestActivity.class);
        Collections.addAll(mClasses, CustomDrawerActivity.class);
        Collections.addAll(mClasses, PageViewTutorialActivity.class);
    }

    private void addButtons() {
        LinearLayout buttonsContainer = (LinearLayout)
                findViewById(R.id.activity_activities_buttons_container_linear_layout);
        CustomButton button;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, 16);

        for (Class item : mClasses) {
            button = (CustomButton) getLayoutInflater().inflate(R.layout.layout_primary_button,
                    null);
            button.setText(item.getSimpleName());
            button.setOnClickListener(getClickListener(item));
            button.setLayoutParams(layoutParams);
            buttonsContainer.addView(button);
        }
    }

    private View.OnClickListener getClickListener(final Class<?> activityClass) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), activityClass));
            }
        };
    }
}
