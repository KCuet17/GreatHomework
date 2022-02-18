package Assistances.GameTile;

import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;

public class Road extends Tile {

    public Road(double x, double y, double size){
        super(x,y,64,false);
        this.setImage(Config.road) ;
        this.type="road";
    }
    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.getImage(),this.getX(),this.getY(),Config.SIZE,Config.SIZE);
    }

}