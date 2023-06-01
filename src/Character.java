import artemis.Vector3;
import artemis.game.Game;
import artemis.game.KinematicBody;
import artemis.game.Sprite;
import artemis.game.StaticBody;

public class Character extends KinematicBody {
    private Sprite skin;
    public Character(Game game, Vector3 position, double[] size) {
        super(game, position, size);
        this.skin = new Sprite(this.game, position, size, new String[]{
                "C:\\Users\\draya\\Desktop\\Profile\\university\\bcc\\oop\\artemis-engine\\src\\test\\assets\\sprite.jpg",
                "C:\\Users\\draya\\Desktop\\Profile\\university\\bcc\\oop\\artemis-engine\\src\\test\\assets\\sprite2.png"
        });
    }

    @Override
    public void getReady() {
        super.getReady();
        this.skin.getReady();
    }

    @Override
    public void _onReady() {
        super._onReady();
        this.skin.currentFrame = 1;
    }

    @Override
    public void _physicsProcess(long delta) {
        super._physicsProcess(delta);
        this.position.x += 1;
    }

    @Override
    public void _process(long delta) {
        super._process(delta);
//        this.skin.currentFrame = 1;
    }
}
