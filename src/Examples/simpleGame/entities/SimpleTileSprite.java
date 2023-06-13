package Examples.simpleGame.entities;

import artemis.Vector2;
import artemis.game.Game;
import artemis.game.Sprite;
import artemis.render.Scene;

import java.awt.*;
import java.util.Objects;

public class SimpleTileSprite extends Sprite {
    private int tileRepeat;
    private String dir;
    public SimpleTileSprite(Game game, Scene scene, Vector2 position,
                            double[] size, String[] frames, int repeat, String direction
    ) {
        super(game, scene, position, size, frames);
        this.tileRepeat = repeat;
        this.dir = direction.toUpperCase();
    }

    @Override
    public void render(Graphics2D ctx) {
        int posX, posY;

        for(int x = 0; x < this.tileRepeat; x++) {
            if(Objects.equals(this.dir, "vertical".toUpperCase())) {
                posY = (int) (this.position.y + this.size[1] * x);
                posX = (int) this.position.x;
            } else {
                posY = (int) this.position.y;
                posX = (int) (this.position.x + this.size[0] * x);
            }
            ctx.drawImage(
                    this.frames.get(this.currentFrame),
                    posX,
                    posY,
                    (int) this.size[0],
                    (int) this.size[1],
                    null
            );
        }
    }
}
