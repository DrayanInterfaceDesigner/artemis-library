package Examples.simpleGame.entities;

import artemis.Vector2;
import artemis.game.Entity;
import artemis.game.Game;
import artemis.game.Sprite;
import artemis.game.StaticBody;
import artemis.render.Scene;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;

public class SimpleWall extends StaticBody implements Serializable {
    private Sprite tile;
    private int tileRepeat;
    public SimpleWall(Game game, Scene scene, Vector2 position, double[] size, int repeat, String direction) {
        super(game, scene, position, size);
        this.tileRepeat = repeat;
        double[] tilesize = {size[0], size[1]};
        this.tile = new SimpleTileSprite(game, scene, this.center, tilesize, new String[] {
                "src/Examples/simpleGame/assets/wall/wall.png"
        }, this.tileRepeat, direction);
//        this.collisionBox.size[1] = size[1] * repeat;
        if(Objects.equals(direction.toUpperCase(), "vertical".toUpperCase())){
            this.collisionBox.size[1] = size[1] * repeat;
            System.out.println("?::::");
        }
        else {
            this.collisionBox.size[0] = size[0] * repeat;
            System.out.println("??????????????????????????????????????????");
        }
    }


    @Override
    public void getReady() {
        super.getReady();
        this.tile.getReady();
    }

    @Override
    public void _onReady() {
        super._onReady();
        this.tile._onReady();
    }

    @Override
    public boolean isOnScreen() {
        return false;
    }

    @Override
    public void _physicsProcess(double delta) {
        super._physicsProcess(delta);
    }

    @Override
    public void _process(double delta) {
        super._process(delta);
    }

    @Override
    public void render(Graphics2D ctx) {

    }
}
