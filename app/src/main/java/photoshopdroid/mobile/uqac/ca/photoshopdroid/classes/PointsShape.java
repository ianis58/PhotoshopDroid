package photoshopdroid.mobile.uqac.ca.photoshopdroid;

import android.graphics.Canvas;
import java.util.ArrayList;

public abstract class PointsShape extends GeometricShape {
    private ArrayList<Point2D> pointsList;

    // On PointsShape creation, initialize the list of points
    public PointsShape(int color, int width){
        super(color, width);
        pointsList = new ArrayList<Point2D>();
    }

    // Draws the consecutive lines that are in the PointsShape, using the PointsShape's parameters
    public void draw(Canvas canvas){
        int i = 0;

        while (i < pointsList.size()){
            canvas.drawLine(pointsList.get(i).getPosX(),
                    pointsList.get(i).getPosY(),
                    pointsList.get(i+1).getPosX(),
                    pointsList.get(i+1).getPosY(), paint);

            i++;
        }
    }
}
