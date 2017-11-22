package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.paths;

import android.graphics.Point;

import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.SketchView;

public class RectanglePath extends AbstractPath {

    private Point origin;
    private Point destination;

    public RectanglePath(int color, int strokeWidth, SketchView.SketchMode drawingMode){
        super(color, strokeWidth, drawingMode);
    }

    public void addPoint(Point point){
        if(this.origin != null){
            this.destination = point;
        }
        else{
            this.origin = point;
        }
    }

    public boolean isComplete(){
        return (this.origin != null && this.destination != null);
    }

    public int getLeft(){
        return origin.x;
    }

    public int getRight(){
        return destination.x;
    }

    public int getTop(){
        return origin.y;
    }

    public int getBottom(){
        return destination.y;
    }

    public void setDestination(Point destination){
        this.destination = destination;
    }
}
