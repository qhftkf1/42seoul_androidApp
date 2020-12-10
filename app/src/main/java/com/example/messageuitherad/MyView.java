package com.example.messageuitherad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    private  String mColor = "FF0000FF";

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.YELLOW);

        for(int i = 0; i < attrs.getAttributeCount();i++){
            if(attrs.getAttributeName(i).equals("color")){
                String c = attrs.getAttributeValue(i);
                if(c != null)
                    mColor = c.replace("#", "FF");
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = 0;
        switch (heightMode){
            case MeasureSpec.UNSPECIFIED:
                heightSize = heightMeasureSpec;
                break;
            case MeasureSpec.AT_MOST:
                heightSize = 800;
                break;
            case MeasureSpec.EXACTLY:
                heightSize = MeasureSpec.getSize(heightMeasureSpec);
                break;
        }

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = 0;
        switch (widthMode){
            case MeasureSpec.UNSPECIFIED:
                widthSize = widthMeasureSpec;
                break;
            case MeasureSpec.AT_MOST:
                widthSize = 320;
                break;
            case MeasureSpec.EXACTLY:
                widthSize = MeasureSpec.getSize(widthMeasureSpec);
                break;
        }
        setMeasuredDimension(widthSize, heightSize);
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint pnt = new Paint();
        //Paint pnt2 = new Paint();
        //pnt.setColor(Color.BLUE);
        pnt.setColor((int)Long.parseLong(mColor, 16));
        //pnt2.setColor((int)Long.parseLong(mColor, 16));
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(100, 100, 80, pnt);
        canvas.drawCircle(300, 100, 80, pnt);
        pnt.setTextSize(100);
        canvas.drawText("Hello", 400, 100, pnt);
    }
}
