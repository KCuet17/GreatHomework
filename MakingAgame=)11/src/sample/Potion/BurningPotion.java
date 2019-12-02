package sample.Potion;


import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;

public class BurningPotion extends AbstractPotion {
    private int healthReduce;

    public BurningPotion(double x,double y){
        super(x,y,Config.SLOW_POTION_RANGE,Config.SLOW_POTION_TICK);
        this.healthReduce=Config.BURNING_POTION_HEALTH_REDUCE;
    }

    public void doEffect(GraphicsContext gc){
        if(this.tickDown>0) {
            for (int i = 0; i < enemies.size(); i++) {
                if(tickDown%200==0) enemies.get(i).getDamage(1);
            }
        }
        for(int i=0;i<enemies.size();i++){
            if(enemies.get(i).getCenter().Distance(this.getCenter())>=this.range) enemies.remove(i);
        }
        for (int i = 0; i < enemies.size(); i++) {
            if(enemies.get(i).getHealth()<=0) enemies.remove(i);
        }
        //gc.drawImage(Config.machineGunBullet,Math.max(this.getX()-this.range,0),Math.max(this.getY()-this.range,0),this.range*2,this.range*2);
        this.tickDown-= Config.gameSpeed;
    }
}
