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

    private ArrayList<Entity> entities;
    private ArrayList<JPanel> layers;

    public Canvas (int windowSize[]) {
        this.canvas = new JFrame();
        this.container = this.canvas.getContentPane();
        this.windowSize = windowSize;
        this.entities = new ArrayList<>();

        this.canvas.setSize(this.windowSize[0], this.windowSize[1]);
        this.canvas.setVisible(true);
        this.container.setLayout(new BorderLayout());

        this.context = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D ctx = (Graphics2D) g;
                for (Entity e : entities) {
                    e.render(ctx);
                }
            }
        };

        this.container.add(this.context, BorderLayout.CENTER);
        this.canvas.setSize(600, 600);
        this.canvas.setVisible(true);
    }

    public void render(Entity... entities) {
        for(Entity e : entities) {
            System.out.println("Canvas yea");
            if(!this.entities.contains(e)){
                this.entities.add(e);
            }
            System.out.println(this.entities.size());
        }
        this.canvas.repaint();

//        this.entities.clear();
//        this.context = new JPanel() {
//            public void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                Graphics2D ctx = (Graphics2D) g;
//                for(Entity e : entities) {
//                    e.render(ctx);
//                }
//
//            }
//        };
//        this.container.add(this.context, BorderLayout.CENTER);
//        this.canvas.setSize(600, 600);
//        this.canvas.setVisible(true);
    }
}
