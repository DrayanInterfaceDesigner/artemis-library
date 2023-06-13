package Examples.simpleGame.components;

import artemis.Vector2;
import artemis.game.Game;
import artemis.game.gui.Button;
import artemis.game.gui.Popup;
import artemis.game.gui.TextArea;
import artemis.render.Scene;

public class StoryPopup extends Popup {
    public StoryPopup(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size, onGlass);
    }

    @Override
    public void setup() {
        super.setup();
        this.setLabel("Story");
        ChangeSceneButton btn = new ChangeSceneButton(
                this.game,this.scene ,new Vector2(-100,-100), new double[]{20, 100}, true
        );
        TextArea txt = new TextArea(
                this.game, this.scene, new Vector2(58, 58), new double[]{150,300}, true
        );

        btn.label = "Next Phase";
        txt.text = "AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH AOOOOOOOHHHH ";

        btn.getReady();
        txt.getReady();

        this.add(btn.getButton(), txt.getWrapper());
    }
}
