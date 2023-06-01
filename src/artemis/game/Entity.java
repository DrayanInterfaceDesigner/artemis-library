package artemis.game;

import artemis.Vector3;

import java.awt.*;

public abstract class Entity implements IEntity{
    protected Game game;
    public Vector3 position;
    protected double[] size;
    public Entity(Game game, Vector3 position, double[] size) {
        this.game = game;
        this.position = position;
        this.size = size;
    }

    public void pushToGame() {
        this.game.add(this);
    }
    public void getReady() {
        this._onReady();
        this.pushToGame();
    }
    public abstract void _onReady();
    public abstract void _physicsProcess(long delta);
    public abstract void _process(long delta);
    public abstract void render(Graphics2D ctx);

}
