import artemis.Vector2;
import artemis.game.*;
import artemis.render.Scene;

import java.awt.*;

public class Block extends StaticBody {
    private Sprite skin;
    public Block(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
        this.skin = new Sprite(this.game, this.scene, this.center, size, new String[]{
                "src/test/assets/sprite.jpg",
                "src/test/assets/sprite2.png",
                "src/test/assets/sprite3.png",
                "src/test/assets/sprite4.jpg"
        });
        this.collisionBox = new CollisionBox(game, this.scene, this.center, size, this);
        this.addChild(this.skin);
    }

    @Override
    public void getReady() {
        this.collisionBox.getReady();
        super.getReady();
        this.skin.getReady();
        this.skin.currentFrame = 0;
    }

    @Override
    public void _physicsProcess(double delta) {
        super._physicsProcess(delta);
//        System.out.println("Block: " + this.position.x + "//" + this.position.y);
    }

    @Override
    public void _onReady() {
        super._onReady();
        this.skin._onReady();
    }

    @Override
    public void render(Graphics2D ctx) {
        if (isHidden()) return;
        super.render(ctx);
        if (this.cameraPosition != null) {
//            ctx.translate(-this.cameraPosition.x, -this.cameraPosition.y);
        }
    }
}
