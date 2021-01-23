package com.ning.interview.testview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ning.interview.R;
import com.ning.interview.view.MyExpandListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_listview);

        initViews();
    }

    private void initViews() {
//        ListView listView = findViewById(R.id.container);
        MyExpandListView listView = findViewById(R.id.container);

        int max = 20;
        List<String> list = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            list.add("item " + (i + 1));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
               this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        WindowManager wm = getWindowManager();
        wm.addView(null, null);

//        CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<>();
//        list2.get(0);
    }

    private void testAnimation(View target) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "alpha", 1, 0);
        animator.start();
    }
}