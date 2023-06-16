package artemis.render;

import artemis.game.Entity;

import artemis.game.Game;

import java.util.ArrayList;

public class Scene implements IScene{
    private ArrayList<Entity> entities;
    protected Game game;
    public Scene(Game g) {
        this.game = g;
        this.entities = new ArrayList<Entity>();
    }

    public void setup() {

    }
    public void getReady() {
        this.setup();
        this.pushToGame();
    }
    protected void getEntitiesReady() {
        for(Entity e : this.entities) {
            e.getReady();
        }
    }
    public void pushToGame() {
        this.game.addScene(this);
    }
    public void add(Entity e) {
        if(!this.entities.contains(e)) {
            this.entities.add(e);
        }
    }

    public void add(Entity... es) {
        for(Entity e : es) {
            if(!this.entities.contains(e)) {
                this.entities.add(e);
            }
        }
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
