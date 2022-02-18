package Assistances;

public class Checkpoint {
    private int xDirection, yDirection;
    private  double xCoor,yCoor;

    public Checkpoint(){
        this.xCoor=0;
        this.yCoor=0;
        this.xDirection=0;
        this.yDirection=0;
    }

    public Checkpoint(int xDirection, int yDirection, double xCoor, double yCoor) {
        this.xDirection = xDirection;
        this.yDirection = yDirection;
        this.xCoor = xCoor;
        this.yCoor = yCoor;
    }
    public String toString(){
        return "("+this.xCoor/64+","+this.yCoor/64+")";
    }

    public int getxDirection() {
        return xDirection;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public double getxCoor() {
        return xCoor;
    }

    public void setxCoor(double xCoor) {
        this.xCoor = xCoor;
    }

    public double getyCoor() {
        return yCoor;
    }

    public void setyCoor(double yCoor) {
        this.yCoor = yCoor;
    }

}
