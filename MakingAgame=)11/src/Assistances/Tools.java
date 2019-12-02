package Assistances;

import Assistances.GameTile.TileMap;
import javafx.scene.canvas.GraphicsContext;

public class Tools {

    public static void DrawMap(GraphicsContext gc) {
        TileMap tileMap= new TileMap();
        tileMap.Draw(gc);
    }
}
