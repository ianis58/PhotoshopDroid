package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.paths;

import android.graphics.Point;

import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.SketchView;

abstract public class AbstractPath {

    public int color;
    public int strokeWidth;
    public SketchView.SketchMode drawingMode;

    public AbstractPath(int color, int strokeWidth, SketchView.SketchMode drawingMode) {
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.drawingMode = drawingMode;
    }
}
