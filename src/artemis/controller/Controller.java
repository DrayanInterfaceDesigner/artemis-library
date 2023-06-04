package artemis.controller;

import artemis.game.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Game game;
//    private KeyControl keyControl;
    private MouseControl mouseControl;
//
//    public Controller(Game game) {
//        this.game = game;
////        this.keyControl = new KeyControl();
//        this.mouseControl = new MouseControl();
//    }
//
////    public void registerKey(char keyChar) {
////        this.keyControl.registerKey(keyChar);
////    }
////    public boolean isKeyPressed(char keyChar) {
////        return this.keyControl.isKeyPressed(keyChar);
////    }
//
//    public MouseEventReturnee isMouseClicked() {
//        MouseEventReturnee e;
//        MouseEventReturnee origin = this.mouseControl.getMouseEventReturnee();
//        e = new MouseEventReturnee(
//                origin.getClickedAt(),
//                origin.isRIGHT(),
//                origin.isLEFT(),
//                origin.isMIDDLE(),
//                origin.getButton(),
//                origin.getClickCount(),
//                origin.getTarget()
//        );
//
//        this.mouseControl.resetMouseEventReturnee();
//        return e;
//    }
////    public KeyControl getKeyControl() {
////        return this.keyControl;
////    }
//    public MouseControl getMouseControl(){
//        return this.mouseControl;
//    }
}
