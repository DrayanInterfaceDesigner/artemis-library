package artemis.game;

import artemis.Vector3;

import java.awt.*;

public abstract class Body extends Entity implements IEntity, IBody{
    protected CollisionBox hitbox;

    public Body(Game game, Vector3 position, double[] size) {
        super(game, position, size);
    }

    public void setHitBox(CollisionBox hitbox) {
        this.hitbox = hitbox;
    }
    public CollisionBox getHitBox(){
        return this.hitbox;
    }

    @Override
    public void _physicsProcess(long delta) {}

    @Override
    public void _process(long delta) {}

    @Override
    public void render(Graphics2D ctx) {}
}
