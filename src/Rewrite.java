import artemis.game.Entity;
import artemis.render.Camera;
import artemis.schedule.Queue;
import artemis.schedule.Timer;

import java.util.ArrayList;

public class Rewrite implements Runnable{
    private final int TARGET_FPS;
    private int currentFPS;
    private long currentTime;
    private long lastTime;
    private long FPSCountTimer;
    private double nanoPerUpdate;
    private double timeScale;
    private double delta;
    private volatile boolean running;
    private Thread MAIN_THREAD;
    public Timer timer;
    private Queue queue;
    private Camera camera;
    private int[] windowSize = {560, 440};
    private ArrayList<Entity> entities;


    private int heyOh = 0;
    public Rewrite(int targetFps) {
        this.camera = new Camera(this.windowSize);
//        this.queue = new Queue(this, this.camera);
        this.entities = new ArrayList<Entity>();
        this.TARGET_FPS = targetFps;
        this.timer = new Timer(1);
        this.currentFPS = 0;
        this.nanoPerUpdate = 1000000000.0 / TARGET_FPS;
    }
    public void run() {
//      Setting Timers and Delta
        this.FPSCountTimer = System.currentTimeMillis();
        this.lastTime = System.nanoTime();

        while (running) {
//          Resets timers and calculate delta
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / nanoPerUpdate;
            lastTime = currentTime;

//          Updating Artemis
            while (delta >= 1) {
                update(delta);
                delta--;
            }

//          Updating current FPS
            currentFPS++;
            if (System.currentTimeMillis() - FPSCountTimer > 1000) {
                System.out.println("FPS: " + currentFPS);
                currentFPS = 0;
                heyOh =0;
                FPSCountTimer = System.currentTimeMillis();
            }

            // FPS Limiter
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
    private void update(double delta) {
//        this.camera.windowSize = this.windowSize;
//        this.queue.fill(this.entities);
//        this.queue.execute((long) this.delta);
        System.out.println("Speed: " + 60 * delta +"Heyoh: " + this.heyOh + "Delta: " + delta);
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
    public Camera getCamera() {
        return camera;
    }
//    public long getDelta() {
//        return delta;
//    }
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

    public static void main(String[] args) {
        Rewrite game = new Rewrite(60);
        game.start();
    }
}
