package artemis.game.gui;

import artemis.Vector2;
import artemis.game.Entity;
import artemis.game.Game;
import artemis.render.Scene;

import java.awt.*;

public abstract class GUI extends Entity {
    private String _fontFamily;
    protected boolean onGlass;
    public GUI(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size);
    }
    public void fontFamily(String name) {

    }

    @Override
    public void render(Graphics2D ctx) {
        if(isHidden()) return;
    }
}
