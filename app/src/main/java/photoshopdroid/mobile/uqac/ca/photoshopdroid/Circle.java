package photoshopdroid.mobile.uqac.ca.photoshopdroid;

import android.graphics.Canvas;
import android.graphics.Paint;

import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.BoundingBox;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.GeometricShape;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.Point2D;

public class Circle extends GeometricShape {
    private Point2D center;
    private float radius;

    public Circle(int color, int width){
        super(color, width);
    }

    public void moveTo(Point2D destination){
        center = destination;
        boundingBox = new BoundingBox(new Point2D(center.getPosX()-radius,center.getPosY()-radius ),
                new Point2D(center.getPosX() + radius, center.getPosY() + radius));
    }

    public void resize(float radius){
        this.radius = radius;
    }

    public void drawShape(Canvas canvas){
        canvas.drawCircle(center.getPosX(), center.getPosY(), radius, paint);
    }

    public void highlightInterestPoints(Canvas canvas, Paint paint){
        // Circles do not have interest points
    }
}
