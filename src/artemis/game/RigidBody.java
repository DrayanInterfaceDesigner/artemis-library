package artemis.game;

import artemis.Vector2;
import artemis.arithmetic.ArtemisMath;
import artemis.render.Scene;

import java.awt.*;

public class RigidBody extends Body implements IEntity, IBody{
    public boolean isHighlyReactive = false;
    public RigidBody(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
    }


    protected void resolveCollision(Entity other) {
        if(!isHighlyReactive) {
            double overlapX = Math.abs(this.position.x - other.position.x) - (this.size[0] + other.size[0]) / 2;
            double overlapY = Math.abs(this.position.y - other.position.y) - (this.size[1] + other.size[1]) / 2;

            if (overlapX < 0 && overlapY < 0) {
                double displacementX = Math.min(Math.abs(overlapX), Math.abs(overlapY)) * Math.signum(
                        this.position.x - other.position.x);
                double displacementY = Math.min(Math.abs(overlapX), Math.abs(overlapY)) * Math.signum(
                        this.position.y - other.position.y);

                this.position.x += displacementX;
                this.position.y += displacementY;
            }
        }
    }
    @Override
    public boolean isOnScreen() {
        return false;
    }
    @Override
    public void _physicsProcess(double delta) {
        super._physicsProcess(delta);
        if(this.collisionBox != null) {
            if(this.collisionBox.isColliding()) {
                for(Entity e : this.collisionBox.collidingWith) {
                    this.resolveCollision(e);
                }
            }
        }
    }
    @Override
    public void _onReady() {

    }
    @Override
    public void _process(double delta) {
        super._process(delta);
    }
    @Override
    public void render(Graphics2D ctx) {
        super.render(ctx);
    }
}

