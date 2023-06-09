package artemis.game;

import java.awt.*;

public interface IEntity {
    public abstract void render(Graphics2D ctx);
    public abstract void _physicsProcess(double delta);
    public abstract void _process(double delta);
    public abstract void _onReady();
    public abstract boolean isOnScreen();
    public abstract void pushToGame();
    public abstract void getReady();
}
