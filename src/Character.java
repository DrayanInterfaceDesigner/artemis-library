import artemis.Vector2;
import artemis.arithmetic.ArtemisMath;
import artemis.controller.KeyControl;
import artemis.controller.MouseControl;
import artemis.game.*;
import artemis.render.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Character extends KinematicBody {
    private Sprite skin;
    private KeyControl keyboard;
    private MouseControl mouse;
    private Vector2 lastDirection;
    public Character(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
        this.skin = new Sprite(this.game, scene, this.center, size, new String[]{
                "src/test/assets/sprite.jpg",
                "src/test/assets/sprite2.png",
                "src/test/assets/sprite3.png",
                "src/test/assets/sprite4.jpg"
        });
        this.keyboard = new KeyControl(this.game);
        this.mouse = new MouseControl(this.game);
        this.collisionBox = new CollisionBox(game, scene, this.position, size, this);
        this.addChild(this.skin);
        this.addChild(this.collisionBox);
    }

    @Override
    public void getReady() {
        super.getReady();
        this.skin.getReady();
        this.collisionBox.getReady();
    }

    @Override
    public void _onReady() {
        super._onReady();
        this.skin._onReady();
        this.skin.currentFrame = 1;
        keyboard.registerKey('w');
        keyboard.registerKey('a');
        keyboard.registerKey('s');
        keyboard.registerKey('d');
        keyboard.registerKey('m');
        keyboard.registerKey(' ');
        mouse.registerButton("left", 1);
        mouse.registerButton("ehofimas", 3);
    }

    @Override
    public void _physicsProcess(double delta) {
        int speed = 15;
        super._physicsProcess(delta);
//        System.out.println(mouse.clicked("left"));

        if(keyboard.keyJustReleased('m')) {
            this.game.getCamera().getGlassPane().setVisible(
                    !this.game.getCamera().getGlassPane().isVisible()
            );
        }
        if(mouse.clicked("left")) {
            this.game.switchScene(2);
            System.out.println(this.game.getEntities());
//            Vector2 pos = mouse.getClickPosition();
//            this.lastDirection = new Vector2(pos.x, pos.y);
        }

        if(keyboard.isKeyPressed('w')) {
            System.out.println("pressed");
            this.position.y -= (speed);
        }
        if(keyboard.isKeyPressed('s')) {
            this.position.y += (speed);
        }
        if(keyboard.isKeyPressed('a')) {
            this.position.x -= (speed) ;
        }
        if(keyboard.isKeyPressed('d')) {
            this.position.x += (speed);
        }
        if(keyboard.keyJustReleased(' ')) {
            this.position.y -= 1000;
        }

        if(!this.isOnFloor()) {
//            this.position.y+=30;
        }

//        if(keyboard.isKeyPressed('d')) {
////            this.position.x += (1* speed);
////        }
//        System.out.println(this.center.x + " " + this.center.y);
//        System.out.println(this.collisionBox.position.x + " " + this.collisionBox.position.y);
//        this.destroy();


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
    public void _process(double delta) {
        super._process(delta);
        this.game.getCamera().follow(this);
        if(mouse.clicked("ehofimas")) {
//            this.hide(true);
            if(this.skin.currentFrame >= 3) {
                this.skin.currentFrame = 0;
            }
            else {
                this.skin.currentFrame++;
            }
        }
//        this.skin.currentFrame = 1;
    }

    @Override
    public void render(Graphics2D ctx) {
        super.render(ctx);
//        ctx.translate(+300, +300);
        ctx.setColor(new Color(255, 0, 0));
//        (int)this.position.x, (int)this.position.y, 25, 25, 0, 360
//        ctx.fillRect((int)(this.position.x - this.size[0]/2), (int)(this.position.y - this.size[1]/2), (int)this.size[0], (int)this.size[1]);

    }
}
