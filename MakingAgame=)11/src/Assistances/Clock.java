package Assistances;

public class Clock {
    private boolean pause;
    private float lastFrame,totalTime;
    private float d;

    public float getTime(){
        return System.currentTimeMillis();
    }
    public float getD(){
        return System.currentTimeMillis()-lastFrame;
    }
    public void update(){
        this.d=this.getD();
        this.lastFrame=System.currentTimeMillis();
        this.totalTime+=d;
    }

}
