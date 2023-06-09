package artemis.game;

import artemis.Vector2;
import artemis.render.Scene;
import artemis.schedule.Timer;

import java.awt.*;
import java.util.ArrayList;

public class AnimatedSprite extends Entity{
    private ArrayList<Animation> animations;
    private int currentAnimation;
    private Sprite currentSprite;
    private Timer time;
    public AnimatedSprite(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
        this.animations = new ArrayList<>();

    }
    public void setAnimation(String alias, int fps, String[] frames){
        this.animations.add(
                new Animation(this.game, this.scene, this.position, this.size, alias, fps, frames)
        );
    }
    private void changeNextFrame() {
//        if(this.time.nextSecond()) {
//            if(!(this.currentSprite.currentFrame+1 > this.currentSprite.getFramesLength())) {
//                this.currentSprite.currentFrame = this.currentSprite.currentFrame+1;
//            }
//            else this.currentSprite.currentFrame = 0;
//        }
    }
    @Override
    public void _onReady() {

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
        this.currentSprite = this.animations.get(this.currentAnimation).getSprite();
        this.changeNextFrame();
        this.currentSprite.render(ctx);
    }

    public void setCurrentAnimation(int currentAnimation) {
        this.currentAnimation = currentAnimation;
    }
}
