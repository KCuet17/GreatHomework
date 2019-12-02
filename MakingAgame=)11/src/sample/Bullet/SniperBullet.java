package sample.Bullet;

import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class SniperBullet extends AbstractBullet {
    private Image image= Config.sniperBullet;
    public SniperBullet(long createdTick, double posX, double posY, double deltaX, double deltaY) {
        super(createdTick, posX, posY, deltaX, deltaY,Config.SNIPER_BULLET_SPEED,(int)Config.SNIPER_BULLET_STRENGTH,60,15);
    }
    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.image,this.getX(),this.getY(),this.width,this.height);
    }

}
