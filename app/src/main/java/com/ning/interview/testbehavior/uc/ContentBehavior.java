package com.ning.interview.testbehavior.uc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ning.interview.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class ContentBehavior extends HeaderScrollingViewBehavior{
    private float lastX, lastY;

    public ContentBehavior() {
    }

    public ContentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected View findFirstDependency(List<View> views) {
        if (views == null) return null;
        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            if(view.getId() == R.id.header_ll){
                return view;
            }
        }
        return null;
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            lastX = ev.getX();
            lastY = ev.getY();
        }

        if (ev.getActionMasked() == MotionEvent.ACTION_MOVE) {
            float currX = ev.getX();
            float currY = ev.getY();
            boolean horizontalScroll = Math.abs(currX - lastX) / Math.abs(currY - lastY) > 1;
            if (horizontalScroll && child.getTranslationY() == 0)
                return true;
        }

        return super.onInterceptTouchEvent(parent, child, ev);
    }


    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency != null && dependency.getId() == R.id.header_ll;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        child.setTranslationY(dependency.getTranslationY());
        return true;
    }
}
