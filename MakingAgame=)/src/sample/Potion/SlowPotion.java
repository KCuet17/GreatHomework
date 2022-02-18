package sample.Potion;


import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;
import sample.Enemy.Boss;
import sample.Enemy.NormalEnemy;
import sample.Enemy.SmallerEnemy;
import sample.Enemy.TankerEnemy;

public class SlowPotion extends AbstractPotion {
    private double speedReduce;

    public SlowPotion(double x,double y){
        super(x,y,Config.SLOW_POTION_RANGE,Config.SLOW_POTION_TICK);
        this.speedReduce=Config.SLOW_POTION_SPEED_REDUCE;
    }

    public void doEffect(GraphicsContext gc){
        if(this.tickDown>0) {
            for (int i = 0; i < enemies.size(); i++) {
                if(enemies.get(i) instanceof NormalEnemy){
                    enemies.get(i).setSpeed(Config.NORMAL_ENEMY_SPEED*this.speedReduce);
                }
                if(enemies.get(i) instanceof SmallerEnemy){
                    enemies.get(i).setSpeed(Config.SMALLER_ENEMY_SPEED*this.speedReduce);
                }
                if(enemies.get(i) instanceof TankerEnemy){
                    enemies.get(i).setSpeed(Config.TANKER_ENEMY_SPEED*this.speedReduce);
                }
                if(enemies.get(i) instanceof Boss){
                    enemies.get(i).setSpeed(Config.BOSS_ENEMY_SPEED*this.speedReduce);
                }
            }
        }
        for(int i=0;i<enemies.size();i++){
            if(enemies.get(i).getCenter().Distance(this.center)>=this.range){
                if(enemies.get(i) instanceof NormalEnemy){
                    enemies.get(i).setSpeed(Config.NORMAL_ENEMY_SPEED);
                }
                if(enemies.get(i) instanceof SmallerEnemy){
                    enemies.get(i).setSpeed(Config.SMALLER_ENEMY_SPEED);
                }
                if(enemies.get(i) instanceof TankerEnemy){
                    enemies.get(i).setSpeed(Config.TANKER_ENEMY_SPEED);
                }
                if(enemies.get(i) instanceof Boss){
                    enemies.get(i).setSpeed(Config.BOSS_ENEMY_SPEED);
                }
                enemies.remove(i);
            }
        }
        //gc.drawImage(Config.normalBullet,Math.max(this.getX()-this.range,0),Math.max(this.getY()-this.range,0),this.range*2,this.range*2);
        this.tickDown-= Config.gameSpeed;
    }
}
