package Examples.simpleGame.entities;

import artemis.Vector2;
import artemis.arithmetic.ArtemisMath;
import artemis.controller.KeyControl;
import artemis.game.*;
import artemis.render.Scene;

import java.awt.*;
import java.io.Serializable;

public class SimpleCharacter extends KinematicBody implements Serializable {
    private Sprite skin;
    private KeyControl keyboard;
    private Vector2 velocity;
    private double speed;
    public SimpleCharacter(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
        this.skin = new Sprite(game, scene, this.center, size, new String[] {
                "src/Examples/simpleGame/assets/character/duck_idle.png",
                "src/Examples/simpleGame/assets/character/duck_normal.png",
                "src/Examples/simpleGame/assets/character/duck_active.png"
        });
        this.collisionBox = new CollisionBox(game, scene, this.position, size, this);
        this.keyboard = new KeyControl(game);
        this.velocity = new Vector2(0,0);
        this.speed = 1;
        this.addChild(skin);
        this.addChild(collisionBox);
//        this.hitbox.hide(true);
    }

    @Override
    public void getReady() {
        super.getReady();
        this.collisionBox.getReady();
        this.skin.getReady();
    }

    @Override
    public void _onReady() {
        super._onReady();
        this.skin._onReady();
        this.collisionBox._onReady();
        this.keyboard.registerKey('w');
        this.keyboard.registerKey('a');
        this.keyboard.registerKey('s');
        this.keyboard.registerKey('d');
        this.keyboard.registerKey(' ');
    }

    @Override
    public boolean isOnScreen() {
        return false;
    }

    @Override
    public void _physicsProcess(double delta) {
        super._physicsProcess(delta);
        ArtemisMath math = new ArtemisMath();
        Vector2 move = new Vector2(0,0);

        if(keyboard.isKeyPressed('w')) {
            move.y = -1;
        }
        if(keyboard.isKeyPressed('s')) {
            move.y = 1;
        }
        if(keyboard.isKeyPressed('a')) {
            move.x = -1;
        }
        if(keyboard.isKeyPressed('d')) {
            move.x = 1;
        }

        this.velocity.add(move);
        this.velocity.multiply(speed);
        this.position.x += this.velocity.x;
        this.position.y += this.velocity.y;

//
//        if(keyboard.isKeyPressed('w')) {
//            System.out.println("pressed");
//            this.position.y -= (speed);
//        }
//        if(keyboard.isKeyPressed('s')) {
//            this.position.y += (speed);
//        }
//        if(keyboard.isKeyPressed('a')) {
//            this.position.x -= (speed) ;
//        }
//        if(keyboard.isKeyPressed('d')) {
//            this.position.x += (speed);
//        }
    }

    @Override
    public void _process(double delta) {
        super._process(delta);
        this.game.getCamera().follow(this);
    }

    @Override
    public void render(Graphics2D ctx) {

    }
}
