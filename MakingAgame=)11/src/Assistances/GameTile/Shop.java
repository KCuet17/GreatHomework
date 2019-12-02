package Assistances.GameTile;

import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;

public class Shop extends Tile {

    public Shop(double x, double y, double size){
        super(x,y,Config.SIZE,false);
        this.setImage(Config.shop) ;
        this.type="shop";
    }

    @Override
    public void Draw(GraphicsContext gc){
        gc.drawImage(this.getImage(),this.getX(),this.getY(),Config.SIZE,Config.SIZE);
    }
}