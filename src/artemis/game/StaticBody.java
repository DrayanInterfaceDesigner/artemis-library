package artemis.game;

import artemis.Vector2;

import java.awt.*;

public class StaticBody extends Body implements IEntity, IBody{

    public StaticBody(Game game, Vector2 position, double[] size) {
        super(game, position, size);
        this.collisionBox = new CollisionBox(
                game, this.center, size, new Grid(), this
        );
    }

    public void sayHi() {
//        System.out.println("Say hi!!!" + this.size);
    }

    void resolveCollision(Entity other) {

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
    @Override
    public boolean isOnScreen() {
        return false;
    }

    @Override
    public void _onReady() {}

//    private void resolveCollision()
    @Override
    public void _physicsProcess(double delta) {
        super._physicsProcess(delta);
        if(this.collisionBox.isColliding()) {
            for(Entity e : this.collisionBox.collidingWith) {
                this.resolveCollision(e);
            }
        }
    }
    @Override
    public void _process(double delta) {
        super._process(delta);
        this.sayHi();
    }
    @Override
    public void render(Graphics2D ctx) {
        super.render(ctx);
    }
}


// e.position.x = lastx;

//                double sx = this.position.x + this.size[0];
//                double sy = this.position.y + this.size[1];
//
//                double bx = e.position.x + e.size[0];
//                double by = e.position.y + e.size[1];
//
//                double ovx = Math.max(this.position.x, e.position.x) - Math.min(this.position.x, e.position.x);
//                double ovy = Math.max(this.position.y, e.position.y) - Math.min(this.position.y, e.position.y);

//                e.position.x -= e.size[0] - ovx;
//                e.position.x += this.size[0] - ovx;
//                e.position.y -= e.size[1] - ovy;
//                e.position.y += this.size[1] - ovy;

//                if(ovy > 0) {
//                    e.position.y -= e.size[1] - ovy;
//                }
//                if(ovx > 0) {
//                    e.position.x -= e.size[0] - ovx;
//                }
//                else {
//                    e.position.x += this.size[0] - ovx;
//                }
//                System.out.println("-----------");
//                System.out.println(this.position.x + this.size[0] + "/" + e.position.x + e.size[0]);
//                System.out.println(this.position.y + this.size[1] + "/" + e.position.y + e.size[1]);
//                System.out.println("+---------+");
//                System.out.println(ovx + "/" + ovy);
//                System.out.println("-----------");

//                e.position.y = e.position.y - ovy;
//                e.position.x = this.position.x - this.size[0];
//                e.position.y -= ovx;

