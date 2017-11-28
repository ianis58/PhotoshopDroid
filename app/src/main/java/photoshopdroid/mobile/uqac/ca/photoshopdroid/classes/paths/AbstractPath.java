package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.paths;

import android.graphics.Point;

import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.SketchView;

abstract public class AbstractPath {

    public int color;
    public int strokeWidth;
    public SketchView.SketchMode drawingMode;
    private int pathId = 0;
    public static int count = 1;

    public AbstractPath(int color, int strokeWidth, SketchView.SketchMode drawingMode) {
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.drawingMode = drawingMode;
        pathId = count;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public SketchView.SketchMode getDrawingMode() {
        return drawingMode;
    }

    public void setDrawingMode(SketchView.SketchMode drawingMode) {
        this.drawingMode = drawingMode;
    }

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }
}
