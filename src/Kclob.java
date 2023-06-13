import artemis.Vector2;
import artemis.game.*;
import artemis.render.Scene;

import java.awt.*;

public class Kclob extends RigidBody {
    private Sprite skin;
    public Kclob(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
        this.skin = new Sprite(this.game, this.scene, this.center, size, new String[]{
                "src/test/assets/sprite.jpg",
                "src/test/assets/sprite2.png",
                "src/test/assets/sprite3.png",
                "src/test/assets/sprite4.jpg"
        });

        this.collisionBox = new CollisionBox(game, this.scene, position, size, this);
    }
    @Override
    public void getReady() {
        this.collisionBox.getReady();
        super.getReady();
        this.skin.getReady();
    }

    @Override
    public void _onReady() {
        super._onReady();
        this.skin.currentFrame = 2;
    }
    @Override
    public void render(Graphics2D ctx) {
        if (isHidden()) return;
        super.render(ctx);
    }
}
