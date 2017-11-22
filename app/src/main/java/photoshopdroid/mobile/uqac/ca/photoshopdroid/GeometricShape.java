package photoshopdroid.mobile.uqac.ca.photoshopdroid;

import android.graphics.Canvas;

public abstract class GeometricShape {
    enum ShapeType{
        Line,
        Circle,
        Triangle,
        Rectangle
    }

    private int color;
    private int strokeWidth;
    private BoundingBox boundingBox;

    public GeometricShape(int color, int width){
        // TODO: replace those magic numbers by default values read from xml file
        color = 0;
        width = 3;
    }

    public void setColor(int newColor){
        color = newColor;
    }

    public int getColor(){
        return color;
    }

    public void setStrokeWidth(int newWidth){
        strokeWidth = newWidth;
    }

    public int getStrokeWidth(){
        return strokeWidth;
    }

    public abstract void draw(Canvas canvas);
}
