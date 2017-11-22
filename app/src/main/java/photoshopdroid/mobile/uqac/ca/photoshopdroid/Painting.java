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
        currentlySelectedTool = PaintingShape.Line;
        currentStrokeWidth = PaintingWidth.Medium;
        shapes = new ArrayList<GeometricShape>();
        canvas = new Canvas();
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

    public void SelectStrokeWidth(){

    }

    public void AddShape(GeometricShape d){
        shapes.add(d);
    }
}
