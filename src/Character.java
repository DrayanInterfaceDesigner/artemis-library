import artemis.Vector3;
import artemis.controller.KeyControl;
import artemis.controller.MouseControl;
import artemis.game.Game;
import artemis.game.KinematicBody;
import artemis.game.Sprite;

import java.awt.*;

public class Character extends KinematicBody {
    private Sprite skin;
    private KeyControl keyboard;
    private MouseControl mouse;
    private Vector3 lastDirection;
    public Character(Game game, Vector3 position, double[] size) {
        super(game, position, size);
        this.skin = new Sprite(this.game, position, size, new String[]{
                "C:\\Users\\draya\\Desktop\\Profile\\university\\bcc\\oop\\artemis-engine\\src\\test\\assets\\sprite.jpg",
                "C:\\Users\\draya\\Desktop\\Profile\\university\\bcc\\oop\\artemis-engine\\src\\test\\assets\\sprite2.png",
                "C:\\Users\\draya\\Desktop\\Profile\\university\\bcc\\oop\\artemis-engine\\src\\test\\assets\\sprite3.png"
        });
        this.keyboard = new KeyControl(this.game);
        this.mouse = new MouseControl(this.game);
    }

    @Override
    public void getReady() {
        super.getReady();
        this.skin.getReady();
    }

    @Override
    public void _onReady() {
        super._onReady();
        this.skin._onReady();
        this.skin.currentFrame = 2;
        keyboard.registerKey('w');
        keyboard.registerKey('a');
        keyboard.registerKey('s');
        keyboard.registerKey('d');
        mouse.registerButton("left", 1);
        mouse.registerButton("right", 3);
    }

    @Override
    public void _physicsProcess(long delta) {
        super._physicsProcess(delta);
//        System.out.println(mouse.clicked("left"));

        if(mouse.clicked("left")) {
            Vector3 pos = mouse.getClickPosition();
            this.lastDirection = new Vector3(pos.x, pos.y);
        }
        if(keyboard.isKeyPressed('w')) {
            System.out.println("pressed");
            this.position.y -= 1;
        }
        if(keyboard.keyJustReleased('w')) {
            System.out.println("just released");
            this.position.y -= 1;
        }
        if(keyboard.isKeyPressed('s')) {
            this.position.y += 1;
        }
        if(keyboard.isKeyPressed('a')) {
            this.position.x -= 1;
        }
        if(keyboard.isKeyPressed('d')) {
            this.position.x += 1;
        }
//
//        if(this.lastDirection != null) {
//            if(this.position.x != this.lastDirection.x) {
//                if(this.lastDirection.x > this.position.x) {
//                    this.position.x += 1;
//                }
//                else this.position.x -= 1;
//            }
//            if(this.position.y != this.lastDirection.y) {
//                if(this.lastDirection.y > this.position.y) {
//                    this.position.y += 1;
//                }
//                else this.position.y -= 1;
//            }
//        }
    }

    @Override
    public void _process(long delta) {
        super._process(delta);
        this.game.getCamera().follow(this);
//        this.skin.currentFrame = 1;
    }

    @Override
    public void render(Graphics2D ctx) {
        super.render(ctx);
    }
}
