package com.ning.interview.testbehavior;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ning.interview.R;

public class TestClientActivity extends AppCompatActivity {
    private static final String TAG = "ningwei";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_client);

        initViews();
    }

    private void initViews() {
        View btn1 = findViewById(R.id.btn1);
        View btn2 = findViewById(R.id.btn2);
        
//        btn1.post(()-> {
//            Log.i(TAG, "btn1: " + btn1.getLeft());
//        });
//
//        btn2.post(()-> {
//            Log.i(TAG, "btn1: " + btn2.getLeft());
//        });

        btn2.setTranslationY(350.0f);

        btn2.setOnClickListener(v -> {
            Log.i(TAG, "click btn2");
        });
        findViewById(R.id.show_info).setOnClickListener(v-> {
            Log.i(TAG, "btn1.left: " + btn1.getLeft());
            Log.i(TAG, "btn1.translationX: " + btn1.getTranslationX());
            Log.i(TAG, "btn1.x: " + btn1.getX());

            Log.i(TAG, "btn2.left: " + btn2.getLeft());
            Log.i(TAG, "btn2.translationX: " + btn2.getTranslationX());
            Log.i(TAG, "btn3.x: " + btn2.getX());
        });
    }
}