package com.ning.interview.testbehavior.uc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ning.interview.R;

//仿uc主界面
public class UCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc);
        
        initViews();
    }

    private void initViews() {
    }
}