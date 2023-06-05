import artemis.Vector3;
import artemis.game.Sprite;
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
//        *Keyboard ok ok
//        *Mouse ok ok
//        Camera ok ok
//        Sprite ok ok
//        AnimatedSprite - -
//        CollisionBox ok ok~
//        RigidBody ok -
//        KinematicBody ok -
//        Grid ok -
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
        Game g = new Game(60);
        for(int x = 0; x < 2; x++) {
            StaticBody b = new StaticBody(g, new Vector3(50,50), new double[]{0,x});
            g.add(b);
        }
//        Sprite s = new Sprite(g, new Vector3(50,50), new double[]{100, 100},
//                new String[]{
//                        "C:\\Users\\draya\\Desktop\\Profile\\university\\bcc\\oop\\artemis-engine\\src\\test\\assets\\sprite.jpg",
//                        "C:\\Users\\draya\\Desktop\\Profile\\university\\bcc\\oop\\artemis-engine\\src\\test\\assets\\sprite2.png"
//        });
        Character kirby = new Character(g, new Vector3(0,0), new double[]{100, 100});
        Block block = new Block(g, new Vector3(250,250), new double[]{800, 800});
        block.getReady();
        kirby.getReady();
//        s.pushToGame();
//        g.add(s);
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

//import javax.swing.*;
//        import java.awt.*;
//
//public class TextRenderingExample {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> createAndShowGUI());
//    }
//
//    private static void createAndShowGUI() {
//        JFrame frame = new JFrame("Text Rendering Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                renderText(g);
//            }
//        };
//
//        frame.getContentPane().add(panel);
//        frame.setSize(300, 200);
//        frame.setVisible(true);
//    }
//
//    private static void renderText(Graphics g) {
//        g.setColor(Color.BLACK);
//        g.setFont(new Font("Arial", Font.BOLD, 24));
//        g.drawString("Hello, World!", 50, 100);
//    }
//}
//
//import java.util.concurrent.CountDownLatch;
//
//public class A {
//    public void One() {
//        // Logic for function One
//        System.out.println("Function One executed");
//    }
//
//    public void Two() {
//        // Logic for function Two
//        System.out.println("Function Two executed");
//    }
//
//    public void Three() {
//        // Logic for function Three
//        System.out.println("Function Three executed");
//    }
//
//    public void run() {
//        CountDownLatch latch = new CountDownLatch(3);
//
//        // Create threads for each function and start them
//        Thread threadOne = new Thread(() -> {
//            One();
//            latch.countDown();
//        });
//
//        Thread threadTwo = new Thread(() -> {
//            Two();
//            latch.countDown();
//        });
//
//        Thread threadThree = new Thread(() -> {
//            Three();
//            latch.countDown();
//        });
//
//        threadOne.start();
//        threadTwo.start();
//        threadThree.start();
//
//        try {
//            // Wait for all threads to complete
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // All functions have completed, proceed with the run logic
//        System.out.println("All functions executed");
//    }
//
//    public static void main(String[] args) {
//        A instanceA = new A();
//        instanceA.run();
//    }
//}
//import javax.swing.*;
//        import java.awt.*;
//
//public class Main {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 600);
//
//        // Create a custom JPanel for rendering
//        JPanel renderPanel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                // Rendering logic here
//            }
//        };
//
//        frame.add(renderPanel);
//        frame.setVisible(true);
//
//        // Desired frame rate (e.g., 60 frames per second)
//        int targetFPS = 60;
//
//        // Calculate the delay between frames based on the target frame rate
//        long targetFrameDelay = Math.round(1000.0 / targetFPS);
//
//        // Start the game loop
//        while (true) {
//            long startTime = System.currentTimeMillis();
//
//            // Perform game logic and update the renderPanel
//
//            renderPanel.repaint();
//
//            long elapsedTime = System.currentTimeMillis() - startTime;
//            long sleepTime = targetFrameDelay - elapsedTime;
//
//            if (sleepTime > 0) {
//                try {
//                    Thread.sleep(sleepTime);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}

//
//import javax.swing.*;
//        import java.awt.*;
//
//public class Main {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 600);
//
//        // Create a custom JPanel for rendering
//        JPanel renderPanel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                // Rendering logic here
//            }
//        };
//
//        frame.add(renderPanel);
//        frame.setVisible(true);
//
//        // Desired frame rate (e.g., 60 frames per second)
//        int targetFPS = 60;
//
//        // Calculate the delay between frames based on the target frame rate
//        long targetFrameDelay = Math.round(1000.0 / targetFPS);
//
//        // Start the game loop
//        while (true) {
//            long startTime = System.currentTimeMillis();
//
//            // Perform game logic and update the renderPanel
//
//            renderPanel.repaint();
//
//            long elapsedTime = System.currentTimeMillis() - startTime;
//            long sleepTime = targetFrameDelay - elapsedTime;
//
//            if (sleepTime > 0) {
//                try {
//                    Thread.sleep(sleepTime);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}


//
//import javax.swing.*;
//        import java.awt.*;
//
//public class CameraSystemExample extends JPanel {
//    private int cameraX;
//    private int cameraY;
//    private int objectX = 100;
//    private int objectY = 100;
//
//    public CameraSystemExample() {
//        setPreferredSize(new Dimension(800, 600));
//        cameraX = 0;
//        cameraY = 0;
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        Graphics2D g2d = (Graphics2D) g.create();
//
//        // Translate the graphics object based on camera position
//        g2d.translate(cameraX, cameraY);
//
//        // Draw objects or content at their original positions
//        g2d.setColor(Color.RED);
//        g2d.fillRect(objectX, objectY, 200, 200);
//
//        g2d.dispose();
//    }
//
//    public void moveCamera(int dx, int dy) {
//        cameraX += dx;
//        cameraY += dy;
//        repaint();
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Camera System Example");
//        CameraSystemExample panel = new CameraSystemExample();
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
//
//        panel.requestFocus(); // Request focus to receive key events
//
//        // Add a KeyListener to move the camera
//        panel.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                int key = e.getKeyCode();
//                int speed = 10; // Adjust this value to change camera movement speed
//
//                if (key == KeyEvent.VK_LEFT) {
//                    panel.moveCamera(-speed, 0);
//                } else if (key == KeyEvent.VK_RIGHT) {
//                    panel.moveCamera(speed, 0);
//                } else if (key == KeyEvent.VK_UP) {
//                    panel.moveCamera(0, -speed);
//                } else if (key == KeyEvent.VK_DOWN) {
//                    panel.moveCamera(0, speed);
//                }
//            }
//        });
//    }
//}

