package com.example.onboardingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button mBtnBack;
    private Button mBtnNxt;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = findViewById(R.id.slide_view_pager);
        mDotLayout = findViewById(R.id.dot_layout);

        mBtnBack = findViewById(R.id.prevBtn);
        mBtnNxt = findViewById(R.id.nextBtn);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListerner);

        // OnClick Listeners

        mBtnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSlideViewPager.setCurrentItem(mCurrentPage + 1);

            }
        });

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSlideViewPager.setCurrentItem(mCurrentPage - 1);

            }
        });

    }

    public void addDotsIndicator(int position) {

        mDots = new TextView[3];

        mDotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++) {

           mDots[i] = new TextView(this);
           mDots[i].setText(Html.fromHtml("&#8226;"));
           mDots[i].setTextSize(35);
           mDots[i].setTextColor(getResources().getColor(R.color.Black));

           mDotLayout.addView(mDots[i]);

        }

        if(mDots.length > 0) {

            mDots[position].setTextColor(getResources().getColor(R.color.White));
        }

    }

    ViewPager.OnPageChangeListener viewListerner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            mCurrentPage = position;

            if(position == 0) {

                mBtnNxt.setEnabled(true);
                mBtnBack.setEnabled(false);
                mBtnBack.setVisibility(View.INVISIBLE);

                mBtnNxt.setText("Next");
                mBtnBack.setText("");

            } else if (position == mDots.length -1) {

                mBtnNxt.setEnabled(true);
                mBtnBack.setEnabled(true);
                mBtnBack.setVisibility(View.VISIBLE);

                mBtnNxt.setText("Finish");
                mBtnBack.setText("Back");

            } else {

                mBtnNxt.setEnabled(true);
                mBtnBack.setEnabled(true);
                mBtnBack.setVisibility(View.VISIBLE);

                mBtnNxt.setText("Next");
                mBtnBack.setText("Back");

            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
