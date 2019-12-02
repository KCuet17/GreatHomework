package sample.Enemy;

import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boss extends AbstractEnemy {
    private Image image= Config.boss;

    public Boss(){
        super(300,64,64,64, Config.BOSS_ENEMY_HEALTH,Config.BOSS_ENEMY_SPEED,Config.BOSS_ENEMY_REWARD);
    }

    public Boss(long createTick, double posX, double posY, long size, long health, int speed, long reward) {
        super(createTick, posX, posY, size, health, speed, reward);
    }
    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.image,this.getX(),this.getY(),this.width,this.height);
    }
}
