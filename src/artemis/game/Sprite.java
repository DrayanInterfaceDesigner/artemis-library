package artemis.game;

import artemis.Vector3;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Sprite extends Entity implements IEntity {
    private String[] paths;
    private ArrayList<BufferedImage> frames;
    public int currentFrame;

    public Sprite(Game game, Vector3 position, double[] size, String[] frames) {
        super(game, position, size);
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
    public void _physicsProcess(long delta) {
//        this.position.x += 1;
    }

    @Override
    public void _process(long delta) {
//        this.currentFrame = 1;
    }

    @Override
    public void render(Graphics2D ctx) {
        ctx.drawImage(
                this.frames.get(this.currentFrame),
                (int) this.position.x,
                (int) this.position.y,
                (int) this.size[0],
                (int) this.size[1],
                null
        );
    }

    @Override
    public boolean isOnScreen() {
        return false;
    }
}
