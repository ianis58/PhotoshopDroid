package photoshopdroid.mobile.uqac.ca.photoshopdroid;

public class Point2D {
    private int posX;
    private int posY;

    public Point2D(int x, int y){
        posX = x;
        posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
