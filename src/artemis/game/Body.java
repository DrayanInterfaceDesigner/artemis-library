package artemis.game;

import artemis.Vector2;
import artemis.render.Scene;

import java.awt.*;

public abstract class Body extends Entity implements IEntity, IBody{
    private CollisionBox floorRay;
    public Body(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
        this.floorRay = new CollisionBox(game, scene, position, size, this);
    }
    private void setupFloorDetection() {
        double[] size = {1, 500};
        this.floorRay.position = position;
        this.floorRay.size = size;
//        this.floorRay = new CollisionBox(game,  position, size, new Grid(), this);
//        this.children.add(this.floorRay);
        this.floorRay.getReady();
    }

    @Override
    public void getReady() {
        setupFloorDetection();
        super.getReady();
    }

    public boolean isOnFloor() {
        if(this.floorRay.isColliding()) {
            double yHigher = 0;
            for(Entity e : this.floorRay.collidingWith) {
                double eY = e.position.y - e.size[1]/2;
                if(eY < yHigher) {
                    yHigher = eY;
                }
            }
            return (this.center.y + this.size[1]) >= yHigher;
        }
        return false;
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
