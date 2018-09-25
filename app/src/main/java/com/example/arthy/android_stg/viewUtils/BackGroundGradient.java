package com.example.arthy.android_stg.viewUtils;

import android.app.Activity;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

import com.example.arthy.android_stg.R;

public class BackGroundGradient {


    public GradientDrawable setGradientBG(Activity activity){
        GradientDrawable gradientBG = new GradientDrawable();
        gradientBG.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientBG.setColors(new int[]{activity.getResources().getColor(R.color.suntigoDark), activity.getResources().getColor(R.color.suntigoBlue)});

        return gradientBG;

    }


    public PaintDrawable paintDrawable(final Activity activity){
        ShapeDrawable.ShaderFactory factory = new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                LinearGradient linearGradient = new LinearGradient(0,0|-10, 0, 0|height*1+700,
                        new int[]{activity.getResources().getColor(R.color.suntigoDark), activity.getResources().getColor(R.color.suntigoBlue)},
                        new float[]{0.2f, 1f},
                        Shader.TileMode.REPEAT
                );
                return linearGradient;
            }
        };

        PaintDrawable paint = new PaintDrawable();
        paint.setShape(new RectShape());
        paint.setShaderFactory(factory);
        paint.setDither(true);
        return paint;
    }

}
