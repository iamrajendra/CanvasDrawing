package com.iamrajendra.canvasdrawing.customview;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawingView extends View {
    private Path path;
    private Paint paint;

    private Bitmap bitmap;
    private Canvas can;
    private Paint bitmapPaint;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        path = new Path();

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(9);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmapPaint = new Paint(Paint.DITHER_FLAG);
        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        can = new Canvas(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        this is used to create the last draw when user up the drawing
        canvas.drawBitmap(bitmap, 0, 0, bitmapPaint);
//        this is used to draw a realtime drawing
        canvas.drawPath(path, paint);

    }

    private float mX, mY;
    private static final float TOUCH_TOLERANCE = 4;

    private void touchStart(float x, float y) {
        path.reset();
        path.moveTo(x, y);
        mX = x;
        mY = y;
    }

    private void touchMove(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            path.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
    }

    private void touchUp() {
        path.lineTo(mX, mY);
        // commit the path to our offscreen
        can.drawPath(path, paint);
        // kill this so we don't double draw
        path.reset();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchStart(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touchMove(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touchUp();
                invalidate();
                break;
        }
        return true;
    }

    public Bitmap getBitmap() {
        this.setDrawingCacheEnabled(true);
        this.buildDrawingCache();
        Bitmap bmp = Bitmap.createBitmap(this.getDrawingCache());
        this.setDrawingCacheEnabled(false);

        return bmp;
    }

    //Clear screen
    public void clear() {
        bitmap.eraseColor(Color.WHITE);
        invalidate();
        System.gc();

    }

    /**
     * change path color here
     */
    public void setColor(int color) {
        paint.setColor(color);
    }

}
