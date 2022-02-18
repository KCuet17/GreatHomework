package sample.Enemy;

import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class TankerEnemy extends AbstractEnemy {
    private Image image=Config.tankerEnemy;

    public TankerEnemy(){
        super(200,64,64,64, Config.TANKER_ENEMY_HEALTH,Config.TANKER_ENEMY_SPEED,Config.TANKER_ENEMY_REWARD);
    }

    public TankerEnemy(long createTick, double posX, double posY, long size, long health, int speed, long reward) {
        super(createTick, posX, posY, size, health, speed, reward);
    }
    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.image,this.getX(),this.getY(),this.width,this.height);
    }
}
