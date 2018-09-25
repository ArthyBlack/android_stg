package com.example.arthy.android_stg;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import android.widget.Button;
import android.widget.TextView;
import static com.example.arthy.android_stg.viewUtils.Constants.*;
import com.example.arthy.android_stg.viewUtils.BackGroundGradient;
import com.example.arthy.android_stg.viewUtils.LogoBarView;
import com.example.arthy.android_stg.viewUtils.SearchButton;

public class MainActivity extends AppCompatActivity {

    LogoBarView logo = new LogoBarView();
    SearchButton searchButton = new SearchButton();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout mainActivity = new ConstraintLayout(this);
        mainActivity.setId(R.id.mainActivity_Layout);
        mainActivity.setBackground(new BackGroundGradient().paintDrawable(this));
        mainActivity.getBackground().setDither(true);


        setContentView(mainActivity);

        TextView logoView = logo.setTextView(this, R.id.mainActivity_Layout);
        Button seatchBtn = searchButton.setButton(this, R.id.mainActivity_Layout);


        Log.println(Log.VERBOSE, LOG, getWindowManager().getDefaultDisplay().getWidth() + " | " + getWindowManager().getDefaultDisplay().getHeight());
    }
}

