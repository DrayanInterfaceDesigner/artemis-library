package Examples;

import Examples.simpleGame.SimpleGame;
import Examples.simpleGame.scenes.SimpleMainScene;
import Examples.simpleGame.scenes.SimplePhaseScene;

public class RunSimpleGame {
    public static void main(String[] args) {
        SimpleGame theSimpleGame = new SimpleGame(60);
        theSimpleGame.getCamera().getCanvas().setTitle("The Simple Game");
        theSimpleGame.setWindowSize(new int[]{800, 600});
        theSimpleGame.getCamera().getGlassPane().setOpaque(false);

        SimpleMainScene mainScene = new SimpleMainScene(theSimpleGame);
        SimplePhaseScene phaseScene = new SimplePhaseScene(theSimpleGame);

        mainScene.getReady();
        phaseScene.getReady();

        theSimpleGame.start();
    }
}
