package artemis.game;

import artemis.Vector2;
import artemis.render.Scene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Sprite extends Entity implements IEntity, Serializable {
    private String[] paths;
    public ArrayList<BufferedImage> frames;
    public int currentFrame;

    public boolean flipH;
    public boolean flipV;

    public Sprite(Game game, Scene scene, Vector2 position, double[] size, String[] frames) {
        super(game, scene, position, size);
        this.paths = frames;
        this.currentFrame = 0;
        this.frames = new ArrayList<BufferedImage>();
        bringImagesToBuffer();
    }

    private void bringImagesToBuffer() {
        for(String f : this.paths) {
            try {
                this.frames.add(ImageIO.read(new File(f)));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    @Override
//    public void pushToGame() {
//        this.game.add(this);
//    }
//    @Override
//    public void getReady() {
//        this.pushToGame();
//    }


    @Override
    public void _onReady() {}

    @Override
    public void _physicsProcess(double delta) {
//        this.position.x += 1;
    }

    @Override
    public void _process(double delta) {
//        this.currentFrame = 1;
    }

    @Override
    public void render(Graphics2D ctx) {

        AffineTransform transform = new AffineTransform();

        transform.translate((int) this.position.x, (int) this.position.y);
        int width = (int) Math.abs(this.size[0]);
        int height = (int) Math.abs(this.size[1]);
        if (this.flipH) {
            transform.translate(width, 0);
            transform.scale(-1, 1);
        }
        if (this.flipV) {
            transform.translate(0, height);
            transform.scale(1, -1);
        }
        transform.scale(width / (double) this.frames.get(this.currentFrame).getWidth(),
                height / (double) this.frames.get(this.currentFrame).getHeight());

        ctx.drawImage(
                this.frames.get(this.currentFrame),
                transform,
                null
        );
    }

    @Override
    public boolean isOnScreen() {
        return false;
    }

    public BufferedImage getBufferedFrame(int index) {
        return frames.get(index);
    }

    public int getFramesLength() {
        return this.frames.size();
    }
}
