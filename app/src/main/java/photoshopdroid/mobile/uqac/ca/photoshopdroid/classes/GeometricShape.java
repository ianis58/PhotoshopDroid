package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class GeometricShape {
    enum ShapeType{
        Line,
        Circle,
        Triangle,
        Rectangle
    }

    // How to paint the shape
    protected Paint paint;
    // Helps finding which shape to select on click
    protected BoundingBox boundingBox;

    public GeometricShape(int color, int width){
        paint.setColor(color);
        paint.setStrokeWidth(width);
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

    public abstract void draw(Canvas canvas);
}
