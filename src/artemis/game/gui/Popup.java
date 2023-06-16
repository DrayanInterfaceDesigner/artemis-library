package artemis.game.gui;

import artemis.Vector2;
import artemis.game.Game;
import artemis.render.Scene;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Popup extends GUI implements IPopup{
    protected JPanel glass;
    protected JScrollPane scrollContainer;
    protected JPanel popup;
    protected JLabel titleLabel;
    protected JButton closeButton;
    private static int mousePressX;
    private static int mousePressY;
    public Popup(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size, onGlass);

        this.glass = new JPanel();
        glass.setLayout(null);
        glass.setOpaque(false);

        this.scrollContainer = new JScrollPane();
        this.scrollContainer.setPreferredSize(new Dimension((int)this.size[0], (int)this.size[1]));
        this.scrollContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.scrollContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.popup = new JPanel();
        this.popup.setLayout(new BorderLayout());
        this.popup.setBackground(Color.WHITE);
        this.popup.setBounds((int) this.position.x, (int) this.position.y, (int)this.size[0], (int)this.size[1]);
        this.popup.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.titleLabel = new JLabel("Draggable Popup");
        this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        popup.add(this.titleLabel, BorderLayout.NORTH);

        this.closeButton = new JButton("Close");
        this.closeButton.addActionListener(e -> {
            glass.setVisible(false);
        });
        popup.add(this.closeButton, BorderLayout.SOUTH);

        glass.add(popup);

        popup.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressX = e.getXOnScreen();
                mousePressY = e.getYOnScreen();
            }
        });

        popup.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getXOnScreen() - mousePressX;
                int deltaY = e.getYOnScreen() - mousePressY;
                int popupX = popup.getX() + deltaX;
                int popupY = popup.getY() + deltaY;

                popup.setLocation(popupX, popupY);
                mousePressX = e.getXOnScreen();
                mousePressY = e.getYOnScreen();
            }
        });

        this.popup.add(this.scrollContainer);
        if(!this.onGlass) {
            this.game.getCamera().getCanvas().setGlassPane(glass);
        }
        else {
            this.game.getCamera().getGlassPane().setLayout(new BorderLayout());
            this.game.getCamera().getGlassPane().add(glass, BorderLayout.CENTER);
            this.game.getCamera().getGlassPane().setVisible(true);
        }
//        this.game.getCamera().getGlassPane().add(glass);

    }

    @Override
    public void setup() {

    }

    public void setVisibility(boolean b) {
        Container glassPane = (Container) this.game.getCamera().getCanvas().getGlassPane();
        boolean hasVisibleComponent = checkVisibleComponents(glassPane);

        if (hasVisibleComponent) {
            this.game.getCamera().getCanvas().setGlassPane(this.glass);
            this.glass.setVisible(true);
        }
    }

    public boolean checkVisibleComponents(Container container) {
        Component[] components = container.getComponents();

        for (Component component : components) {
            if (component.isVisible()) {
                return true;
            }
        }

        return false;
    }

    public void setLabel(String label) {
        this.titleLabel.setText(label);
        titleLabel.revalidate();
        titleLabel.repaint();
    }

    public void add(JComponent... components) {
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));

        for(JComponent c : components) {
            c.setAlignmentX(Component.CENTER_ALIGNMENT);

            wrapper.add(c);
            wrapper.add(c);
        }
        container.add(wrapper);

        this.scrollContainer.setViewportView(wrapper);
        popup.revalidate();
        popup.repaint();
    }

    @Override
    public void getReady() {
        super.getReady();
    }

    @Override
    public void _onReady() {
        setup();
        popup.revalidate();
        popup.repaint();
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
