package artemis.game.gui;

import artemis.Vector2;
import artemis.game.Game;
import artemis.render.Scene;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;

public class TextArea extends GUI{
    private JScrollPane wrapper;
    private JTextArea textArea;
    public String text;
    private Color color;
    public TextArea(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size, onGlass);
        this.textArea = new JTextArea();
        this.wrapper = new JScrollPane(this.textArea);

        this.color = Color.BLACK;
        wrapper.setBackground(new Color(0,0,0,0));
        wrapper.setVisible(true);
        if(onGlass) {
            this.game.getCamera().getGlassPane().add(this.wrapper);
        }
    }

    @Override
    public void _onReady() {
        this.textArea.setForeground(this.color); // Set the text color
        this.textArea.setBackground(new Color(0, 0, 0, 0));
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
        this.textArea.setEditable(false);
//        this.textArea.setPreferredSize(new Dimension((int)this.size[0], (int)this.size[1]));
        this.textArea.setText(text);

        this.wrapper.setPreferredSize(new Dimension((int)this.size[0], (int)this.size[1]));
        this.wrapper.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.wrapper.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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

    }

    public JScrollPane getWrapper() {
        return wrapper;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setColor(Color color) {
        this.color = color;
        this.textArea.setForeground(this.color);
    }
}
