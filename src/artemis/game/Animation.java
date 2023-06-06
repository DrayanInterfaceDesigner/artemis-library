package artemis.game;

import artemis.Vector3;

import java.util.ArrayList;

public class Animation {
    private Sprite sprite;
    public int fps;
    private String alias;

    public Animation(Game game, Vector3 position, double[] size, String alias, int fps, String[] frames) {
        this.sprite = new Sprite(game, position, size, frames);
        this.fps = fps;
        this.alias = alias;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
