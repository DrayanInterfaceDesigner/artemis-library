package Examples.simpleGame.scenes;

import Examples.simpleGame.components.StoryPopup;
import Examples.simpleGame.entities.*;
import artemis.Vector2;
import artemis.game.Game;
import artemis.render.Scene;

public class SimpleMainScene extends Scene {
    public SimpleMainScene(Game g) {
        super(g);

    }

    @Override
    public void setup() {
        super.setup();
        StoryPopup popup = new StoryPopup(
                this.game,
                this,
                new Vector2(0,0),
                new double[]{100,200},
                false
        );
        SimpleCharacter character = new SimpleCharacter(
                this.game,
                this,
                new Vector2(210,210),
                new double[] {100,100}
        );
        SimpleBackground background = new SimpleBackground(
                this.game,
                this,
                new Vector2(0,0),
                new double[] {2000,2000},
                new String[] {
                        "src/Examples/simpleGame/assets/background/grid.jpg"
                }
        );
        SimpleWall left = new SimpleWall(
                this.game,
                this,
                new Vector2(0,200 * 5),
                new double[]{200,200},
                10,
                "vertical"
        );
        SimpleWall right = new SimpleWall(
                this.game,
                this,
                new Vector2(0 + 2000,200 * 5),
                new double[]{200,200},
                10,
                "vertical"
        );

        SimpleWall top = new SimpleWall(
                this.game,
                this,
                new Vector2(200 * 5,0),
                new double[]{200,200},
                10,
                "horizontal"
        );

        SimpleWall bottom = new SimpleWall(
                this.game,
                this,
                new Vector2(200 * 5,0 + 2000),
                new double[]{200,200},
                10,
                "horizontal"
        );

        background.getReady();
        left.getReady();
        right.getReady();
        top.getReady();
        bottom.getReady();
        popup.getReady();
        character.getReady();

        this.add(popup);
        this.add(character);
        this.add(left);
        this.add(right);
        this.add(top);
        this.add(bottom);
        this.add(background);
    }
}
