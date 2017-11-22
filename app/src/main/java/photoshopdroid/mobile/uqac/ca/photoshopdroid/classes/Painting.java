package photoshopdroid.mobile.uqac.ca.photoshopdroid;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Painting {
    public enum PaintingShape {
        Line,
        Circle,
        Rectangle,
        Star
    }

    public enum PaintingWidth{
        Small,
        Medium,
        Large
    }

    // Outils actuels
    private PaintingShape currentlySelectedTool;
    private PaintingWidth currentStrokeWidth;

    // Objets présents dans le dessin
    private ArrayList<GeometricShape> shapes;
    private Canvas canvas;

    public Painting(){
        // Default parameters for shapes
        currentlySelectedTool = PaintingShape.Line;
        currentStrokeWidth = PaintingWidth.Medium;
        // Initialization of the painting and its items
        canvas = new Canvas();
        shapes = new ArrayList<GeometricShape>();
    }

    public void RefreshPainting(){
        for (GeometricShape d : shapes){
            d.draw(canvas);
        }
    }

    public void SelectTool(PaintingShape toolType)
    {
        currentlySelectedTool = toolType;
    }

    public void SelectStrokeWidth(PaintingWidth width){
        currentStrokeWidth = width;
    }

    public void AddShape(GeometricShape d){
        shapes.add(d);
    }
}
