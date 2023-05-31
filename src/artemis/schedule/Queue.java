package artemis.schedule;

import artemis.game.Entity;
import artemis.game.Game;
import artemis.render.Canvas;

import java.util.ArrayList;

public class Queue {
    private ArrayList<Entity> entries;
    private Game game;
    private Canvas canvas;
    public Queue (Game game, Canvas canvas) {
        this.game = game;
        this.canvas = canvas;
    }
    public void add(Entity e) {
        entries.add(e);
    }
    public void remove(Entity e) {
        entries.remove(e);
    }
    public void fill(ArrayList<Entity> entities) {
        for(Entity e : entities) {
            this.add(e);
        }
    }

    private void _thread_PhysicsProcess() {
        for(Entity e : this.entries) {
            e._physicsProcess(this.game.getDelta());
        }
    }
    private void _thread_Process() {
        for(Entity e : this.entries) {
            e._process(this.game.getDelta());
        }
    }
    private void _thread_Render() {
        for(Entity e : this.entries) {
            this.game.getCanvas().render(e);
            this.remove(e);
        }
    }
    public void execute() {
        this._thread_PhysicsProcess();
        this._thread_Process();
        this._thread_Render();
    }
}
