package Assistances;

public class Point {
    private long x,y;

    public Point(long x,long y){
        this.x=x;
        this.y=y;
    }
    public double Distance(Point p){
        return Math.sqrt((this.x-p.getX())*(this.x-p.getX())+(this.y-p.getY())*(this.y-p.getY()));
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
    public String toString(){
        return "("+this.x+","+this.y+")";
    }
}
