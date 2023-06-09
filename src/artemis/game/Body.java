package artemis.game;

import artemis.Vector2;

import java.awt.*;

public abstract class Body extends Entity implements IEntity, IBody{

    public Body(Game game, Vector2 position, double[] size) {
        super(game, position, size);
    }

    @Override
    public void _physicsProcess(double delta) {
        this.center.x = this.position.x - this.size[0]/2;
        this.center.y = this.position.y - this.size[1]/2;
        if(this.collisionBox != null) {
            this.collisionBox.isColliding();
        }
    }

    @Override
    public void _process(double delta) {}

    @Override
    public void render(Graphics2D ctx) {}
}
