package sample.Tower;


import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Bullet.MachineGunBullet;


public class MachineGunTower extends AbstractTower <MachineGunBullet>{
    private Image image= Config.machineGunTower;

    public MachineGunTower( int X, int Y) {
        super(Config.MACHINE_GUN_TOWER_SPEED, X, Y, Config.MACHINE_GUN_TOWER_RANGE*Config.SIZE, Config.MACHINE_GUN_BULLET_SPEED);
    }

    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.image,this.X,this.Y,this.width,this.height);
    }

    @Override
    protected final MachineGunBullet doSpawn(long createdTick, double posX, double posY, double deltaX, double deltaY) {
        return new MachineGunBullet(createdTick, posX, posY, deltaX, deltaY);
    }
    @Override
    public void update(GraphicsContext gc){
        super.update(gc);
    }

}
