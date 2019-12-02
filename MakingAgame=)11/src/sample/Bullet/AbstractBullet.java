package sample.Bullet;

import Assistances.Config;
import Assistances.Point;
import javafx.scene.canvas.GraphicsContext;
import sample.AbstractEntity;

public abstract class AbstractBullet extends AbstractEntity {
    protected final double deltaX;
    protected final double deltaY;
    protected final int strength;
    protected double speed;
    protected Point center;
    private long tick;


    protected AbstractBullet(long createdTick, double posX, double posY, double deltaX, double deltaY, double speed, int strength, long timeToLive,long size) {
        super(createdTick, posX, posY,size , size);
        double t= Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        final double normalize = speed / t;
        this.deltaX = deltaX / t* normalize;
        this.deltaY = deltaY / t * normalize;
        this.speed=speed;
        this.strength = strength;
        this.tick = timeToLive;
        this.center= new Point((long)posX+size/2,(long)posY+size/2);
    }


    public void BulletUpdate(GraphicsContext gc) {

        this.X+= this.getDeltaX()*this.speed* Config.gameSpeed;
        this.Y+= this.getDeltaY()*this.speed*Config.gameSpeed;

        this.center.setX((long)this.X);
        this.center.setY((long)this.Y);
        this.Draw(gc);
    }
    public abstract void Draw(GraphicsContext gc);

    /*
    public final boolean onEffect(@Nonnull GameField field, @Nonnull LivingEntity livingEntity) {
        livingEntity.doEffect(-strength);
        this.tickDown = 0;
        return false;
    }

    public final void doDestroy() {
        this.tickDown = 0;
    }

    public final boolean isDestroyed() {
        return tickDown <= -0;
    }
*/

    public int getStrength() {
        return strength;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }
}
