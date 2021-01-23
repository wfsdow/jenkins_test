package com.ning.interview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ning.interview.view.MyTextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ningwei";
    MyTextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tv = findViewById(R.id.myTextView);
        Button start = findViewById(R.id.start);

        start.setOnClickListener(v -> {
            testInvalidate();
        });
        
        start.post(() -> {
            Log.i(TAG, "initView: ");
        });

        new Handler().sendEmptyMessage(10);
    }

    //view调用10次invalidate，会执行几次重绘
    private void testInvalidate() {
        Log.i(TAG, "开始test Invalidate-----------------------------------------------");
        for (int i = 0; i < 10; i++) {
//            tv.invalidate();
            tv.requestLayout();
        }
    }

    private  void testNestedScroll(){
        NestedScrollView testView = null;
        HashMap<Integer, Integer> test =  null;
        test.put(null, null);

        Looper.prepare();
    }
}