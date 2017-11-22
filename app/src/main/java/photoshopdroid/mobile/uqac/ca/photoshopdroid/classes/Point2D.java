package photoshopdroid.mobile.uqac.ca.photoshopdroid.classes;

public class Point2D {
    private float posX;
    private float posY;

    public Point2D(float x, float y){
        posX = x;
        posY = y;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }
}
