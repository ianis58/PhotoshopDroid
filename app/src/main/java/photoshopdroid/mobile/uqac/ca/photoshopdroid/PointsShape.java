package photoshopdroid.mobile.uqac.ca.photoshopdroid;

import java.util.List;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.GeometricShape;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.Point2D;

public abstract class PointsShape extends GeometricShape {
    private List<Point2D> pointsList;

    public PointsShape(int color, int width){
        super(color, width);
    }

    public void draw(){
        int i = 0;

        while (i < pointsList.size()){
            // drawLine(pointsList[i], pointsList[i+1]);

            i++;
        }
    }
}
