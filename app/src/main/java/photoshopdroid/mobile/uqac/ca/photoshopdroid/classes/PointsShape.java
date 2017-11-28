package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.GeometricShape;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.Point2D;

// PointsShapes are geometric shapes that can be representated by a given number of 2D points
public abstract class PointsShape extends GeometricShape {
    private static float INTERESTPOINTS_RADIUS = 5;
    private ArrayList<Point2D> pointsList;

    // On PointsShape creation, initialize the list of points
    public PointsShape(int color, int width){
        super(color, width);
        pointsList = new ArrayList<>();
    }

    // Draws the consecutive lines that are in the PointsShape, using the PointsShape's parameters
    public void drawShape(Canvas canvas){
        int i = 0;

        while (i < pointsList.size()){
            canvas.drawLine(pointsList.get(i).getPosX(),
                    pointsList.get(i).getPosY(),
                    pointsList.get(i+1).getPosX(),
                    pointsList.get(i+1).getPosY(), paint);

            i++;
        }
    }

    public void highlightInterestPoints(Canvas canvas, Paint paint){
        for (Point2D p : pointsList){
           canvas.drawCircle(p.getPosX(), p.getPosY(), INTERESTPOINTS_RADIUS, paint);
        }
    }
}
