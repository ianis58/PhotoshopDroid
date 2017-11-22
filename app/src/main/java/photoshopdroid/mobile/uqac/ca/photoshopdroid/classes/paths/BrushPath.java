package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.paths;

import android.graphics.Path;

import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.SketchView;

public class BrushPath extends AbstractPath {

    private Path path;

    public BrushPath(int color, int strokeWidth, SketchView.SketchMode drawingMode, Path path) {
        super(color, strokeWidth, drawingMode);
        this.path = path;
    }

    public Path getPath(){
        return path;
    }

}
