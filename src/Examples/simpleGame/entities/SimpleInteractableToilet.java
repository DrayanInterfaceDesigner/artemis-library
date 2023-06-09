package Examples.simpleGame.entities;

import Examples.simpleGame.utils.TxtManager;
import artemis.Vector2;
import artemis.controller.KeyControl;
import artemis.game.Body;
import artemis.game.CollisionBox;
import artemis.game.Game;
import artemis.game.Sprite;
import artemis.render.Scene;

import java.awt.*;
import java.io.Serializable;

public class SimpleInteractableToilet extends Body implements Serializable {
    private Sprite skin;
    private SimplePopup popup;
    private KeyControl keyboard;
    private String txt;
    public SimpleInteractableToilet(Game game, Scene scene, Vector2 position, double[] size, SimplePopup popup) {
        super(game, scene, position, size);
        this.skin = new Sprite(game, scene, this.center, size, new String[] {
                "src/Examples/simpleGame/assets/toilet/toilet.png",
                "src/Examples/simpleGame/assets/toilet/toilet_2.png"
        });
        this.collisionBox = new CollisionBox(game, scene, this.center, size, this);
        this.popup = popup;
        this.keyboard = new KeyControl(game);

        TxtManager txt = new TxtManager("src/Examples/simpleGame/persistent/poudialog.txt");
        txt.read();
        this.txt = txt.getContent();
    }

    @Override
    public void _onReady() {
        this.skin.getReady();
        this.collisionBox.getReady();
        this.keyboard.registerKey('e');
    }

    @Override
    public boolean isOnScreen() {
        return false;
    }

    @Override
    public void _physicsProcess(double delta) {
        if(this.collisionBox.isColliding()) {
            if(this.keyboard.isKeyPressed('e')) {
                this.skin.currentFrame = 1;
                this.popup.setVisibility(true);
            }
        }
    }

    @Override
    public void _process(double delta) {
        if(this.popup.button.clicked()) {
            this.popup.text.getTextArea().setText(txt);
        }
    }

    @Override
    public void render(Graphics2D ctx) {

    }
}
