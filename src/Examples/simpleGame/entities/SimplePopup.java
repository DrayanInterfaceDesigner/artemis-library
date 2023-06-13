package Examples.simpleGame.entities;

import artemis.Vector2;
import artemis.game.Game;
import artemis.game.gui.Button;
import artemis.game.gui.Popup;
import artemis.game.gui.TextArea;
import artemis.render.Scene;

import java.io.Serializable;

public class SimplePopup extends Popup implements Serializable {
    public Button button;
    public TextArea text;
    public String windowTitle;
    public String textContent;
    public String buttonLabel;

    public SimplePopup(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass,
                      String windowTitle, String textContent, String buttonLabel) {
        super(game, scene, position, size, onGlass);
        this.windowTitle = windowTitle;
        this.textContent = textContent;
        this.buttonLabel = buttonLabel;
    }

    @Override
    public void setup() {
        super.setup();
        this.setLabel("Story");
        Button btn = new Button(
                this.game,this.scene ,new Vector2(-100,-100), new double[]{20, 100}, true
        );
        TextArea txt = new TextArea(
                this.game, this.scene, new Vector2(58, 58), new double[]{150,20}, true
        );

        this.button = btn;
        this.text = txt;
        txt.text = textContent;
        btn.label = buttonLabel;

        btn.getReady();
        txt.getReady();

        this.add(txt.getWrapper(), btn.getButton());
    }
}
