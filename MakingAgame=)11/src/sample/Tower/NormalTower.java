package sample.Tower;


import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Bullet.NormalBullet;


public class NormalTower extends AbstractTower <NormalBullet>{
    private Image image= Config.normalTower;

    public NormalTower(int X, int Y) {
        super(Config.NORMAL_TOWER_SPEED, X, Y, Config.NORMAL_TOWER_RANGE*Config.SIZE, Config.NORMAL_TOWER_SPEED);
    }

    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.image,this.X,this.Y,this.width,this.height);
    }

    @Override
    protected final NormalBullet doSpawn(long createdTick, double posX, double posY, double deltaX, double deltaY) {
        return new NormalBullet(createdTick, posX, posY, deltaX, deltaY);
    }
    @Override
    public void update(GraphicsContext gc){
        super.update(gc);
    }

}
