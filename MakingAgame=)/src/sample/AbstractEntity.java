package sample;

public abstract class AbstractEntity {
    protected final long createdTick;
    protected double X;
    protected double Y;
    protected long width;
    protected long height;


    protected AbstractEntity(long createdTick, double posX, double posY, long width, long height) {
        this.createdTick = createdTick;
        this.X = posX;
        this.Y = posY;
        this.width = width;
        this.height = height;

    }


    public    long getCreatedTick() {
        return createdTick;
    }

    public    double getX() {
        return X;
    }

    public   void setX(double posX) {
        this.X = posX;
    }

    public double getY() {
        return Y;
    }

    public   void setY(double posY) {
        this.Y = posY;
    }

    public  long getWidth() {
        return width;
    }

    public   void setWidth(long width) {
        this.width = width;
    }

    public  long getHeight() {
        return height;
    }

    public   void setHeight(long height) {
        this.height = height;
    }
    /*
    public final boolean isContaining(double posX, double posY, double width, double height) {
        return this.posX <= posX
                && this.posY <= posY
                && this.posX + this.width >= posX + width
                && this.posY + this.height >= posY + height;
    }


    public final boolean isBeingContained(double posX, double posY, double width, double height) {
        return posX <= this.posX
                && posY <= this.posY
                && posX + width >= this.posX + this.width
                && posY + height >= this.posY + this.height;
    }


    public final boolean isBeingOverlapped(double posX, double posY, double width, double height) {
        return posX < this.posX + this.width
                && posY < this.posY + this.height
                && posX + width > this.posX
                && posY + height > this.posY;
    }

     */
}
