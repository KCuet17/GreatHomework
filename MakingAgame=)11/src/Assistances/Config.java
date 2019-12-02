package Assistances;

import javafx.scene.image.Image;

public class Config {
    public static final double WIDTH = 1280, HEIGHT = 704;

    public static final String GAME_NAME = "Tower Defense";

    public static final double SIZE = 64;
    public static double zoom=1;

    public static final int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 2, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 2, 2},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 2, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2}};

    public static final long NORMAL_BULLET_STRENGTH = 20;
    public static final double NORMAL_BULLET_SPEED = 3;

    public static final long MACHINE_GUN_BULLET_STRENGTH = 15;
    public static final double MACHINE_GUN_BULLET_SPEED = 3;

    public static final long SNIPER_BULLET_STRENGTH = 100;
    public static final double SNIPER_BULLET_SPEED = 5;

    public static final long NORMAL_TOWER_SPEED = 80;
    public static final double NORMAL_TOWER_RANGE = 3;
    public static final int NORMAL_TOWER_PRICE= 50;

    public static final long MACHINE_GUN_TOWER_SPEED = 15;
    public static final double MACHINE_GUN_TOWER_RANGE = 2;
    public static final int MACHINE_GUN_TOWER_PRICE= 200;

    public static final long SNIPER_TOWER_SPEED = 150;
    public static final double SNIPER_TOWER_RANGE = 4.2;
    public static final int SNIPER_TOWER_PRICE= 100;

    public static final double NORMAL_ENEMY_SIZE = 0.9;
    public static final long NORMAL_ENEMY_HEALTH = 100;
    public static final double NORMAL_ENEMY_SPEED = 0.55;
    public static final long NORMAL_ENEMY_REWARD = 50;

    public static final double SMALLER_ENEMY_SIZE = 0.7;
    public static final long SMALLER_ENEMY_HEALTH = 50;
    public static final double SMALLER_ENEMY_SPEED = 0.8;
    public static final long SMALLER_ENEMY_REWARD = 100;

    public static final double TANKER_ENEMY_SIZE = 1.1;
    public static final long TANKER_ENEMY_HEALTH = 300;
    public static final double TANKER_ENEMY_SPEED = 0.4;
    public static final long TANKER_ENEMY_REWARD = 150;

    public static final double BOSS_ENEMY_SIZE = 1.3;
    public static final long BOSS_ENEMY_HEALTH = 500;
    public static final double BOSS_ENEMY_SPEED = 0.6;
    public static final long BOSS_ENEMY_REWARD = 200;

    public static final Image road = new Image("road1.png");
    public static final Image mountain = new Image("mountain.png");
    public static final Image shop= new Image("shop.png");
    public static final Image background= new Image("mapTile_171.png");
    public static final Image normalEnemy= new Image("normal.png");
    public static final Image smallerEnemy= new Image("smaller.png");
    public static final Image tankerEnemy= new Image("tanker.png");
    public static final Image boss= new Image("Boss.png");
    public static final Image normalTower= new Image("normaltower2.png");
    public static final Image sniperTower= new Image("snipertower2.png");
    public static final Image machineGunTower= new Image("machineGunTower2.png");
    public static final Image normalBullet= new Image("normalBullet.png");
    public static final Image sniperBullet= new Image("green_circle.png");
    public static final Image machineGunBullet= new Image("machineGunBullet.png");


    // button images
    public static final Image buyNormal= new Image("buynormal.png");
    public static final Image buySniper= new Image("buysniper.png");
    public static final Image buyMachineGun= new Image("buymachinegun.png");
    public static final Image buySlowPotion= new Image("buyslowpotion.png");
    public static final Image buyBurningPotion= new Image("buyburningpotion.png");
    public static final Image playButton= new Image("playButton.png");
    public static final Image gameMap= new Image("mapGame.png");
    public static final Image menu= new Image("menu.png");
    public static final Image win= new Image("Win.png");
    public static final Image statusBar = new Image("statusbar.png");
    public static final Image gameStop= new Image("pause.png");
    public static final Image gameSkip= new Image("skip.png");


    //potion
    public static final double SLOW_POTION_RANGE= SIZE*2;
    public static final double SLOW_POTION_SPEED_REDUCE=0.7;
    public static final long SLOW_POTION_TICK=800;
    public static final int SLOW_POTION_PRICE=100;

    public static final double BURNING_POTION_RANGE= SIZE;
    public static final int BURNING_POTION_HEALTH_REDUCE=5;
    public static final long BURNING_POTION_TICK=600;
    public static final int BURNING_POTION_PRICE=200;

    //pause and skip
    public static double gameSpeed=1;
}
