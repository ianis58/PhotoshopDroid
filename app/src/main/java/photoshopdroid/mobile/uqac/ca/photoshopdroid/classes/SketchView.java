package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.paths.BrushPath;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.paths.AbstractPath;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.paths.RectanglePath;

public class SketchView extends View {

    public enum SketchMode {BRUSH, RECTANGLE, TRIANGLE};

    private static final float TOUCH_TOLERANCE = 4;
    private float mX, mY;
    private Path mPath;
    private Paint mPaint;
    private ArrayList<AbstractPath> paths = new ArrayList<>();
    private int color;
    private int thickness;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Paint mBitmapPaint = new Paint(Paint.DITHER_FLAG);
    private SketchMode drawingMode;
    private RectanglePath rectangle;

    public SketchView(Context context) {
        this(context, null);
    }

    public SketchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setXfermode(null);
        mPaint.setAlpha(0xff);
    }

    public void init(DisplayMetrics metrics) {
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

        color = Color.BLACK;
        thickness = 15;
        drawingMode = SketchMode.BRUSH;
    }

    public void clear() {
        paths.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        mCanvas.drawColor(Color.WHITE);

        for (AbstractPath fp : paths) {
            mPaint.setColor(fp.color);
            mPaint.setStrokeWidth(fp.strokeWidth);

            switch (fp.drawingMode){
                case BRUSH:{
                    BrushPath bp = (BrushPath) fp;
                    mCanvas.drawPath(bp.getPath(), mPaint);
                } break;

                case RECTANGLE:{
                    RectanglePath rp = (RectanglePath) fp;
                    mCanvas.drawRect(rp.getLeft(), rp.getTop(), rp.getRight(), rp.getBottom(), mPaint);
                } break;

                case TRIANGLE:{

                } break;
            }
        }

        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                touchStarted(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE :
                touchMoved(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP :
                touchEnded();
                invalidate();
                break;
        }

        return true;
    }

    private void touchStarted(float x, float y) {

        switch (drawingMode){
            case BRUSH: {
                mPath = new Path();
                BrushPath bp = new BrushPath(color, thickness, drawingMode, mPath);
                paths.add(bp);

                mPath.reset();
                mPath.moveTo(x, y);
                mX = x;
                mY = y;
            } break;

            case RECTANGLE: {
                Point origin = new Point((int)x, (int)y);
                rectangle = new RectanglePath(color, thickness, drawingMode);
                rectangle.addPoint(origin);

                mX = x;
                mY = y;
            } break;

            case TRIANGLE: {

            } break;
        }

    }

    private void touchMoved(float x, float y) {

        switch (drawingMode) {
            case BRUSH: {
                float dx = Math.abs(x - mX);
                float dy = Math.abs(y - mY);

                if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                    mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
                    mX = x;
                    mY = y;

                }
            }
            break;

            case RECTANGLE: {
                Point destination = new Point((int)x, (int)y);
                rectangle.addPoint(destination);
            }
            break;

            case TRIANGLE: {

            }
            break;
        }
    }

    private void touchEnded() {

        switch (drawingMode){
            case BRUSH: {
                mPath.lineTo(mX, mY);
            } break;

            case RECTANGLE: {
                if(rectangle.isComplete()){
                    paths.add(rectangle);
                }
            } break;

            case TRIANGLE: {

            } break;
        }

        AbstractPath.count++;
    }

    public ArrayList<AbstractPath> getPaths() {
        return paths;
    }

    public void setColor(int color){
        this.color = color;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setDrawingMode(SketchMode drawingMode) {
        this.drawingMode = drawingMode;
    }
}
