package com.ning.interview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyTouchView extends View {
    private Paint paint;
    private int startLeft = 100;
    private int startTop = 100;

    private int preX;
    private int preY;
    public MyTouchView(Context context) {
        this(context, null);
    }

    public MyTouchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                preX = (int) event.getX();
                preY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                startLeft +=((int)event.getX())-preX;
                startTop +=((int)event.getY())-preY;

                preX = (int) event.getX();
                preY = (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(startLeft, startTop, 100,paint);
    }
}
