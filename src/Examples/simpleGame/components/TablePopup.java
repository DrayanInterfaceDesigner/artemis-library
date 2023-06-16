package Examples.simpleGame.components;

import Examples.simpleGame.entities.SimplePopup;
import artemis.Vector2;
import artemis.game.Game;
import artemis.game.gui.Button;
import artemis.game.gui.Popup;
import artemis.game.gui.TextArea;
import artemis.render.Scene;

import java.util.ArrayList;

public class TablePopup extends Popup {
    public Button button;
    public TextArea text;
    private ArrayList<String> rows;
    private String buttonLabel;

    public TablePopup(
            Game game, Scene scene, Vector2 position,
            double[] size, boolean onGlass, ArrayList<String[]> rows)
    {
        super(game, scene, position, size, onGlass);
        this.rows = new ArrayList<>();
        for(String[] s : rows) {
            this.rows.add(String.join(" |", s));
        }
        this.buttonLabel = buttonLabel;
    }

    @Override
    public void setup() {
        this.setLabel("Paper Annotations");
        Button btn = new Button(
                this.game,this.scene ,new Vector2(-100,-100), new double[]{20, 100}, true
        );
        TextArea txt = new TextArea(
                this.game, this.scene, new Vector2(58, 58), new double[]{300,20}, true
        );

        String txt_concatenated = "\n *Lendo arquivo CSV* \n\n";
        for(String s : this.rows) {
            txt_concatenated += s + "\n\n";
        }

        this.text = txt;
        txt.text = txt_concatenated;

        txt.getReady();

        this.add(txt.getWrapper());
    }
}
