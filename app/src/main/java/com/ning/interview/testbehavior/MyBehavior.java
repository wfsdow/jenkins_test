package com.ning.interview.testbehavior;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

public class MyBehavior extends CoordinatorLayout.Behavior<Button> {
    private static final String TAG = "ningwei";
    public MyBehavior() {
    }

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull Button child, @NonNull View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull Button child, @NonNull View dependency) {
        if (dependency instanceof Snackbar.SnackbarLayout) {
            float y = ViewCompat.getTranslationY(dependency);
            Log.i(TAG, "onDependentViewChanged: " + y);
            if (y <= 5) {
                child.setBackgroundColor(Color.GREEN);
            } else {
                child.setBackgroundColor(Color.RED);
            }
        }
        return false;
    }
}
