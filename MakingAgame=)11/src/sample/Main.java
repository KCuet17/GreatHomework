package sample;

import Assistances.Button;
import Assistances.Config;
import Assistances.GameTile.TileMap;
import Assistances.Tools;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.Enemy.*;
import sample.Potion.AbstractPotion;
import sample.Potion.BurningPotion;
import sample.Potion.SlowPotion;
import sample.Tower.*;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    private boolean stop=false,isSkip=false;
    private int choose=0;
    private boolean start=false;
    private TileMap check= new TileMap();
    private Player player1= new Player();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) {
        theStage.setTitle("TOWER DEFENSE");
        Group root= new Group();
        Group root2= new Group();
        Group root3= new Group();
        Group root4= new Group();
        Scene Menu= new Scene(root);
        Scene gameStage= new Scene(root2);
        Scene end= new Scene(root3);
        Scene win= new Scene(root4);
        theStage.setScene(Menu);
        Canvas canvas= new Canvas(Config.WIDTH,Config.HEIGHT);
        root.getChildren().add(canvas);
        GraphicsContext gc= canvas.getGraphicsContext2D();
        gc.drawImage(Config.menu,0,0,Config.WIDTH, Config.HEIGHT);
        //some button on the menu
        Button playButton= new Button(9*Config.SIZE,7*Config.SIZE,Config.SIZE*4,Config.playButton,gc);

        Music music=new Music ();
        music.mediaPlayer1.play ();

        Menu.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override

                    public void handle(MouseEvent e) {
                        music.mediaPlayer1.stop ();
                        if(playButton.iscontain(e.getX(),e.getY())){
                            start=true;
                            System.out.println (start);
                            theStage.setScene(gameStage);
                            music.mediaPlayer.play ();

                        }
                    }
                }
        );
        theStage.show();

        Canvas canvas1= new Canvas(Config.WIDTH,Config.HEIGHT);
        Canvas canvas2= new Canvas(Config.WIDTH,Config.HEIGHT);
        root2.getChildren().add(canvas1);
        root2.getChildren().add(canvas2);
        GraphicsContext gc1= canvas1.getGraphicsContext2D();
        GraphicsContext gc2= canvas2.getGraphicsContext2D();
        Tools.DrawMap(gc1);
        //gc1.drawImage(Config.gameMap,0,0, Config.WIDTH,Config.HEIGHT);
        //new tower list,enemy list
        ArrayList<AbstractTower> towers= new ArrayList<>();
        ArrayList<AbstractEnemy> enemies= new ArrayList<>();
        ArrayList<AbstractPotion> potions = new ArrayList<>();

        //new Button to buy
        ArrayList<Button> buttons= new ArrayList<>();
        Button buyNormal= new Button(18*Config.SIZE,3*Config.SIZE,Config.SIZE,Config.buyNormal,gc1);
        buttons.add(buyNormal);
        Button buySniper= new Button(18*Config.SIZE,4*Config.SIZE,Config.SIZE,Config.buySniper,gc1);
        buttons.add(buySniper);
        Button buyMachineGun= new Button(18*Config.SIZE,5*Config.SIZE,Config.SIZE,Config.buyMachineGun,gc1);
        buttons.add(buyMachineGun);
        Button slowPotion= new Button(18*Config.SIZE,6*Config.SIZE,Config.SIZE,Config.buySlowPotion,gc1);
        buttons.add(slowPotion);
        Button burningPotion= new Button(18*Config.SIZE,7*Config.SIZE,Config.SIZE,Config.buyBurningPotion,gc1);
        buttons.add(burningPotion);
        Button paused= new Button(18*Config.SIZE,10*Config.SIZE,Config.SIZE,Config.gameStop,gc1);
        buttons.add(paused);
        Button skip= new Button(19*Config.SIZE,10*Config.SIZE,Config.SIZE,Config.gameSkip,gc1);
        buttons.add(skip);
        gc1.drawImage(Config.statusBar,18*Config.SIZE,8*Config.SIZE,Config.SIZE*2,Config.SIZE*2);
        gc1.setFill (Color.BLUEVIOLET);
        Font font= Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 30);
        gc1.setFont (font);
        gc1.fillText ("ITEM\nPACK",18.2*Config.SIZE,40);
/*
        gameStage.setOnMouseDragOver(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        int X=(int)(e.getX()/Config.SIZE);
                        int y=(int)(e.getY()/Config.SIZE);
                        for(int i=0;i<buttons.size();i++){
                            if(buttons.get(i).iscontain(e.getX(),e.getY())){
                                gc2.drawImage(Config.background,e.getX(),e.getY());
                            }
                        }
                    }
                }
        );
*/
        gameStage.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        music.mediaPlayer.play ();
                        int X=(int)e.getX()/64;
                        int Y=(int)e.getY()/64;
                        // normal=1,sniper=2,machine=3,slow=4,burn=5
                        if(buyNormal.iscontain(e.getX(),e.getY()) && player1.getMoney()>=Config.NORMAL_TOWER_PRICE){
                            choose=1;
                        }
                        if(buySniper.iscontain(e.getX(),e.getY()) && player1.getMoney()>=Config.SNIPER_TOWER_PRICE){
                            choose=2;
                        }
                        if(buyMachineGun.iscontain(e.getX(),e.getY())&& player1.getMoney()>=Config.MACHINE_GUN_TOWER_PRICE){
                            choose=3;
                        }
                        if(slowPotion.iscontain(e.getX(),e.getY())){
                            choose=4;
                        }
                        if(burningPotion.iscontain(e.getX(),e.getY())){
                            choose=5;
                        }
                        if(paused.iscontain(e.getX(),e.getY())){
                            if(!stop) {
                                Config.gameSpeed=0;
                                stop=true;
                                music.mediaPlayer.stop ();
                            }
                            else {
                                Config.gameSpeed=1;
                                stop=false;
                            }
                        }
                        if(skip.iscontain(e.getX(),e.getY())){
                            if(!isSkip) {
                                Config.gameSpeed=2;
                                isSkip=true;
                            }
                            else {
                                Config.gameSpeed=1;
                                isSkip=false;
                            }
                        }
                        if(check.getAvailable(Y,X)){
                            if(choose==1){
                                towers.add(new NormalTower(X*64,Y*64));
                                choose=0; player1.pay(Config.NORMAL_TOWER_PRICE);
                                check.setAvailable(Y,X,false);
                            }
                            else if(choose==2){
                                towers.add(new SniperTower(X*64,Y*64));
                                choose=0;player1.pay(Config.SNIPER_TOWER_PRICE);
                                check.setAvailable(Y,X,false);
                            }
                            else if(choose==3){
                                towers.add(new MachineGunTower(X*64,Y*64));
                                choose=0; player1.pay(Config.MACHINE_GUN_TOWER_PRICE);
                                check.setAvailable(Y,X,false);
                            }
                            else choose=0;
                        }
                        if(check.getTileType(Y,X).equals("road")){
                            if(choose==4 && player1.getMoney()>=Config.SLOW_POTION_PRICE) {
                                potions.add(new SlowPotion(e.getX(), e.getY()));
                                choose = 0; player1.pay(Config.SLOW_POTION_PRICE);
                            }
                            if(choose==5 && player1.getMoney()>=Config.BURNING_POTION_PRICE) {
                                potions.add((new BurningPotion(e.getX(),e.getY())));
                                choose=0; player1.pay(Config.BURNING_POTION_PRICE);
                            }
                        }
                    }
                }
        );

        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 25 );
        gc2.setStroke(Color.BLACK);
        gc2.setLineWidth(1);
        gc2.setFont(theFont);
       // System.out.println (start);
            new AnimationTimer () {
                long tick = 1;
                //Music music=new Music ();

                public void handle(long currentNanoTime) {

                    gc2.clearRect (0, 0, Config.WIDTH, Config.HEIGHT);
                    gc2.setFill (Color.RED);
                    gc2.fillText (String.valueOf (player1.getHealth ()), 18.5 * 64, 8.7 * 64);
                    gc2.strokeText (String.valueOf (player1.getHealth ()), 18.5 * 64, 8.7 * 64);
                    gc2.setFill (Color.YELLOW);
                    gc2.fillText (String.valueOf (player1.getMoney ()), 18.5 * 64, 9.6 * 64);
                    gc2.strokeText (String.valueOf (player1.getMoney ()), 18.5 * 64, 9.6 * 64);

                    if (player1.getHealth () <= 0) {
                        theStage.setScene (end);
                        music.mediaPlayer.stop ();

                    } else {
                        if(start) {
                            if (tick >= 200 * 25 && enemies.size () <= 0) {
                                theStage.setScene (win);
                                music.mediaPlayer.stop ();
                            }
                            // Random enemy spawn
                            if (tick % 200 == 0 && tick <= 200 * 25) {
                                Random rd = new Random ();
                                int number = rd.nextInt (4);
                                if (number == 0) {
                                    NormalEnemy enemy = new NormalEnemy ();
                                    enemies.add (enemy);
                                } else if (number == 1) {
                                    SmallerEnemy enemy = new SmallerEnemy ();
                                    enemies.add (enemy);
                                } else if (number == 2) {
                                    TankerEnemy enemy = new TankerEnemy ();
                                    enemies.add (enemy);
                                } else if (number == 3 && tick > 200 * 6) {
                                    Boss enemy = new Boss ();
                                    enemies.add (enemy);
                                }
                            }
                        }
                        // Update towers
                        for (int i = 0; i < towers.size (); i++) {
                            towers.get (i).update (gc2);
                            for (int j = enemies.size () - 1; j >= 0; j--) {
                                if (towers.get (i).getEnemy ().getHealth () <= 0) {
                                    if (towers.get (i).getCenter ().Distance (enemies.get (j).getCenter ()) <= towers.get (i).getRange ()) {
                                        towers.get (i).setEnemy (enemies.get (j));
                                    }
                                }
                            }
                        }
                        // Do effect
                        for (int i = 0; i < potions.size (); i++) {
                            potions.get (i).doEffect (gc2);
                            for (int j = enemies.size () - 1; j >= 0; j--) {
                                if (potions.get (i).getCenter ().Distance (enemies.get (j).getCenter ()) <= potions.get (i).getRange ()) {
                                    potions.get (i).addEnemy (enemies.get (j));
                                }
                            }
                            if (potions.get (i).getTickDown () <= 0) potions.remove (i);
                        }
                        // Update enemies

                        for (int i = 0; i < enemies.size (); i++) {
                            enemies.get (i).update (gc2);
                            if (enemies.get (i).getHealth () <= 0) {
                                player1.getReward ((int) enemies.get (i).getReward ());
                                enemies.remove (i);
                            }
                        }
                        for (int i = 0; i < enemies.size (); i++) {
                            if (enemies.get (i).getCounter () == 7) {
                                enemies.remove (i);
                                player1.getHurt (20);
                            }
                        }
                    }
                    if (stop) {
                    } else tick++;
                }
            }.start ();

        Canvas canvas3= new Canvas(Config.WIDTH,Config.HEIGHT);
        root3.getChildren().add(canvas3);
        GraphicsContext gc3= canvas3.getGraphicsContext2D();
        // draw end scene

        gc3.setFill(Color.BLACK);
        Font fontEnd= Font.font("Times New Roman", FontWeight.BOLD, 70);
        gc3.setFont(fontEnd );
        gc3.fillText(" YOU ARE BEEN DEFEATED! ",Config.SIZE*2+32,Config.SIZE*4+64);


        // add a button to go back menu


        Canvas canvas4= new Canvas(Config.WIDTH,Config.HEIGHT);
        root4.getChildren().add(canvas4);
        GraphicsContext gc4= canvas4.getGraphicsContext2D();
        gc4.drawImage(Config.win,0,0,Config.WIDTH,Config.HEIGHT);
        // draw end scene
        // add a button to go back menu
/*        Button backMenu = new Button(10*Config.SIZE,Config.SIZE*6,Config.SIZE*2,Config.playButton,gc4);
        win.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent){
                        if(backMenu.iscontain(mouseEvent.getX(),mouseEvent.getY())){
                            theStage.setScene(Menu);
                            System.out.println("True");
                        }
                    }
                }
        );
        root.toFront();

 */
    }
}