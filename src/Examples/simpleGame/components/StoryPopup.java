package Examples.simpleGame.components;

import artemis.Vector2;
import artemis.game.Game;
import artemis.game.gui.Button;
import artemis.game.gui.Popup;
import artemis.game.gui.TextArea;
import artemis.render.Scene;

public class StoryPopup extends Popup {
    public StoryPopup(Game game, Scene scene, Vector2 position, double[] size, boolean onGlass) {
        super(game, scene, position, size, onGlass);
        this.setVisibility(true);
    }

    @Override
    public void setup() {
        super.setup();
        this.setVisibility(true);
        this.setLabel("Tutorial");
//        ChangeSceneButton btn = new ChangeSceneButton(
//                this.game,this.scene ,new Vector2(-100,-100), new double[]{20, 100}, true
//        );
        TextArea txt = new TextArea(
                this.game, this.scene, new Vector2(58, 58), new double[]{150,60}, true
        );

        txt.text = "Ao encontrar qualquer coisa por aí, tente apertar E para interagir.\n\n" +
                "As teclas W A S D movem a personagem.\n\n" +
                "Esse jogo simples guarda a fase em que está com permanência de objeto. \n\n" +
                "Você pode mudar de fase encontrando a banheira e interagindo com ela.";
//        btn.label = "Entendi";

        txt.getReady();
//        btn.getReady();

        this.add(txt.getWrapper());
    }
}
