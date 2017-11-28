package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;

public class BoundingBox {
    private Point2D superiorLeftCorner;
    private Point2D inferiorRightCorner;

    public BoundingBox(Point2D corner1, Point2D corner2){
        float x1 = corner1.getPosX();
        float y1 = corner1.getPosY();
        float x2 = corner2.getPosX();
        float y2 = corner2.getPosY();

        superiorLeftCorner = new Point2D(0,0);
        inferiorRightCorner = new Point2D(0,0);

        superiorLeftCorner.setPosX(x1 < x2 ? x1 : x2);
        superiorLeftCorner.setPosY(y1 > y2 ? y1 : y2);
        inferiorRightCorner.setPosX(x1 > x2? x1 : x2);
        inferiorRightCorner.setPosY(y1 < y2 ? y1 : y2);
    }

    public Point2D getSuperiorLeftCorner() {
        return superiorLeftCorner;
    }

    public Point2D getInferiorRightCorner() {
        return inferiorRightCorner;
    }

    public void paint(Canvas canvas, Paint paint){
        paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0));
        canvas.drawLine(superiorLeftCorner.getPosX(), superiorLeftCorner.getPosY(),
                superiorLeftCorner.getPosX(), inferiorRightCorner.getPosY(), paint);
        canvas.drawLine(superiorLeftCorner.getPosX(), inferiorRightCorner.getPosY(),
                inferiorRightCorner.getPosX(), inferiorRightCorner.getPosY(), paint);
        canvas.drawLine(inferiorRightCorner.getPosX(), inferiorRightCorner.getPosY(),
                inferiorRightCorner.getPosX(), superiorLeftCorner.getPosY(), paint);
        canvas.drawLine(inferiorRightCorner.getPosX(), superiorLeftCorner.getPosY(),
                superiorLeftCorner.getPosX(), superiorLeftCorner.getPosY(), paint);

        // Reset line style
        paint.setPathEffect(null);
    }
}
