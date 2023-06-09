public class Test implements Runnable {
    private static final int FPS_TARGET = 120;

    private volatile boolean running;
    private Thread gameThread;
    private int heyOh = 0;

    private int frames;
    private long fpsTimer;

    public void run() {
        fpsTimer = System.currentTimeMillis();
        frames = 0;

        long previousTime = System.nanoTime();
        double nanoPerUpdate = 1000000000.0 / FPS_TARGET;
        double delta = 0;

        while (running) {
            long currentTime = System.nanoTime();
            delta += (currentTime - previousTime) / nanoPerUpdate;
            previousTime = currentTime;

            while (delta >= 1) {
                update(delta); // Update game logic
                delta--;
            }

            // FPS counter
            frames++;
            if (System.currentTimeMillis() - fpsTimer > 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                heyOh =0;
                fpsTimer = System.currentTimeMillis();
            }

            // FPS limiter
            long elapsedTime = System.nanoTime() - currentTime;
            long sleepTime = (1000000000L / FPS_TARGET) - elapsedTime;

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
        System.out.println("Speed: " + 60 * delta +"Heyoh: " + this.heyOh + "Delta: " + delta);
        heyOh++;
    }

    public synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }

        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test game = new Test();
        game.start();
    }
}
