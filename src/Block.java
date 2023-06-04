import artemis.Vector3;
import artemis.game.Game;
import artemis.game.RigidBody;
import artemis.game.Sprite;
import artemis.game.StaticBody;

import java.awt.*;

public class Block extends StaticBody {
    private Sprite skin;
    public Block(Game game, Vector3 position, double[] size) {
        super(game, position, size);
        this.skin = new Sprite(this.game, position, size, new String[]{
                "C:\\Users\\draya\\Desktop\\Profile\\university\\bcc\\oop\\artemis-engine\\src\\test\\assets\\sprite.jpg",
                "C:\\Users\\draya\\Desktop\\Profile\\university\\bcc\\oop\\artemis-engine\\src\\test\\assets\\sprite2.png",
                "C:\\Users\\draya\\Desktop\\Profile\\university\\bcc\\oop\\artemis-engine\\src\\test\\assets\\sprite3.png"
        });
    }

    @Override
    public void getReady() {
        super.getReady();
        this.skin.getReady();
        this.skin.currentFrame = 0;
    }

    @Override
    public void _onReady() {
        super._onReady();
        this.skin._onReady();
    }

    @Override
    public void render(Graphics2D ctx) {
        super.render(ctx);
        if (this.cameraPosition != null) {
//            ctx.translate(-this.cameraPosition.x, -this.cameraPosition.y);
        }
    }
}
