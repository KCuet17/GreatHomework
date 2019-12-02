package sample;

public class Player {
    private long money;
    private int health;

    public Player(){
        this.money=200;
        this.health=100;
    }
    public Player(long t){
        this.money=t;
        this.health=100;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void getHurt(int t){
        this.health-=t;
    }
    public void getReward(int t){
        this.money+=t;
    }
    public void pay(int t){
        this.money-=t;
    }
}
