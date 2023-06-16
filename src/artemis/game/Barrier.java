package artemis.game;

import artemis.Vector2;
import artemis.render.Scene;

public class Barrier extends RigidBody{

    public Barrier(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
    }

    @Override
    protected void resolveCollision(Entity other) {
        if(!isHighlyReactive) {
            double overlapX = Math.abs(this.position.x - other.position.x) - (this.size[0] + other.size[0]) / 2;
            double overlapY = Math.abs(this.position.y - other.position.y) - (this.size[1] + other.size[1]) / 2;

            if (overlapX < 0 && overlapY < 0) {
                double displacementX = Math.min(Math.abs(overlapX), Math.abs(overlapY)) * Math.signum(
                        this.position.x - other.position.x);
                double displacementY = Math.min(Math.abs(overlapX), Math.abs(overlapY)) * Math.signum(
                        this.position.y - other.position.y);

                this.position.x -= displacementX;
                this.position.y -= displacementY;
            }
        }
    }
}
