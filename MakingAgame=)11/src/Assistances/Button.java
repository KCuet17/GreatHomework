package Assistances;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Button  {
    private Image image;
    private Point topleft;
    private double size;

    public Button(Point topleft) {
        this.topleft = topleft;
    }

    public Button(double X, double Y, double size,Image image,GraphicsContext gc){
        this.topleft= new Point((long)X,(long)Y);
        this.size=size;
        this.image=image;
        gc.drawImage(this.image,this.getTopleft().getX(),this.getTopleft().getY(),Config.SIZE,Config.SIZE);
    }
    public Button(double X, double Y, double width,double height,Image image,GraphicsContext gc){
        this.topleft= new Point((long)X,(long)Y);
        this.size=size;
        this.image=image;
        gc.drawImage(this.image,this.getTopleft().getX(),this.getTopleft().getY(),width,height);
    }
    public boolean iscontain(double x,double y){
        return (x>=this.topleft.getX() && y>=this.topleft.getY()
        && (x-this.topleft.getX()<=size) && (y-this.topleft.getY())<=size);
    }

    public Point getTopleft() {
        return topleft;
    }

    public void setTopleft(Point topleft) {
        this.topleft = topleft;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
