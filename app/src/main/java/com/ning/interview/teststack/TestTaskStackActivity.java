package com.ning.interview.teststack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ning.interview.R;

//测试android任务栈相关信息
public class TestTaskStackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_task_stack);

        initViews();
    }

    private void initViews() {
        findViewById(R.id.start_second).setOnClickListener(v-> {
            startActivity(new Intent(this, SecondActivity.class));
        });
    }
}