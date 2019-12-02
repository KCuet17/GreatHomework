package sample.Enemy;

import Assistances.Checkpoint;
import Assistances.Config;
import Assistances.GameTile.TileMap;
import Assistances.Point;
import javafx.scene.canvas.GraphicsContext;
import sample.AbstractEntity;

import java.util.ArrayList;

public abstract class AbstractEnemy extends AbstractEntity {
    protected double speed;
    protected int XDirection,YDirection;
    protected long reward,health;
    protected boolean Alive;
    protected Point center;
    protected TileMap tiles;
    private long tickCount;

//    protected Checkpoint turn;
    protected ArrayList<Checkpoint> checkpointList;
    protected int counter;

    public AbstractEnemy(long createTick,double posX,double posY,long size, long health,double speed,long reward){
        super(createTick,posX,posY,size,size);
        this.health=health;
        this.speed=speed;
        this.reward=reward;
        this.XDirection=1;
        this.YDirection=0;
        this.Alive=true;
//        this.turn= new Checkpoint(1,0,Config.SIZE*1,Config.SIZE*1);
        this.counter=0;
        this.center= new Point((long)posX+(long) Config.SIZE/2,(long)(posY+Config.SIZE/2));
        this.checkpointList= new ArrayList<>();
       Checkpoint checkpoint1=new Checkpoint(0,1,15*64,64);
        Checkpoint checkpoint2=new Checkpoint(-1,0,15*64,4*64);
        Checkpoint checkpoint3=new Checkpoint(0,1,4*64,4*64);
        Checkpoint checkpoint4=new Checkpoint(1,0,4*64,7*64);
        Checkpoint checkpoint5=new Checkpoint(0,1,11*64,7*64);
        Checkpoint checkpoint6=new Checkpoint(1,0,11*64,9*64);
        Checkpoint checkpoint7=new Checkpoint(0,0,16*64,9*64);
        checkpointList.add(checkpoint1);
       checkpointList.add(checkpoint2);
        checkpointList.add(checkpoint3);
        checkpointList.add(checkpoint4);
        checkpointList.add(checkpoint5);
        checkpointList.add(checkpoint6);
        checkpointList.add(checkpoint7);
        this.tickCount=0;
    }

    public abstract void Draw(GraphicsContext gc);

    public boolean isPassed(){
        if(this.XDirection>0) return this.getX()>=this.checkpointList.get(counter).getxCoor();
        if(this.XDirection<0) return this.getX()<=this.checkpointList.get(counter).getxCoor();
        if(this.YDirection>0) return this.getY()>=this.checkpointList.get(counter).getyCoor();
        return false;
    }

    public void update(GraphicsContext gc){
        if(this.health<=0) {
        }
        else {
            if (this.isPassed()) {
                this.XDirection = this.checkpointList.get(counter).getxDirection();
                this.YDirection = this.checkpointList.get(counter).getyDirection();
                this.counter++;
            }

            this.Y+= this.YDirection*this.getSpeed()*Config.gameSpeed;
            this.X+= this.XDirection*this.getSpeed()*Config.gameSpeed;
            this.center.setX((long) this.X + 32);
            this.center.setY((long) this.Y + 32);
            this.Draw(gc);
        }
    }


/*
    // AI
    public void findNextCheckpoint(){
        int counter=0;
        boolean tmp=false;
        int i=(int)this.Y/64;
        int j=(int)this.X/64;
        while (!tmp) {
            if (this.XDirection > 0) {
                if (Config.map[i][j + counter + 1] == 1 && Config.map[i+1][j + counter] == 0) {
                    this.turn = new Checkpoint(0, 1, Config.SIZE * (j + counter), Config.SIZE * (i));
                    tmp=true;
                }
                if (Config.map[i][j + 1 + counter] == 1 && Config.map[i - 1][j + 1 + counter] == 0) {
                    tmp=true;
                    this.turn = new Checkpoint(0, -1, Config.SIZE * (j + counter), Config.SIZE * (i));
                }
            } else if (this.XDirection < 0) {
                if (Config.map[i][j - counter - 1] == 1 && Config.map[i + 1][j - counter] == 0) {
                    tmp=true;
                    this.turn = new Checkpoint(0, 1, Config.SIZE * (j - counter), Config.SIZE * (i));
                }
                if (Config.map[i][j - 1 - counter] == 1 && Config.map[i - 1][j - counter] == 0) {
                    tmp=true;
                    this.turn = new Checkpoint(0, -1, Config.SIZE * (j + counter), Config.SIZE * (i));
                }
            } else if (this.getYDirection() > 0) {
                if (Config.map[i + counter + 1][j] == 1 && Config.map[i + counter][j + 1] == 0) {
                    tmp=true;
                    this.turn = new Checkpoint(1, 0, Config.SIZE * (j), Config.SIZE * (i + counter));
                }
                if (Config.map[i + counter + 1][j] == 1 && Config.map[i + counter][j - 1] == 0) {
                    tmp=true;
                    this.turn = new Checkpoint(-1, 0, Config.SIZE * (j), Config.SIZE * (i + counter));
                }
            }
            counter++;
        }
    }

    public boolean isPass(){
        return (this.XDirection*(this.turn.getxCoor()-this.X)>=0 && this.YDirection*(this.turn.getyCoor()-this.Y)>=0);
    }

    public void update(GraphicsContext gc){
        if(this.health<=0) {
        }
        else {
            if(this.X>=18*64 && this.Y>=10*64) this.Alive=false;
            if (this.isPass()) {
                this.XDirection = this.turn.getxDirection();
                this.YDirection = this.turn.getyDirection();
 //               this.counter++;
                System.out.printf(this.turn.toString()+" next ");
                this.findNextCheckpoint();
                System.out.printf(this.turn.toString());
                System.out.println("");
            }
            this.Y+= this.YDirection*this.getSpeed()*Config.gameSpeed;
            this.X+= this.XDirection*this.getSpeed()*Config.gameSpeed;
            this.center.setX((long) this.X + 32);
            this.center.setY((long) this.Y + 32);
            this.Draw(gc);
        }
    }
*/
     public long getSize(){
        return this.width;
     }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void getDamage(int strength){
        this.health-= strength;
    }

    public int getXDirection() {
        return XDirection;
    }

    public void setXDirection(int XDirection) {
        this.XDirection = XDirection;
    }

    public int getYDirection() {
        return YDirection;
    }

    public void setYDirection(int YDirection) {
        this.YDirection = YDirection;
    }


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public long getReward() {
        return reward;
    }

    public void setReward(long reward) {
        this.reward = reward;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(boolean alive) {
        Alive = alive;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public long getTickCount() {
        return tickCount;
    }

    public void setTickCount(long tickCount) {
        this.tickCount = tickCount;
    }
}
