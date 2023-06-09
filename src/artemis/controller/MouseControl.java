package artemis.controller;

import artemis.Vector2;
import artemis.game.Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class MouseControl implements MouseListener {
    public MouseEventReturnee mouseEventReturnee;
    private MouseEventReturnee mouseEventReturneeZERO;
    private Vector2 clickPosition;
    private Map<String, Integer> buttonMap;
    private Map<Integer, Boolean> buttonClickStateMap;
    private Map<Integer, Boolean> buttonPressStateMap;
    private Game game;
    public MouseControl(Game game) {
        this.mouseEventReturneeZERO = new MouseEventReturnee(
                new Vector2(-1, -1),
                false,
                false,
                false,
                -1,
                -1,
                new Object()
        );
        this.mouseEventReturnee = mouseEventReturneeZERO;
        this.buttonMap = new HashMap<>();
        this.buttonClickStateMap = new HashMap<>();
        this.buttonPressStateMap = new HashMap<>();
        this.game = game;
        this.game.getCamera().getCanvas().addMouseListener(this);
    }

    public MouseEventReturnee composedClick() {
        MouseEventReturnee e;
        MouseEventReturnee origin = this.mouseEventReturnee;
        e = new MouseEventReturnee(
                origin.getClickedAt(),
                origin.isRIGHT(),
                origin.isLEFT(),
                origin.isMIDDLE(),
                origin.getButton(),
                origin.getClickCount(),
                origin.getTarget()
        );

        this.resetMouseEventReturnee();
        return e;
    }

    public int findKeyFor(String button) {
        return this.buttonMap.get(button);
    }

    public void registerButton(String name, int button) {
        this.buttonMap.put(name, button);
        this.buttonClickStateMap.put(button, false);
        this.buttonPressStateMap.put(button, false);
    }

    public boolean clicked(String button) {
        Boolean state = buttonClickStateMap.get(findKeyFor(button));
        buttonClickStateMap.put(findKeyFor(button), false);
        return state != null && state;
    }

//    public boolean pressed(String button) {
//        Boolean state = buttonPressStateMap.get(findKeyFor(button));
//        return state != null && state;
//    }
//    public boolean released(String button) {
//        Boolean state = buttonPressStateMap.get(findKeyFor(button));
//        return state != null && state;
//    }

    public MouseEventReturnee getMouseEventReturnee() {
        return this.mouseEventReturnee;
    }
    public void resetMouseEventReturnee() {
        MouseEventReturnee ZERO = new MouseEventReturnee(
                new Vector2(-1, -1),
                false,
                false,
                false,
                -1,
                -1,
                new Object()
        );
        this.mouseEventReturnee = ZERO;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // Invoked when the mouse is clicked (pressed and released) on a component
        int x = e.getX();
        int y = e.getY();
        int button = e.getButton();
        switch (button){
            case 1:
                this.mouseEventReturnee.setLEFT(true);
                break;
            case 2:
                this.mouseEventReturnee.setMIDDLE(true);
                break;
            case 3:
                this.mouseEventReturnee.setRIGHT(true);
                break;
        }
        this.mouseEventReturnee.setClickCount(e.getClickCount());
        this.mouseEventReturnee.setButton(button);
        this.mouseEventReturnee.setClickedAt(new Vector2(x, y));
        this.mouseEventReturnee.setTarget(e.getSource());

        int buttonNum = e.getButton();
        if (buttonClickStateMap.containsKey(buttonNum)) {
            buttonClickStateMap.put(buttonNum, true);
        }

        this.clickPosition = new Vector2(x, y);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int buttonNum = e.getButton();
        if (buttonPressStateMap.containsKey(buttonNum)) {
            buttonPressStateMap.put(buttonNum, true);
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        int buttonNum = e.getButton();
        if (buttonPressStateMap.containsKey(buttonNum)) {
            buttonPressStateMap.put(buttonNum, false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Invoked when the mouse enters a component
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Invoked when the mouse exits a component
    }

    public Vector2 getClickPosition() {
        return clickPosition;
    }
}
