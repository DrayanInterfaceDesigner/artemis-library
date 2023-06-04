package artemis.game;

import artemis.Vector3;

import java.awt.*;

public class KinematicBody extends Body implements IEntity, IBody{

    public KinematicBody(Game game, Vector3 position, double[] size) {
        super(game, position, size);
    }

    public void sayHi() {
//        System.out.println("Say hi!!!" + this.size);
    }

    @Override
    public boolean isOnScreen() {
        return false;
    }

    @Override
    public void setHitBox(CollisionBox hitbox) {
        super.setHitBox(hitbox);
    }

    @Override
    public CollisionBox getHitBox() {
        return super.getHitBox();
    }

    @Override
    public void _onReady() {}
    @Override
    public void _physicsProcess(long delta) {
        super._physicsProcess(delta);
        this.sayHi();
    }

    @Override
    public void _process(long delta) {
        super._process(delta);
        this.sayHi();
    }

    @Override
    public void render(Graphics2D ctx) {
        super.render(ctx);
    }
}

