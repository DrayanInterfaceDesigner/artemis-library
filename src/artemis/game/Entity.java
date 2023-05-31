package artemis.game;

import artemis.Vector3;

import java.awt.*;

public abstract class Entity {
    private Vector3 position;
    private double[] size;
    public Entity() {}
    public abstract void render(Graphics2D ctx);
    public abstract void _physicsProcess(long delta);
    public abstract void _process(long delta);
}
