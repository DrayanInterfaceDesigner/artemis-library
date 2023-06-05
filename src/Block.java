import artemis.Vector3;
import artemis.game.*;

import java.awt.*;

public class Block extends StaticBody {
    private Sprite skin;
    public Block(Game game, Vector3 position, double[] size) {
        super(game, position, size);
        this.skin = new Sprite(this.game, this.center, size, new String[]{
                "C:\\Users\\PUCPR\\Desktop\\drayan\\projetos\\repo\\artemis-library\\src\\test\\assets\\sprite.jpg",
                "C:\\Users\\PUCPR\\Desktop\\drayan\\projetos\\repo\\artemis-library\\src\\test\\assets\\sprite2.png",
                "C:\\Users\\PUCPR\\Desktop\\drayan\\projetos\\repo\\artemis-library\\src\\test\\assets\\sprite3.png"
        });
        this.collisionBox = new CollisionBox(game, this.center, size, new Grid(), this);
    }

    @Override
    public void getReady() {
        this.collisionBox.getReady();
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
