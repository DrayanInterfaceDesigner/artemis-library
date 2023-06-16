package artemis.game.gui;

import artemis.Vector2;
import artemis.game.Game;
import artemis.game.Sprite;
import artemis.render.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends GUI{
    public String label;
    private Sprite _backgroundImage;
    private JMenuItem button;
    private boolean hasClicked;
    private boolean isPressed;
    private boolean hasReleased;
    private boolean hasEntered;
    private boolean hasExited;

    public MenuButton(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size, onGlass);
        this.label = "";
        this.onGlass = onGlass;
        this.button = new JMenuItem(this.label);
        if (onGlass) {
            this.game.getCamera().getGlassPane().add(this.button);
        }
    }

    public void backgroundImage(Sprite image) {
    }

    @Override
    public void _onReady() {
        button.setBounds(
                (int) this.position.x,
                (int) this.position.y,
                (int) this.size[0],
                (int) this.size[1]
        );
        this.button.setText(this.label);
        this.setEvents();
    }

    public void setText(String text) {
        this.label = text;
        this.button.setText(this.label);
    }

    public boolean clicked() {
        boolean res = this.hasClicked;
        this.hasClicked = false;
        return res;
    }

    public boolean pressed() {
        return this.isPressed;
    }

    public boolean released() {
        return this.hasReleased;
    }

    public boolean mouseEntered() {
        return this.hasEntered;
    }

    public boolean mouseExited() {
        return this.hasExited;
    }

    public void deleteButton() {
        this.scene.getEntities().remove(this);
        this.game.getCamera().getGlassPane().remove(this.button);
    }

    private void setEvents() {
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasClicked = true;
            }
        });

        this.button.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                hasReleased = false;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                hasReleased = true;
                isPressed = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hasEntered = true;
                hasExited = false;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hasExited = true;
                hasEntered = false;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
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
//        if (this.clicked()) {
//            System.out.println("Button clicked");
//        }
    }

    @Override
    public void render(Graphics2D ctx) {
        super.render(ctx);
        if(!onGlass) {
            this.button.paint(ctx);
        }
    }

    public JMenuItem getButton() {
        return button;
    }
}
