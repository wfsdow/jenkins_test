package com.ning.interview.testanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import com.ning.interview.R;

public class TestAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_animation);

        initViews();
    }

    private void initViews() {
        View view = findViewById(R.id.content);

        findViewById(R.id.show).setOnClickListener(v-> {
            startAnimation(view, 0f, 1f);
        });

        findViewById(R.id.hide).setOnClickListener(v-> {
            startAnimation(view, 1f, 0f);
        });
    }

    private void startAnimation(View target, float start, float end){
        ObjectAnimator
                .ofFloat(target, "alpha", start, end)
                .setDuration(500)
                .start();
    }
}