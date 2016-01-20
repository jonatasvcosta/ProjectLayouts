package com.example.taqtile.myapplication.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taqtile.myapplication.R;

import java.util.ArrayList;

public class PageViewTutorialActivity extends AppCompatActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 4;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    private ScreenSlidePageFragment[] mScreen;
    private String[] mTexts;
    private int textId;
    private int mPageNumber;

    public class ScreenSlidePageFragment extends Fragment {
        private String text;
        private int id;
        public void setText(String text, int id){
            this.text = text;
            this.id = id;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(
                    R.layout.tutorial_fragment, container, false);
            TextView text = (TextView) rootView.findViewById(textId);
            text.setText(this.text);
            ImageView blueMarker = (ImageView) rootView.findViewById(id);
            blueMarker.setImageResource(R.drawable.ic_tutorial_pager_blue_marker);
            return rootView;
        }
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            mTexts = new String[]{"O GENIANTIS desenvolve o enorme potencial do seu cérebro para que você tenha uma vida vencedora.","Página 2",":)","Bazinga"};

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_page_view_tutorial);

            // Instantiate a ViewPager and a PagerAdapter.
            mPager = (ViewPager) findViewById(R.id.tutorial_view_pager);
            mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
            mPager.setAdapter(mPagerAdapter);
        }

        @Override
        public void onBackPressed() {
            if (mPager.getCurrentItem() == 0) {
                // If the user is currently looking at the first step, allow the system to handle the
                // Back button. This calls finish() on this activity and pops the back stack.
                super.onBackPressed();
            } else {
                // Otherwise, select the previous step.
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
        }

        /**
         * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
         * sequence.
         */
        private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
            public ScreenSlidePagerAdapter(FragmentManager fm) {
                super(fm);
                mScreen = new ScreenSlidePageFragment[NUM_PAGES];
                textId = R.id.tutorial_main_text;
                int markerIds[] = {R.id.ic_bolinha_tutorial_1,R.id.ic_bolinha_tutorial_2,R.id.ic_bolinha_tutorial_3,R.id.ic_bolinha_tutorial_4};
                for(int i = 0; i < NUM_PAGES; i++){
                    mScreen[i] = new ScreenSlidePageFragment();
                    mScreen[i].setText(mTexts[i],markerIds[i]);
                }
            }

            @Override
            public Fragment getItem(int position) {
//                return new ScreenSlidePageFragment();
//                return tutorialPages.get(position);
                return mScreen[position];
            }

            @Override
            public int getCount() {
                return NUM_PAGES;
            }
        }

}
