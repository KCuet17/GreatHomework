package sample.Tower;


import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Bullet.SniperBullet;


public class SniperTower extends AbstractTower <SniperBullet>{
    private Image image= Config.sniperTower;

    public SniperTower( int X, int Y) {
        super(Config.SNIPER_TOWER_SPEED, X, Y, Config.SNIPER_TOWER_RANGE*Config.SIZE, Config.SNIPER_BULLET_SPEED

        );
    }

    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.image,this.X,this.Y,this.width,this.height);
    }

    @Override
    protected final SniperBullet doSpawn(long createdTick, double posX, double posY, double deltaX, double deltaY) {
        return new SniperBullet(createdTick, posX, posY, deltaX, deltaY);
    }
    @Override
    public void update(GraphicsContext gc){
        super.update(gc);
    }

}
