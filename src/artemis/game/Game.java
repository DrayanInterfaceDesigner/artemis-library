package artemis.game;

import artemis.game.Entity;
import artemis.render.Camera;
import artemis.render.Scene;
import artemis.schedule.Queue;
import artemis.schedule.Timer;

import java.util.ArrayList;

public class Game implements Runnable{
    private final int TARGET_FPS;
    private int currentFPS;
    private long currentTime;
    private long lastTime;
    private long FPSCountTimer;
    private double nanoPerUpdate;
    private double timeScale;
    private double delta;
    private volatile boolean running;
    private boolean debug;
    private Thread MAIN_THREAD;
    private Timer timer;
    private Queue queue;
    private Camera camera;
    private int[] windowSize = {560, 440};
    public int activeScene = 0;
    private ArrayList<Entity> entities;
    private ArrayList<Scene> scenes;
    private Grid collisionGrid;


    private int heyOh = 0;

    public Game(int targetFPS){
        this.camera = new Camera(this.windowSize);
        this.queue = new Queue(this, this.camera);
        this.entities = new ArrayList<Entity>();
        this.scenes = new ArrayList<>();
        this.collisionGrid = new Grid(
                windowSize,
                new int[]{windowSize[0] * 2, windowSize[1] *2},
                3
        );
        this.timer = new Timer(1);
        this.timeScale = 1;

        this.TARGET_FPS = targetFPS;
        this.currentFPS = 0;
        this.nanoPerUpdate = 1000000000.0 / TARGET_FPS;
    }
    public void run(){
        this.switchScene(1);
        this.entities = this.flatEntities();
        for(Entity e : entities) {
            System.out.println(e);
        }

//      Setting Timers and Delta
        this.FPSCountTimer = System.currentTimeMillis();
        this.lastTime = System.nanoTime();

        while(running) {
//          Resets timers and calculate delta
            long currentTime = System.nanoTime();
            this.delta += (currentTime - lastTime) / (nanoPerUpdate * timeScale);
            lastTime = currentTime;

//          Updating Artemis
            while (this.delta >= 1) {
                update(this.delta);
                this.delta--;
            }

//          Updating current FPS
            currentFPS++;
            if (System.currentTimeMillis() - FPSCountTimer > 1000) {
                System.out.println("FPS: " + currentFPS);
                currentFPS = 0;
                heyOh =0;
                FPSCountTimer = System.currentTimeMillis();
            }

//          FPS Limiter
            long elapsedTime = System.nanoTime() - currentTime;
            long sleepTime = (1000000000L / TARGET_FPS) - elapsedTime;

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime / 1000000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void switchScene(int index) {
        System.out.println("switched to: " + index);
        this.camera.getEntities().clear();
        this.entities = this.scenes.get(index-1).getEntities();
        this.flatEntities();
    }
    private void update(double delta) {
        this.camera.windowSize = this.windowSize;
        this.queue.fill(this.entities);
        this.queue.execute(delta/100);
//        System.out.println("Speed: " + 60 * delta +"Heyoh: " + this.heyOh + "Delta: " + delta + "/" + this.delta);
        heyOh++;
    }
    public synchronized void start(){
        if (this.running) {
            return;
        }

        this.running = true;
        this.MAIN_THREAD = new Thread(this);
        this.MAIN_THREAD.start();
    }
    public synchronized void stop() {
        if (!this.running) {
            return;
        }

        running = false;
        try {
            this.MAIN_THREAD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int[] getWindowSize(){
        return this.windowSize;
    }

    public void setWindowSize(int[] windowSize) {
        this.windowSize = windowSize;
        this.camera.getCanvas().setSize(this.windowSize[0], this.windowSize[1]);
    }

    public Camera getCamera() {
        return camera;
    }

    public double getDelta() {
        return delta;
    }

    public void add(Entity e) {
        if(!this.entities.contains(e)) {
            this.entities.add(e);
        }
    }
    public void addScene(Scene s) {
        if(!this.scenes.contains(s)) {
            this.scenes.add(s);
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

    public Grid getGrid() {
        return this.collisionGrid;
    }

}
