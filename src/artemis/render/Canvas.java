package artemis.render;

import artemis.game.Entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas {
    private JFrame canvas;
    private Container container;
    public int windowSize[];
    private JPanel context;
    private ArrayList<JPanel> layers;

    public Canvas (int windowSize[]) {
        this.canvas = new JFrame();
        this.container = this.canvas.getContentPane();
        this.windowSize = windowSize;

        this.canvas.setSize(this.windowSize[0], this.windowSize[1]);
        this.canvas.setVisible(true);
        this.container.setLayout(new BorderLayout());
    }

    public void render(Entity... entities) {
        for(Entity e : entities) {
            System.out.println("Canvas yea");
        }
        this.context = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D ctx = (Graphics2D) g;
                for(Entity e : entities) {
                    e.render(ctx);
                }
            }
        };
        this.container.add(this.context, BorderLayout.CENTER);
    }
}
