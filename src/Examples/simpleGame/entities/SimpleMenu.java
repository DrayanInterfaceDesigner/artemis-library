package Examples.simpleGame.entities;

import Examples.simpleGame.utils.CSVManager;
import Examples.simpleGame.utils.DATManager;
import Examples.simpleGame.utils.TxtManager;
import artemis.Vector2;
import artemis.game.Game;
import artemis.game.gui.Menu;
import artemis.game.gui.MenuButton;
import artemis.render.Scene;

import javax.swing.*;
import java.io.Serializable;

public class SimpleMenu extends Menu {
    public MenuButton debugButton;
    public MenuButton generateExceptionButton;
    public MenuButton saveButton;
    public MenuButton loadButton;
    public MenuButton showFPSButton;
    public MenuButton showTutorialButton;
    public MenuButton textButton;
    public MenuButton csvButton;
    public MenuButton FPSDisplay;

    public DATManager dat;
    public TxtManager txt;
    public CSVManager csv;
    public Serializable button;
    public boolean showFPS;
    public SimpleMenu(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass,
                      DATManager dat, Serializable button) {
        super(game, scene, position, size, onGlass);
        this.dat = dat;
        this.txt = new TxtManager("src/Examples/simpleGame/persistent/NEW_PERSISTENT_TEXT.txt");
        this.csv = new CSVManager("src/Examples/simpleGame/persistent/NEW_PERSISTENT_TABLE.csv");
        this.button = button;
        JMenuItem item = null;
//      Creating the buttons
        try{
            item = (JMenuItem) this.dat.read("src/Examples/simpleGame/persistent/button");
        }
        catch (Exception e)  {
            e.printStackTrace();
        }
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
        saveButton = new MenuButton(
                this.game,
                this.scene,
                new Vector2(0,0),
                new double[]{0,0},
                true
        );
        loadButton = new MenuButton(
                this.game,
                this.scene,
                new Vector2(0,0),
                new double[]{0,0},
                true
        );
        loadButton = new MenuButton(
                this.game,
                this.scene,
                new Vector2(0,0),
                new double[]{0,0},
                true
        );
        textButton = new MenuButton(
                this.game,
                this.scene,
                new Vector2(0,0),
                new double[]{0,0},
                true
        );
        csvButton = new MenuButton(
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
        saveButton.setText("Save DAT");
        loadButton.setText("Load DAT");
        textButton.setText("Write TEXT");
        csvButton.setText("Write CSV");
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
                this.showTutorialButton,
                this.saveButton,
                this.loadButton,
                this.textButton,
                this.csvButton
        );
        if(item != null) {
            this.addComponent(FPSDisplay.getButton(), item);
        }


    }

    @Override
    public void getReady() {
        super.getReady();
        this.debugButton.getReady();
        this.generateExceptionButton.getReady();
        this.showFPSButton.getReady();
        this.showTutorialButton.getReady();
        this.saveButton.getReady();
        this.loadButton.getReady();
        this.textButton.getReady();
        this.csvButton.getReady();
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

        if(this.textButton.clicked()) {
            System.out.println("hhooo");
            this.txt.content = "IT IS WRITING OMYGAH";
            this.txt.write();
        }
        if(this.csvButton.clicked()) {
            this.csv.rows.add(new String[]{
                    "PAO FRESKINHO",
                    "PADARIA DO JOKA",
                    "RUA 1234"
            });
            this.csv.write();
        }
        if(this.saveButton.clicked()) {
            this.dat.write(this.button, "src/Examples/simpleGame/persistent/button");
        }

        if(this.loadButton.clicked()) {
            try{
                SimpleSerializable item = (SimpleSerializable) this.dat.read("src/Examples/simpleGame/persistent/button.dat");
                item.ressurected +=  1;
                this.button = item;
                item.setText("Im here, from dat!!! Resurrected " + item.ressurected + "times!!!");
                if(!(this.menuBar.isAncestorOf((JMenuItem)this.button))) {
                    this.addComponent(item);
                }
            }
            catch (Exception e)  {
                e.printStackTrace();
            }
        }
    }
}
