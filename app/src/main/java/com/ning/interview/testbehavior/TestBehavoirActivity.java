package com.ning.interview.testbehavior;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.ning.interview.R;

public class TestBehavoirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_behavoir);

        initViews();
    }

    private void initViews() {
        findViewById(R.id.test_behavior).setOnClickListener(v -> {
            Snackbar.make(v, "Hello world", Snackbar.LENGTH_LONG)
                    .setAction("cancel", v1 -> {

                    })
                    .show();
        });
    }
}