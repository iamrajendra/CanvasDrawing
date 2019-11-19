package com.iamrajendra.canvasdrawing.customview.unused;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/*
 * paint class hold the bitmap,text and paths
 *
 * canvas can draw any thing, like
 * circle,rectangle, oval etc, canvas follow the co-ordinate system
 * */
public class DrawingView extends View {
    public DrawingView(Context context) {
        super(context);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        // custom drawing code here
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        // make the entire canvas white
        paint.setColor(Color.BLACK);
        canvas.drawPaint(paint);

        // draw blue circle with anti aliasing turned off
        paint.setAntiAlias(false);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(20, 20, 15, paint);

        // draw green circle with anti aliasing turned on
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(60, 20, 15, paint);

        // draw red rectangle with anti aliasing turned off
        paint.setAntiAlias(false);
        paint.setColor(Color.RED);
        canvas.drawRect(100, 5, 200, 30, paint);

        // draw the rotated text
        canvas.rotate(-45);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Graphics Rotation", 40, 180, paint);

        //undo the rotate
//        canvas.restore();
    }
}
