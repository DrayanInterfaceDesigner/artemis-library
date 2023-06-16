package Examples.simpleGame.entities;

import artemis.Vector2;
import artemis.game.CollisionBox;
import artemis.game.Game;
import artemis.game.RigidBody;
import artemis.game.Sprite;
import artemis.render.Scene;

import java.awt.*;
import java.io.Serializable;

public class SimpleManoelGomes extends RigidBody implements Serializable {
    private Sprite skin;
    public SimpleManoelGomes(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
        this.skin = new Sprite(game, scene, this.center, size, new String[] {
                "src/Examples/simpleGame/assets/manoel/manoel.jpg",
        });
        this.collisionBox = new CollisionBox(game, scene, this.position, size, this);

    }

    @Override
    public void _onReady() {
        super._onReady();
    }

    @Override
    public void getReady() {
        super.getReady();
        this.skin.getReady();
    }

    @Override
    public void _physicsProcess(double delta) {
        super._physicsProcess(delta);
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
