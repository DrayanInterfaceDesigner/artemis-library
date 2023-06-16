package Examples.simpleGame.scenes;

import Examples.simpleGame.components.StoryPopup;
import Examples.simpleGame.components.TablePopup;
import Examples.simpleGame.entities.*;
import Examples.simpleGame.utils.CSVManager;
import Examples.simpleGame.utils.DATManager;
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
        StoryPopup popup_tutorial = new StoryPopup(
                this.game,
                this,
                new Vector2(this.game.getWindowSize()[0]/2 - 200,this.game.getWindowSize()[1]/2 - 200),
                new double[]{400,400},
                false
        );
        SimplePopup popup = new SimplePopup(
                this.game,
                this,
                new Vector2(this.game.getWindowSize()[0]/2 - 200,this.game.getWindowSize()[1]/2 - 150),
                new double[]{400, 300},
                false,
                "Achados & Perdidos",
                "Voce achou um coco triste!",
                "Veja o que ele tem a dizer."
        );

        CSVManager csv = new CSVManager("src/Examples/simpleGame/persistent/nicethings.csv");
        csv.read();

        TablePopup popup2 = new TablePopup(
                this.game,
                this,
                new Vector2(200,50),
                new double[]{500, 400},
                false,
                csv.rows
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

        SimpleInteractableToilet toilet = new SimpleInteractableToilet(
                this.game,
                this,
                new Vector2(600,800),
                new double[]{136,256},
                popup
        );
        SimpleInteractablePaper paper = new SimpleInteractablePaper(
                this.game,
                this,
                new Vector2(1000,950),
                new double[]{80,80},
                popup2
        );
        SimpleManoelGomes manoel = new SimpleManoelGomes(
                this.game,
                this,
                new Vector2(450,650),
                new double[] {200,200}
        );

        SimpleTileSprite.SimpleSerializable m = new SimpleTileSprite.SimpleSerializable(
                "heeeey im DAT!"
        );

        DATManager dat = new DATManager("src/Examples/simpleGame/persistent/button.dat");

        SimpleMenu menu = new SimpleMenu(
                this.game,
                this,
                new Vector2(20,90),
                new double[]{100,200},
                false,
                dat,
                m
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
        toilet.getReady();
        paper.getReady();
        manoel.getReady();

        character.getReady();
        menu.getReady();

        this.add(popup_tutorial);
        this.add(menu);
        this.add(popup2);
        this.add(popup);
        this.add(paper);
        this.add(character);
        this.add(left);
        this.add(right);
        this.add(top);
        this.add(bottom);
        this.add(manoel);
        this.add(toilet, background);
        this.game.getCamera().getGlassPane().setVisible(true);
    }
}
