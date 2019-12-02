package Assistances.GameTile;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Tile extends TileType {
    private double x,y,size;
    private Image image;
    private boolean available;

    public Tile(double x, double y,double size,boolean t) {
        this.x = x;
        this.y = y;
        this.size=size;
        this.available=t;
    }
    public  abstract void Draw(GraphicsContext gc);

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
