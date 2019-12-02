package sample.Bullet;

import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class NormalBullet extends AbstractBullet {
    private Image image= Config.normalBullet;
    public NormalBullet(long createdTick, double posX, double posY, double deltaX, double deltaY) {
        super(createdTick, posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_SPEED,
                (int)Config.NORMAL_BULLET_STRENGTH,60,13);
    }
    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.image,this.getX(),this.getY(),this.width,this.height);
    }

}
