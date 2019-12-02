package sample.Enemy;

import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SmallerEnemy extends AbstractEnemy {
    private Image image= Config.smallerEnemy;

    public SmallerEnemy(){
        super(150,64,64,64, Config.SMALLER_ENEMY_HEALTH, Config.SMALLER_ENEMY_SPEED,Config.SMALLER_ENEMY_REWARD);
    }

    public SmallerEnemy(long createTick, double posX, double posY, long size, long health, int speed, long reward) {
        super(createTick, posX, posY, size, health, speed, reward);
    }
    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.image,this.getX(),this.getY(),this.width,this.height);
    }
}
