package com.example.arthy.android_stg.viewUtils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.arthy.android_stg.R;

public class SearchButton {

    public Button setButton(Activity context, int ResId){

        Button searchBtn = new Button(context);
        searchBtn.setId(R.id.searchBtn_id);

        Resources resources = context.getResources();
        int margin = (int) resources.getDimension(R.dimen.searchButtonWidth);

        SpannableString text = new SpannableString("SEARCH");
        text.setSpan(new StyleSpan(Typeface.NORMAL), 0, text.length(), 0);
        text.setSpan(new ForegroundColorSpan(resources.getColor(R.color.suntigoWhite)), 0, text.length(), 0);
        searchBtn.setText(text, TextView.BufferType.SPANNABLE);
        searchBtn.setTextSize(36.0F);
        searchBtn.setLetterSpacing(0.1f);

        searchBtn.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        searchBtn.setLayoutParams(layoutParams);

        View view = context.findViewById(android.R.id.content);
        ConstraintLayout parent = view.findViewById(ResId);
        parent.addView(searchBtn);

        ConstraintSet searchBtnConstraintSet = new ConstraintSet();
        searchBtnConstraintSet.clone(parent);
        searchBtnConstraintSet.connect(searchBtn.getId(), ConstraintSet.START, parent.getId(), ConstraintSet.START, margin);
        searchBtnConstraintSet.connect(searchBtn.getId(), ConstraintSet.END, parent.getId(), ConstraintSet.END, margin);
        searchBtnConstraintSet.connect(searchBtn.getId(), ConstraintSet.BOTTOM, parent.getId(), ConstraintSet.BOTTOM, margin);
        searchBtnConstraintSet.applyTo(parent);

     return searchBtn;
    }
}
