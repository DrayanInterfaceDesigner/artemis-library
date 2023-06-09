package artemis.schedule;

public class Timer {
    private long timeRun = 0;
    private long currentTime = -1;
    private long delta = -1;
    private double timeStep = 1000;


    public Timer(double timeStep){
        this.timeStep = timeStep;
    }

    public long start(){
        return 0;
    }
    public long stop() {
        return -1;
    }
    public long now() {
        this.currentTime = System.currentTimeMillis();
        return this.currentTime;
    }
    public long preciseNow() {
        return System.nanoTime();
    }
}
