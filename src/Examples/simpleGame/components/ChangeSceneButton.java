package Examples.simpleGame.components;

import artemis.Vector2;
import artemis.game.Game;
import artemis.game.gui.Button;
import artemis.render.Scene;

public class ChangeSceneButton extends Button {
    public ChangeSceneButton(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size, onGlass);
    }

    @Override
    public void _process(double delta) {
        super._process(delta);
        if(this.clicked()) {
            this.game.switchScene(1);
        }
    }
}
