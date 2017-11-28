package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.paths;

import android.graphics.Point;
import android.util.FloatMath;

import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.SketchView;

/**
 * Created by Utilisateur on 2017-11-28.
 */

public class CirclePath extends AbstractPath {
    private Point center;
    private float radius;

    public CirclePath(int color, int strokeWidth, SketchView.SketchMode drawingMode){
        super(color, strokeWidth, drawingMode);
    }

    public Point getCenter(){
        return center;
    }

    public float getRadius(){
        return radius;
    }

    public void defineOrigin(Point center){
        this.center = center;
    }

    public void defineRadius(Point border){
        int dist = 0;
        dist = (int) Math.sqrt(((border.x - center.x)*(border.x - center.x)) + ((border.y - center.y)*(border.y - center.y)));

        radius = dist;
    }

    public boolean isValid(){
        boolean validity = true;

        if (radius < 10){
            validity = false;
        }

        return validity;
    }
}
