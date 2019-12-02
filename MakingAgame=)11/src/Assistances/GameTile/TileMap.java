package Assistances.GameTile;

import Assistances.Config;
import javafx.scene.canvas.GraphicsContext;

public class TileMap {
     private Tile[][] tiles;

     public TileMap(){
          this.tiles= new Tile[Config.map.length][Config.map[0].length];
          for(int i=0;i<Config.map.length;i++){
              for(int j=0;j<Config.map[i].length;j++){
                  if(Config.map[i][j]==0) this.tiles[i][j]=new Road(Config.SIZE*j,Config.SIZE*i,Config.SIZE);
                  if(Config.map[i][j]==1) this.tiles[i][j]=new Mountain(Config.SIZE*j,Config.SIZE*i,Config.SIZE);
                  if(Config.map[i][j]==2) this.tiles[i][j]=new Shop(Config.SIZE*j,Config.SIZE*i,Config.SIZE);
              }
          }
     }
     public void Draw(GraphicsContext gc){
         for(int i=0;i<this.tiles.length;i++){
             for(int j=0;j<this.tiles[i].length;j++){
                 this.tiles[i][j].Draw(gc);
             }
         }
     }
     public String getTileType(int x,int y){
          return this.tiles[x][y].getType();
     }
     public boolean getAvailable(int x, int y){
         return this.tiles[x][y].isAvailable();
     }
     public void setAvailable(int x,int y,boolean t){
         this.tiles[x][y].setAvailable(t);
     }
}
