package artemis.game;

import artemis.Vector3;

import java.awt.*;

public class CollisionBox extends Entity implements IEntity{
    public CollisionBox(Game game, Vector3 position, double[] size) {
        super(game, position, size);
    }

    @Override
    public void _onReady() {}

    @Override
    public void _physicsProcess(long delta) {

    }
    @Override
    public void _process(long delta) {

    }
    @Override
    public boolean isOnScreen() {
        return false;
    }

    @Override
    public void render(Graphics2D ctx) {

    }
}
