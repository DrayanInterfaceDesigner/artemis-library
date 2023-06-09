package artemis.render;

import artemis.Vector2;
import artemis.game.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Camera {
    private JFrame canvas;
    private Container container;
    private JPanel glassPane;
    public int windowSize[];
    private JPanel context;
    private ArrayList<Entity> entities;
    private Vector2 position;
    private ArrayList<JPanel> layers;

    public Camera(int windowSize[]) {
        this.canvas = new JFrame();
        this.glassPane = new JPanel();
        this.container = this.canvas.getContentPane();
        this.windowSize = windowSize;
        this.entities = new ArrayList<>();
        this.position = new Vector2(0,0);

        this.glassPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.canvas.setSize(this.windowSize[0], this.windowSize[1]);
        this.canvas.setVisible(true);
        this.container.setLayout(new BorderLayout());

        this.glassPane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                canvas.requestFocus();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                canvas.requestFocus();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.context = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.translate((int)context.getWidth() / 2, (int)context.getHeight() /2);
                Graphics2D ctx = (Graphics2D) g;
                applyTranslation(ctx);
//                System.out.println(entities.size());
                for (Entity e : entities) {
                    e.render(ctx);
                }
            }
        };

        this.container.add(this.context, BorderLayout.CENTER);
        this.canvas.setGlassPane(this.glassPane);
        this.canvas.setSize(600, 600);
        this.canvas.setVisible(true);
    }

    public void render(Entity... entities) {
        for(Entity e : entities) {
            if(e.isHidden()) {
                System.out.println("is hidden");
            }
//            System.out.println("Canvas yea");
            e.setCameraPosition(this.position);
            if(!this.entities.contains(e)){

                this.entities.add(e);
            }
//            System.out.println(this.entities.size());
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

    public void applyTranslation(Graphics2D ctx) {
        if(this.position != null) {
            ctx.translate(-this.position.x, -this.position.y);
        }
    }
    public void follow(Entity entity) {
        this.position.x = entity.position.x;
        this.position.y = entity.position.y;
    }
    public JFrame getCanvas() {
        return canvas;
    }
    public Vector2 getPosition () {
        return this.position;
    }
    public ArrayList<Entity> getEntities() {return this.entities;}
    public JPanel getGlassPane() {
        return glassPane;
    }

    public Container getContainer() {
        return container;
    }

    public JPanel getContext() {
        return context;
    }
}
