package artemis.game.gui;

import artemis.Vector2;
import artemis.game.Game;
import artemis.render.Scene;

import javax.swing.*;
import java.awt.*;

public class InlineText extends GUI {
    public String text;
    private JLabel inlineText;
    public InlineText(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size, onGlass);
        this.text = "";
        this.inlineText = new JLabel();
        this.onGlass = onGlass;
        if(onGlass) {
            this.game.getCamera().getGlassPane().add(this.inlineText);
        }
    }

    @Override
    public void _onReady() {
        this.inlineText.setBounds(
                (int) this.position.x,
                (int) this.position.y,
                (int) this.size[0],
                (int) this.size[1]
        );
        this.inlineText.setText(this.text);
    }
    public void setText(String text) {
        this.text = text;
        this.inlineText.setText(this.text);
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
        if(!onGlass) {
            this.inlineText.paint(ctx);
        }
    }

    public JLabel getTextComponent() {
        return this.inlineText;
    }
}
