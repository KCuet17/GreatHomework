package Assistances.GameTile;

import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;

public class Mountain extends Tile {

    public Mountain(double x, double y, double size){
        super(x,y,64,true);
        this.setImage(Config.mountain) ;
        this.type="mountain";
    }
    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.getImage(),this.getX(),this.getY(),Config.SIZE,Config.SIZE);
    }
}
