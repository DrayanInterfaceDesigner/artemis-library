package artemis.controller;

public class Controller {
    public Controller(){

    }

    public void listen(String listener, Runnable callback) {
        switch (listener) {
            case "mouseClicked":
                break;
            case "mousePressed":
                break;
            case "mouseReleased":
                break;
            case "mouseEntered":
                break;
            case "mouseExited":
                break;
            case "keyClicked":
                break;
            case "keyPressed":
                break;
            case "keyReleased":
                break;
            case "keyCounter":
                break;
        }
    }
}

//
//import javax.swing.*;
//        import java.awt.event.*;
//
//public class InputListenerExample {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Input Listener Example");
//        JPanel panel = new JPanel();
//
//        panel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                // Handle mouse click event
//                System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
//            }
//        });
//
//        panel.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                // Handle key press event
//                System.out.println("Key pressed: " + e.getKeyChar());
//            }
//        });
//
//        panel.setFocusable(true); // Required for KeyListener to work
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
//    }
//}
//
//
//
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Input Listener Example");
//        JPanel panel = new JPanel();
//
//        Runnable callback = () -> {
//            System.out.println("Mouse pressed!");
//            // Add your custom logic here
//        };
//
//        MyMouseListener listener = new MyMouseListener(callback);
//        panel.addMouseListener(listener);
//
//        // Rest of your code...
//    }
//
//
//    import javax.swing.*;
//            import java.awt.event.*;
//
//public class MyMouseListener implements MouseListener {
//    private Runnable callback;
//
//    public MyMouseListener(Runnable callback) {
//        this.callback = callback;
//    }
//
//    public void onMousePressed() {
//        if (callback != null) {
//            callback.run();
//        }
//    }
//
//    // Other methods of MouseListener interface
//    @Override
//    public void mouseClicked(MouseEvent e) {}
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        onMousePressed();
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {}
//
//    @Override
//    public void mouseEntered(MouseEvent e) {}
//
//    @Override
//    public void mouseExited(MouseEvent e) {}
//}
//import javax.swing.*;
//        import java.awt.event.*;
//
//public class MyMouseListener implements MouseListener {
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        // Handle mouse click event
//        System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
//    }
//
//    // Other methods of MouseListener interface
//    @Override
//    public void mousePressed(MouseEvent e) {}
//
//    @Override
//    public void mouseReleased(MouseEvent e) {}
//
//    @Override
//    public void mouseEntered(MouseEvent e) {}
//
//    @Override
//    public void mouseExited(MouseEvent e) {}
//}
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Input Listener Example");
//        JPanel panel = new JPanel();
//
//        MyMouseListener listener = new MyMouseListener();
//        panel.addMouseListener(listener);
//
//        // Rest of your code...
//    }

