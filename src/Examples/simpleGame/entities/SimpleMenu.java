package Examples.simpleGame.entities;

import artemis.Vector2;
import artemis.game.Game;
import artemis.game.gui.InlineText;
import artemis.game.gui.Menu;
import artemis.game.gui.MenuButton;
import artemis.render.Scene;

import javax.swing.*;

public class SimpleMenu extends Menu {
    public MenuButton debugButton;
    public MenuButton generateExceptionButton;
    public MenuButton showFPSButton;
    public MenuButton showTutorialButton;
    public MenuButton FPSDisplay;
    public boolean showFPS;
    public SimpleMenu(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size, onGlass);

//      Creating the buttons
        debugButton = new MenuButton(
                this.game,
                this.scene,
                new Vector2(0,0),
                new double[]{0,0},
                true
        );
        generateExceptionButton = new MenuButton(
                this.game,
                this.scene,
                new Vector2(0,0),
                new double[]{0,0},
                true
        );
        showFPSButton = new MenuButton(
                this.game,
                this.scene,
                new Vector2(0,0),
                new double[]{0,0},
                true
        );
        showTutorialButton = new MenuButton(
                this.game,
                this.scene,
                new Vector2(0,0),
                new double[]{0,0},
                true
        );
        FPSDisplay = new MenuButton(
                this.game,
                this.scene,
                new Vector2(0,0),
                new double[]{0,0},
                true
        );
//      Setting menu texts
        debugButton.setText("Debug Mode!");
        generateExceptionButton.setText("Generate Scene Exception");
        showFPSButton.setText("Show FPS");
        showTutorialButton.setText("Tutorial");

//      Adding them in different dropdowns
        this.addDropdown(
                "Developer",
                new int[] {0},
                this.debugButton,
                this.generateExceptionButton
        );
        this.addDropdown(
                "Game",
                null,
                this.showFPSButton,
                this.showTutorialButton
        );
        this.addComponent(FPSDisplay.getButton());


    }

    @Override
    public void getReady() {
        super.getReady();
        this.debugButton.getReady();
        this.generateExceptionButton.getReady();
        this.showFPSButton.getReady();
        this.showTutorialButton.getReady();
        FPSDisplay.getReady();
    }

    @Override
    public void _onReady() {
        super._onReady();
    }

    @Override
    public void _process(double delta) {
        super._process(delta);
        if(this.debugButton.clicked()) {
            this.game.setDebugMode(!this.game.isDebugOn());
        }
        if(this.generateExceptionButton.clicked()) {
            this.game.switchScene(1000);
        }
        if(this.showFPSButton.clicked()) {
            this.showFPS = !this.showFPS;
        }


        if(this.showFPS) {
            FPSDisplay.getButton().setVisible(true);
            FPSDisplay.setText(String.valueOf("FPS: " + this.game.getCurrentFPS()));
        } else {
            FPSDisplay.getButton().setVisible(false);
        }
    }
}
