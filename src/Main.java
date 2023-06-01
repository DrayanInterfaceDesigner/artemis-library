import artemis.Vector3;
import artemis.game.StaticBody;
import artemis.primitives.Quad;
import artemis.primitives.Tri;
import artemis.primitives.Vertex;
import artemis.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class Main {
    public static void main(String[] args) {
//        TODO:
//        Keyboard
//        Mouse
//        Camera
//        Se pah GUI

//        int scale = 150;
//        Tri tri1 = new Tri(
//                new Vertex(0,0,0),
//                new Vertex(0,scale,0),
//                new Vertex(scale, 0, 0)
//        );
//        Tri tri2 = new Tri(
//                new Vertex(scale,scale,0),
//                new Vertex(0,scale,0),
//                new Vertex(scale, 0, 0)
//        );
//        Quad quad = new Quad(tri1, tri2);
//s
//        int[] ws = {460, 460};


//        render(quad);
        Game g = new Game(1);
        for(int x = 0; x < 2; x++) {
            StaticBody b = new StaticBody(g, new Vector3(), new double[]{0,x});
            g.add(b);
        }
        g.run();

    }

    public static void render(Quad quad) {
        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        // panel to display render results
        JPanel renderPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                g2.translate(getWidth() / 2, getHeight() / 2);
                g2.setColor(Color.GREEN);
                for (Tri t : quad.getTris()) {
                    Path2D path = new Path2D.Double();
                    path.moveTo(t.a.x, t.a.y);
                    path.lineTo(t.b.x, t.b.y);
                    path.lineTo(t.c.x, t.c.y);
                    path.closePath();
                    g2.draw(path);
                }

                // rendering magic will happen here
            }
        };
        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}