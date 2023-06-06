package artemis.game;

import artemis.render.Camera;
import artemis.schedule.Queue;
import artemis.schedule.Timer;

import java.util.ArrayList;

public class Game {
    private Timer timer;
    private long time;
    private int targetFPS;
    private long timeSleep;
    private long delta;
    private double timeScale;
    private Queue queue;
    private Camera camera;
    private long previousTime = 0;
    private long updateRate;
    private int[] windowSize = {560, 440};
    private ArrayList<Entity> entities;

    public Game(int targetFPS){
        this.camera = new Camera(this.windowSize);
        this.queue = new Queue(this, this.camera);
        this.entities = new ArrayList<Entity>();
        this.timer = new Timer(1);
        this.targetFPS = targetFPS;
        this.updateRate = 1000/this.targetFPS;
    }
    public void run(){
        this.entities = this.flatEntities();
        for(Entity e : entities) {
            System.out.println(e);
        }
        while(true) {
            this.time = this.timer.now();
            this.delta = (long) ((this.time - this.previousTime));
//            if((this.delta/1000) < this.updateRate) return;

            this.previousTime = this.time;

//            System.out.println(this.entities);
//            this.time = this.timer.now();
            this.camera.windowSize = this.windowSize;
            this.queue.fill(this.entities);
            this.queue.execute((long) this.delta);

//            System.out.println("Time: " + this.delta);

            this.delta = this.timer.now() - this.time;
            this.timeSleep = this.updateRate - this.delta;

            if(this.timeSleep > 0) {
                try {
                    Thread.sleep(this.timeSleep);
                } catch(InterruptedException error) {
                    error.printStackTrace();
                }
            }

        }
    }

    public int[] getWindowSize(){
        return this.windowSize;
    }
    public Camera getCamera() {
        return camera;
    }

    public long getDelta() {
        return delta;
    }

    public void add(Entity e) {
        if(!this.entities.contains(e)) {
            this.entities.add(e);
        }
    }
    public void destroy(Entity e) {
        if(this.entities.contains(e)) {
            System.out.println("destroy: " + e + "\n");
            this.entities.remove(e);
            for(Entity i : entities) {
                System.out.println(i);
            }
        }
    }
    public ArrayList<Entity> getEntities() {
        return this.entities;
    }

    public ArrayList<Entity> flatEntities(){
        ArrayList<Entity> flattened = new ArrayList<>();
        for(Entity e : this.entities) {
            flattened.add(e);
            if(e.getChildren() != null) {
                for(Entity child : e.getChildren()) {
                    flattened.add(child);
                }
            }
        }
        return flattened;
    }

}
