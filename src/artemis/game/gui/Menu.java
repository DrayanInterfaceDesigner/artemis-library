package artemis.game.gui;

import artemis.Vector2;
import artemis.game.Game;
import artemis.render.Scene;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu extends GUI{
    protected JMenuBar menuBar;
    protected ArrayList<JComponent> components;
    protected ArrayList<JMenu> menus;
    public Menu(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size, onGlass);
        this.components = new ArrayList<>();
        this.menus = new ArrayList<>();
        this.game.getCamera().getCanvas().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a menu bar
        menuBar = new JMenuBar();
//        this.menuBar.setPreferredSize(new Dimension((int) this.size[0], (int) this.size[1]));

        // Set the menu bar on the frame
        this.game.getCamera().getCanvas().setJMenuBar(menuBar);

        this.game.getCamera().getCanvas().setVisible(true);
    }

    public void addComponent(JComponent... c) {
        for(JComponent comp : c) {
            this.menuBar.add(comp);
            this.menuBar.revalidate();
            this.menuBar.repaint();
        }
    }
    public void addDropdown(String title, int[] separateAt, MenuButton... items) {
        JMenu menu = new JMenu(title);
        if(items != null) {
            for(int x = 0; x < items.length; x++) {
                menu.add(items[x].getButton());
                components.add(items[x].getButton());
                if(separateAt != null) {
                    if(items.length > 1 && x < items.length-1) {
                        for(int y = 0; y < separateAt.length; y++) {
                            if(x == separateAt[y]) {
                                menu.addSeparator();
                            }
                        }
                    }
                }
            }
        }
        this.menus.add(menu);
        this.menuBar.add(menu);
        this.menuBar.revalidate();
        this.menuBar.repaint();
    }

    public void addOptionToDropdown() {}

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
