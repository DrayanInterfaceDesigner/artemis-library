import artemis.Vector3;
import artemis.controller.KeyControl;
import artemis.controller.MouseControl;
import artemis.game.*;

import java.awt.*;
import java.awt.geom.Path2D;

public class Character extends KinematicBody {
    private Sprite skin;
    private KeyControl keyboard;
    private MouseControl mouse;
    private Vector3 lastDirection;
    public Character(Game game, Vector3 position, double[] size) {
        super(game, position, size);
        Vector3 center = new Vector3((int)(this.position.x - this.size[0]/2), (int)(this.position.y - this.size[1]/2));
        this.skin = new Sprite(this.game, this.center, size, new String[]{
                "src/test/assets/sprite.jpg",
                "src/test/assets/sprite2.png",
                "src/test/assets/sprite3.png",
                "src/test/assets/sprite4.jpg"
        });
        this.keyboard = new KeyControl(this.game);
        this.mouse = new MouseControl(this.game);
        this.collisionBox = new CollisionBox(game, this.center, size, new Grid(), this);
        this.addChild(this.skin);
        this.addChild(this.collisionBox);
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
        mouse.registerButton("left", 1);
        mouse.registerButton("ehofimas", 3);
    }

    @Override
    public void _physicsProcess(long delta) {
        super._physicsProcess(delta);
        this.center.x = this.position.x - this.size[0]/2;
        this.center.y = this.position.y - this.size[1]/2;
//        System.out.println(mouse.clicked("left"));

        if(mouse.clicked("left")) {
            Vector3 pos = mouse.getClickPosition();
            this.lastDirection = new Vector3(pos.x, pos.y);
        }

        if(keyboard.isKeyPressed('w')) {
            this.hide(true);
            this.skin.hide(true);
            System.out.println(this.skin.isHidden());
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
        this.collisionBox.isColliding();
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
    public void _process(long delta) {
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
