package Examples.simpleGame.entities;

import artemis.Vector2;
import artemis.game.Body;
import artemis.game.Entity;
import artemis.game.Game;
import artemis.game.RigidBody;
import artemis.render.Scene;

import java.awt.*;
import java.io.Serializable;

public class SimpleWeapon extends Body implements Serializable {

    public SimpleWeapon(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
    }

    @Override
    public void _onReady() {

    }

    @Override
    public boolean isOnScreen() {
        return false;
    }

    @Override
    public void _physicsProcess(double delta) {

    }

    @Override
    public void _process(double delta) {

    }

    @Override
    public void render(Graphics2D ctx) {

    }
}
