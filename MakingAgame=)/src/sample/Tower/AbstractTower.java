package sample.Tower;

import Assistances.Config;
import Assistances.Point;
import javafx.scene.canvas.GraphicsContext;
import sample.AbstractEntity;
import sample.Bullet.AbstractBullet;
import sample.Enemy.AbstractEnemy;
import sample.Enemy.NormalEnemy;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractTower<E extends AbstractBullet> extends AbstractEntity {
    protected final double range;
    protected final double speed;
    protected ArrayList<AbstractBullet> bullets;
    protected Image towerImage;
    protected AbstractEnemy enemy;
    protected Point center;
    protected int price;

    protected long tickDown;

    protected AbstractTower(long createdTick, double X, double Y, double range, double speed) {
        super(createdTick, X, Y, 64,64 );
        this.range = range;
        this.speed = speed;
        this.tickDown = 0;
        this.center=new Point((long)(X+ Config.SIZE/2),(long)(Y+Config.SIZE/2));
        this.enemy=new NormalEnemy();
        this.enemy.setHealth(0);
        this.bullets= new ArrayList<>();
    }
    public void update(GraphicsContext gc) {
        double t= Math.sqrt(this.center.Distance(this.enemy.getCenter()));
        if(this.enemy.getHealth()>0 && t<=this.range ) {
            if (tickDown <=0) {
                bullets.add(doSpawn(this.getCreatedTick(), this.center.getX(), this.center.getY(), findDeltaX(), findDeltaY()));
                this.tickDown=this.getCreatedTick();
            }
            for(int i=0;i<this.bullets.size()-1;i++){
                this.bullets.get(i).BulletUpdate(gc);
            }
            for (int i = 0; i < this.bullets.size()-1; i++) {
                if (Math.abs(this.bullets.get(i).getX() - this.enemy.getCenter().getX()) <= 25
                        && Math.abs(this.bullets.get(i).getY() - this.enemy.getCenter().getY()) <= 22) {
                    this.bullets.remove(i);
                    this.enemy.getDamage(this.bullets.get(i).getStrength());
                }
                if (Math.abs(this.bullets.get(i).getX() - this.getX()) >= this.getRange() &&
                        Math.abs(this.bullets.get(i).getY() - this.getY()) >= this.getRange()) {
                    this.bullets.remove(i);
                }
            }
        }
        this.tickDown -= Config.gameSpeed;
        this.Draw(gc);
    }
    public void setEnemy(AbstractEnemy enemy){
        this.enemy=enemy;
    }

    public AbstractEnemy getEnemy() {
        return enemy;
    }

    public  double findDeltaX(){
        return (this.enemy.getCenter().getX()+this.enemy.getXDirection()*this.enemy.getSpeed()*Config.SIZE-this.center.getX())/this.center.Distance(this.enemy.getCenter());
    }
    public  double findDeltaY(){
        return (this.enemy.getCenter().getY()+this.enemy.getYDirection()*this.enemy.getSpeed()*Config.SIZE-this.center.getY())/this.center.Distance(this.enemy.getCenter());
    }

    protected abstract void Draw(GraphicsContext gc);

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public long getTick() {
        return tickDown;
    }

    public void setTick(long tick) {
        this.tickDown = tick;
    }

    public double getRange() {
        return range;
    }

    public double getSpeed() {
        return speed;
    }

    protected abstract E doSpawn(long createdTick, double posX, double posY, double deltaX, double deltaY);
}
