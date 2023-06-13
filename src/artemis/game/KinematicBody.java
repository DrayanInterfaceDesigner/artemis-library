package artemis.game;

import artemis.Vector2;
import artemis.render.Scene;

import java.awt.*;

public class KinematicBody extends Body implements IEntity, IBody{

    public KinematicBody(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
    }

    public void sayHi() {
//        System.out.println("Say hi!!!" + this.size);
    }

    @Override
    public boolean isOnScreen() {
        return false;
    }


    @Override
    public void _onReady() {}
    @Override
    public void _physicsProcess(double delta) {
        super._physicsProcess(delta);
        this.sayHi();
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

