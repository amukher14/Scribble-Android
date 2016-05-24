package edu.pitt.cs.cs1635.arm136.sribble;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Arjun on 2/11/2016.
 */
public class ScribbleView extends View {
    private Path MyPath;
    private Paint MyPaint, canvasPaint;
    private int PaintColor= 0xFF000000;
    private Canvas MyCanvas;
    private Bitmap canvasBitmap;
    private Button EraseScreen;


    public ScribbleView(Context context, AttributeSet attrs){
        super(context, attrs);
        setUpPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        MyCanvas = new Canvas(canvasBitmap);
        //setting up the bitmap over the view
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(MyPath, MyPaint);
    }

    public void setColor(String c) {
        invalidate();

        PaintColor = Color.parseColor(c);
        MyPaint.setColor(PaintColor);
    }

    public void EraseScreen(){
        MyCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {//This method listens for touch
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MyPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                MyPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                MyCanvas.drawPath(MyPath, MyPaint);
                MyPath.reset();
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    private void setUpPaint(){
        MyPath = new Path();
        MyPaint = new Paint();

        MyPaint.setColor(PaintColor);
        MyPaint.setAntiAlias(true);
        MyPaint.setStrokeWidth(5);
        MyPaint.setStyle(Paint.Style.STROKE);
        MyPaint.setStrokeJoin(Paint.Join.ROUND);
        MyPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

}
