package artemis.controller;

import artemis.game.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyControl implements KeyListener {
    private Map<Character, Boolean> keyStateMap;
    private Map<Character, Boolean> keyReleaseStateMap;
    private Game game;
    public KeyControl(Game game) {
        this.keyStateMap = new HashMap<>();
        this.keyReleaseStateMap = new HashMap<>();
        this.game = game;
        this.game.getCamera().getCanvas().addKeyListener(this);
    }

    public void registerKey(char keyChar) {
        keyStateMap.put(keyChar, false);
        keyReleaseStateMap.put(keyChar, false);
    }

    public boolean isKeyPressed(char keyChar) {
        Boolean state = keyStateMap.get(keyChar);
        return state != null && state;
    }
    public boolean isKeyReleased(char keyChar) {
        Boolean state = keyStateMap.get(keyChar);
        return !state;
    }
    public boolean keyJustReleased(char keyChar) {
        Boolean state = keyReleaseStateMap.get(keyChar);
        keyReleaseStateMap.put(keyChar, false);
        return state != null && state;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if (keyStateMap.containsKey(keyChar)) {
            keyStateMap.put(keyChar, true);
            keyReleaseStateMap.put(keyChar, false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if (keyStateMap.containsKey(keyChar)) {
            keyStateMap.put(keyChar, false);
            keyReleaseStateMap.put(keyChar, true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
