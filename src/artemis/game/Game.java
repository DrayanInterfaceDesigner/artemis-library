package artemis.game;

import artemis.schedule.Queue;
import artemis.schedule.Timer;
import artemis.render.Canvas;

import java.util.ArrayList;

public class Game {
    private Timer timer;
    private long time;
    private int targetFPS;
    private long timeSleep;
    private long frameDelay;
    private long delta;
    private double timeScale;
    private Queue queue;
    private Canvas canvas;
    private int[] windowSize = {560, 440};
    private ArrayList<Entity> entities;

    public Game(int targetFPS){
        this.canvas = new Canvas(this.windowSize);
        this.queue = new Queue(this, this.canvas);
        this.timer = new Timer(1);
        this.targetFPS = targetFPS;
        this.frameDelay = Math.round(1000.0 / this.targetFPS);
    }
    public void run(){
        while(true) {
            this.time = this.timer.now();

            this.canvas.windowSize = this.windowSize;
            this.queue.fill(this.entities);
            this.queue.execute();

            System.out.println("Time: " + this.time);

            this.delta = this.timer.now() - this.time;
            this.timeSleep = this.frameDelay - this.delta;

            if(this.timeSleep > 0) {
                try {
                    Thread.sleep(this.timeSleep);
                } catch(InterruptedException error) {
                    error.printStackTrace();
                }
            }

        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public long getDelta() {
        return delta;
    }

}
