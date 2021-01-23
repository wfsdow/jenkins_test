package com.ning.interview.testsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ning.interview.R;

public class TestSqlActivity extends AppCompatActivity {
    private static final String TAG = "ningwei";
    volatile boolean flag = true;
    volatile int writeCount = 0;
    volatile int deleteCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testsql);

        initViews();
    }

    private void initViews() {

        SQLUtils.context = this;
        findViewById(R.id.insert).setOnClickListener(v-> {
            new Thread(()->{
                while(flag) {
                    SQLUtils.insert("item " + (writeCount++));
                    Log.i(TAG, "insert " + writeCount);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });

        findViewById(R.id.delete).setOnClickListener(v-> {
            while(flag) {
                SQLUtils.delete();
                Log.i(TAG, "delete " + (++deleteCount));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        findViewById(R.id.stop).setOnClickListener(v-> {
            flag = false;
            Log.i(TAG, "stop sqlite");
        });
    }
}