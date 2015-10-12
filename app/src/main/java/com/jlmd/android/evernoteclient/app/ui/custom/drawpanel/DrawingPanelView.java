package com.jlmd.android.evernoteclient.app.ui.custom.drawpanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Drawing view based in http://stackoverflow.com/a/16650524/3929577
 *
 * @author jlmd
 */
public class DrawingPanelView extends View {

  private Bitmap mBitmap;
  private Canvas mCanvas;
  private Path mPath;
  private Paint mBitmapPaint;
  private Paint mPaint;
  private float mX, mY;

  public DrawingPanelView(Context context) {
    super(context);
    init();
  }

  public DrawingPanelView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() {
    mPath = new Path();
    mBitmapPaint = new Paint(Paint.DITHER_FLAG);

    mPaint = new Paint();
    mPaint.setAntiAlias(true);
    mPaint.setDither(true);
    mPaint.setColor(Color.BLACK);
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeJoin(Paint.Join.ROUND);
    mPaint.setStrokeCap(Paint.Cap.ROUND);
    mPaint.setStrokeWidth(12);
  }

  public Bitmap getBitmap() {
    return this.mBitmap;
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);

    mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    mCanvas = new Canvas(mBitmap);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
    canvas.drawPath(mPath, mPaint);
  }

  private void touchStart(float x, float y) {
    mPath.reset();
    mPath.moveTo(x, y);
    mX = x;
    mY = y;
  }

  private void touchMove(float x, float y) {
    mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
    mX = x;
    mY = y;
  }

  private void touchUp() {
    mPath.lineTo(mX, mY);
    // Commit the path to our offscreen
    mCanvas.drawPath(mPath, mPaint);
    // Kill this so we don't double draw
    mPath.reset();
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
      default:
        break;
    }
    return true;
  }
}
