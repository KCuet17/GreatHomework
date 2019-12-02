package sample.Potion;

import Assistances.Point;
import javafx.scene.canvas.GraphicsContext;
import sample.Enemy.AbstractEnemy;

import java.util.ArrayList;

public abstract class AbstractPotion {
    protected Point center;
    protected double range;
    protected long tickDown;
    protected ArrayList<AbstractEnemy> enemies;

    public AbstractPotion(double x, double y, double range, long tickDown) {
        this.center= new Point((long)x,(long)y);
        this.range = range;
        this.tickDown = tickDown;
        this.enemies= new ArrayList<>();
    }

    public abstract void doEffect(GraphicsContext gc);

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public long getTickDown() {
        return tickDown;
    }

    public void setTickDown(long tickDown) {
        this.tickDown = tickDown;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public ArrayList<AbstractEnemy> getEnemies() {
        return enemies;
    }

    public void addEnemy(AbstractEnemy enemy) {
        this.enemies.add(enemy);
    }
    public long getX(){
        return this.center.getX();
    }
    public long getY(){
        return this.getCenter().getY();
    }

}
