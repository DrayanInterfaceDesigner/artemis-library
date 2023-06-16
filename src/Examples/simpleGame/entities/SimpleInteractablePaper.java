package Examples.simpleGame.entities;

import Examples.simpleGame.components.TablePopup;
import Examples.simpleGame.utils.TxtManager;
import artemis.Vector2;
import artemis.controller.KeyControl;
import artemis.game.*;
import artemis.render.Scene;

import java.awt.*;
import java.io.Serializable;

public class SimpleInteractablePaper extends Body implements Serializable {
    private Sprite skin;
    private TablePopup popup;
    private KeyControl keyboard;
    private String txt;
    public SimpleInteractablePaper(Game game, Scene scene, Vector2 position, double[] size, TablePopup popup) {
        super(game, scene, position, size);
        this.skin = new Sprite(game, scene, this.center, size, new String[] {
                "src/Examples/simpleGame/assets/paper/keanedpaper.png",
                "src/Examples/simpleGame/assets/paper/openedpaper.png"
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
    }

    @Override
    public void render(Graphics2D ctx) {

    }
}
