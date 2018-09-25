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
import android.widget.TextView;

import com.example.arthy.android_stg.R;

public class LogoBarView {

    public TextView setTextView(Activity context, int ResId) {

        TextView logoView = new TextView(context);
        logoView.setId(R.id.textView_id);

        Resources resources = context.getResources();
        int margin = (int) resources.getDimension(R.dimen.searchButtonMargin);


        logoView.setTextColor(context.getResources().getColor(R.color.suntigoWhite));
        SpannableString text = new SpannableString("TICKETS");
        text.setSpan(new ForegroundColorSpan(resources.getColor(R.color.suntigoRed)), 1, 2, 0);
        text.setSpan(new ForegroundColorSpan(resources.getColor(R.color.suntigoBlue)), 4, 5, 0);
        text.setSpan(new ForegroundColorSpan(resources.getColor(R.color.suntigoYellow)), 6, text.length(), 0);
        text.setSpan(new StyleSpan(Typeface.NORMAL), 0, text.length(), 0);
        logoView.setText(text, TextView.BufferType.SPANNABLE);
        logoView.setLetterSpacing(0.0f);
        logoView.setTextSize(36f);
        logoView.setScaleX(1.2f);
        logoView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) resources.getDimension(R.dimen.searchButtonHeight)
        );

        logoView.setLayoutParams(layoutParams);

        View view = context.findViewById(android.R.id.content);
        ConstraintLayout parent = view.findViewById(ResId);
        parent.addView(logoView);

        ConstraintSet textViewConstraints = new ConstraintSet();
        textViewConstraints.clone(parent);
        textViewConstraints.connect(logoView.getId(), ConstraintSet.TOP, parent.getId(), ConstraintSet.TOP);
        textViewConstraints.connect(logoView.getId(), ConstraintSet.START, parent.getId(), ConstraintSet.START, margin);
        textViewConstraints.connect(logoView.getId(), ConstraintSet.END, parent.getId(), ConstraintSet.END, margin);
        textViewConstraints.applyTo(parent);

        return logoView;
    }
}
