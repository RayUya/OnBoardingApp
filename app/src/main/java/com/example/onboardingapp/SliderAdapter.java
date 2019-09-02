package com.example.onboardingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {

        this.context = context;

    }

    // Arrays
    public int [] slide_images = {

            R.drawable.fail,
            R.drawable.pending,
            R.drawable.pass
    };

    public  String [] slide_headings = {

            "FAIL",
            "PENDING",
            "PASS"
    };

    public  String [] slide_desc = {

            "Anytime you fail any course, this icon decides your fate and CGPA in all your other courses",
            "Unavailable results and grades will have this icon besides it at all times a course shows NA",
            "You are good to go with a good CGPA and it's obvious you'll graduate with good grades surely"

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject (@NonNull View view, @NonNull Object o) {
        return view == (    RelativeLayout) o;
    }

    @SuppressLint("ServiceCast")
    @Override
    public Object instantiateItem (ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView =  view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDesc = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);

        return view;

    }

    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);

    }
}
