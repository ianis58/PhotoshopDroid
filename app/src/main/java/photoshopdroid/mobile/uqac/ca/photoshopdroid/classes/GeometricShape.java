package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;

public abstract class GeometricShape {
    enum ShapeType{
        Line,               //
        Circle,             // Done
        Triangle,           //
        Rectangle           //
    }

    // How to paint the shape
    protected Paint paint;
    // Helps finding which shape to select on click
    protected BoundingBox boundingBox;
    // Is the object currently selected by the user ?
    protected boolean selected;

    public GeometricShape(int color, int width){
        paint.setColor(color);
        paint.setStrokeWidth(width);
        selected = false;
    }

    public void setColor(int newColor){
        paint.setColor(newColor);
    }

    public int getColor(){
        return paint.getColor();
    }

    public void setStrokeWidth(float newWidth){
        paint.setStrokeWidth(newWidth);
    }

    public float getStrokeWidth(){
        return paint.getStrokeWidth();
    }

    public void select(){
        selected = true;
    }

    public void deslect(){
        selected = false;
    }

    public boolean isSelected(){
        return selected;
    }

    public void draw(Canvas canvas){
        if (selected){
            drawSelected(canvas);
        }
        drawShape(canvas);
    }

    protected abstract void drawShape(Canvas canvas);

    private void drawSelected(Canvas canvas){
        boundingBox.paint(canvas, paint);
        highlightInterestPoints(canvas, paint);
    }

    protected abstract void highlightInterestPoints(Canvas canvas, Paint paint);
}
