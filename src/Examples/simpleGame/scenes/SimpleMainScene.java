package Examples.simpleGame.scenes;

import Examples.simpleGame.components.StoryPopup;
import Examples.simpleGame.entities.*;
import artemis.Vector2;
import artemis.game.Barrier;
import artemis.game.Game;
import artemis.game.gui.Button;
import artemis.game.gui.Menu;
import artemis.render.Scene;

import javax.swing.*;

public class SimpleMainScene extends Scene {
    public SimpleMainScene(Game g) {
        super(g);
    }

    @Override
    public void setup() {
        super.setup();
        StoryPopup popup_tutorial = new StoryPopup(
                this.game,
                this,
                new Vector2(0,0),
                new double[]{100,200},
                false
        );
        SimplePopup popup = new SimplePopup(
                this.game,
                this,
                new Vector2(0,0),
                new double[]{100,200},
                false,
                "Achados & Perdidos",
                "Voce achou um coco triste!",
                "Veja o que ele tem a dizer."
        );
        SimplePopup popup2 = new SimplePopup(
                this.game,
                this,
                new Vector2(100,100),
                new double[]{100,200},
                false,
                "Achados & Perdidos",
                "Vaaaaaaaa!",
                "Vsssssssssssssssser."
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

        SimpleInteractable interactable = new SimpleInteractable(
                this.game,
                this,
                new Vector2(600,800),
                new double[]{136,256},
                popup
        );

        SimpleMenu menu = new SimpleMenu(
                this.game,
                this,
                new Vector2(20,90),
                new double[]{100,200},
                false
        );

//        menu.addDropdown("Developer", new int[] {0}, new JMenuItem("Debug Mode"),
//                new JMenuItem("Generate Scene Exception"));
//        menu.addDropdown("Game", new int[] {0}, new JMenuItem("Show FPS"),
//                new JMenuItem("Tutorial"));
//        menu.t("ss", null, new Button(
//                this.game,
//                this,
//                new Vector2(0,0),
//                new double[]{0,0},
//                false
//        ));

        background.getReady();
        left.getReady();
        right.getReady();
        top.getReady();
        bottom.getReady();
        popup.getReady();
        popup2.getReady();
        popup_tutorial.getReady();
        interactable.getReady();
        character.getReady();
        menu.getReady();
        
        this.add(popup_tutorial);
        this.add(menu);
        this.add(popup2);
        this.add(popup);
        this.add(character);
        this.add(left);
        this.add(right);
        this.add(top);
        this.add(bottom);
        this.add(interactable);
        this.add(background);
        this.game.getCamera().getGlassPane().setVisible(true);
    }
}
