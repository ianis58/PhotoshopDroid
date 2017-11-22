package photoshopdroid.mobile.uqac.ca.photoshopdroid;

public class BoundingBox {
    private Point2D superiorLeftCorner;
    private Point2D inferiorRightCorner;

    public BoundingBox(Point2D corner1, Point2D corner2){
        float x1 = corner1.getPosX();
        float y1 = corner1.getPosY();
        float x2 = corner2.getPosX();
        float y2 = corner2.getPosY();

        superiorLeftCorner.setPosX(x1 < x2 ? x1 : x2);
        superiorLeftCorner.setPosY(y1 > y2 ? y1 : y2);
        inferiorRightCorner.setPosX(x1 > x2? x1 : x2);
        inferiorRightCorner.setPosY(y1 < y2 ? y1 : y2);
    }

    public Point2D getSuperiorLeftCorner() {
        return superiorLeftCorner;
    }

    public Point2D getInferiorRightCorner() {
        return inferiorRightCorner;
    }
}
