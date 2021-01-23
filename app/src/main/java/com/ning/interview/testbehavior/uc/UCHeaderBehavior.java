package com.ning.interview.testbehavior.uc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

//uc头部的滑动behavior。通过消费content传入的滑动事件，滑动自身
public class UCHeaderBehavior extends ViewOffsetBehavior{
    private final int OPEN = 1;
    private final int CLOSE = 2;
    private int state = OPEN;
    public UCHeaderBehavior() {
    }

    public UCHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    //判断是否需要消耗依赖view传入的滑动事件
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull View child,
                                       @NonNull View directTargetChild,
                                       @NonNull View target,
                                       int axes,
                                       int type) {

        return axes == ViewCompat.SCROLL_AXIS_VERTICAL //滑动是水平方向
                && canScroll(child);  //指定的view还能够滑动
//        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }


    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                  @NonNull View child,
                                  @NonNull View target,
                                  int dx,
                                  int dy,
                                  @NonNull int[] consumed,
                                  int type) {
//        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);

        if (canScroll(child)){ //目前还没有滑到顶端

        }
    }

    //判断view是否能够滑动
    private boolean canScroll(View view) {
        return view.getTranslationY() > - getScrollRange(view);
    }

    //获取可以滑动的范围
    public int getScrollRange(View view) {
        return view.getHeight();
    }

    //返回消耗的滑动距离
    public int scrollView(View child, int dy) {
        if (state == CLOSE ){ //header已经隐藏
            if (dy < 0) { //当前是向上滑动
                return 0;
            }else {   //当前是向下滑动

            }

        }
        return 0;
    }
}
