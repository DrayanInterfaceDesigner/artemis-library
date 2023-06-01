package artemis.schedule;

import artemis.game.Entity;
import artemis.game.Game;
import artemis.render.Canvas;

import java.util.ArrayList;
import java.util.Iterator;

public class Queue {
    private ArrayList<Entity> entries;
    private Game game;
    private Canvas canvas;
    public Queue (Game game, Canvas canvas) {
        this.game = game;
        this.canvas = canvas;
        this.entries = new ArrayList<Entity>();
    }
    public void add(Entity e) {
        entries.add(e);
    }
    public void remove(Entity e) {
        entries.remove(e);
    }
    public void fill(ArrayList<Entity> entities) {
        if(entities == null) return;
        for(Entity e : entities) {
            this.add(e);
        }
    }
    private void _thread_PhysicsProcess() {
        if(this.entries == null) return;
        for(Entity e : this.entries) {
            e._physicsProcess(this.game.getDelta());
        }
    }
    private void _thread_Process() {
        if(this.entries == null) return;
        for(Entity e : this.entries) {
            e._process(this.game.getDelta());
        }
    }
    private void _thread_Render() {
        if (this.entries == null) return;
        Iterator<Entity> iterator = this.entries.iterator();
        while (iterator.hasNext()) {
            Entity e = iterator.next();
            this.game.getCanvas().render(e);
            iterator.remove();
        }
    }
    public void execute() {
        if(this.entries == null) return;
        this._thread_PhysicsProcess();
        this._thread_Process();
        this._thread_Render();
    }
}
