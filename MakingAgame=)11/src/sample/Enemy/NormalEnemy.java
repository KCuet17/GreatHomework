package sample.Enemy;

import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class NormalEnemy extends AbstractEnemy{

    private Image image=Config.normalEnemy;


    public NormalEnemy(){
        super(100,64,64,(long)Config.SIZE, Config.NORMAL_ENEMY_HEALTH,Config.NORMAL_ENEMY_SPEED,Config.NORMAL_ENEMY_REWARD);
    }

    public NormalEnemy(long createTick, double posX, double posY, long size, long health, int speed, long reward) {
       super(createTick, posX, posY, size, health, speed, reward);
    }
    @Override
    public void Draw(GraphicsContext gc){
        /*
        AnimatedImage ufo = new AnimatedImage();
        Image[] imageArray = new Image[6];
        for (int i = 0; i <= 23; i++)
            imageArray[i] = new Image( "0_Golem_Walking_0" + i + ".png" );
        ufo.frames = imageArray;
        ufo.duration = 0.100;
        gc.drawImage( ufo.getFrame(1), 450, 25 );

         */
        gc.drawImage(this.image,this.X,this.Y,Config.SIZE,Config.SIZE);
    }
}
