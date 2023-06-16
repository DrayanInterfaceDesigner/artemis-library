package artemis.game.gui;

import artemis.Vector2;
import artemis.game.Game;
import artemis.render.Scene;

import java.awt.*;

public class GlassPane extends GUI{
    public GlassPane(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size, onGlass);
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
