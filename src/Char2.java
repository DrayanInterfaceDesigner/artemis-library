import artemis.Vector2;
import artemis.controller.KeyControl;
import artemis.controller.MouseControl;
import artemis.game.Game;
import artemis.game.KinematicBody;
import artemis.game.Sprite;
import artemis.render.Scene;

public class Char2 extends KinematicBody {
    private Sprite skin;
    private KeyControl keyboard;
    private MouseControl mouse;
    private Vector2 lastDirection;

    public Char2(Game game, Scene scene, Vector2 position, double[] size) {
        super(game, scene, position, size);
        this.skin = new Sprite(game, scene, position, size, new String[]{
                "src/test/assets/sprite.jpg",
                "src/test/assets/sprite2.png",
                "src/test/assets/sprite3.png",
                "src/test/assets/sprite4.jpg"
        });
        
    }
}
