package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.paths;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.SketchView;

public class TextPath extends AbstractPath {

    private Point point;
    private String text;
    private Paint mPaint;

    public TextPath(int color, int strokeWidth, SketchView.SketchMode drawingMode, Point point, String text, Paint mPaint) {
        super(color, strokeWidth, drawingMode);
        this.point = point;
        this.text = text;
        this.mPaint = mPaint;
    }

    public Point getPoint(){
        return point;
    }

    public String getText(){
        return text;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Paint getPaint() {
        return mPaint;
    }
}
