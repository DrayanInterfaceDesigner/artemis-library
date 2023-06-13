package Examples.simpleGame.entities;

import artemis.Vector2;
import artemis.game.Entity;
import artemis.game.Game;
import artemis.game.Sprite;
import artemis.render.Scene;

import java.awt.*;
import java.io.Serializable;

public class SimpleBackground extends Sprite implements Serializable {

    public SimpleBackground(Game game, Scene scene, Vector2 position, double[] size, String[] frames) {
        super(game, scene, position, size, frames);
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
        super.render(ctx);
    }
}
