package artemis.game;

import java.awt.*;

public interface IEntity {
    public abstract void render(Graphics2D ctx);
    public abstract void _physicsProcess(long delta);
    public abstract void _process(long delta);
    public abstract boolean isOnScreen();
}
