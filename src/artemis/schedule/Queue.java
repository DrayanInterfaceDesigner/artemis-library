package artemis.schedule;

import artemis.game.Entity;
import artemis.game.Game;
import artemis.render.Camera;

import java.util.ArrayList;
import java.util.Iterator;

public class Queue {
    private ArrayList<Entity> entries;
    private Game game;
    private Camera camera;
    public Queue (Game game, Camera camera) {
        this.game = game;
        this.camera = camera;
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
    private void _thread_PhysicsProcess(long delta) {
        if(this.entries == null) return;
        for(Entity e : this.entries) {
            e._physicsProcess(delta);
        }
    }
    private void _thread_Process(long delta) {
        if(this.entries == null) return;
        for(Entity e : this.entries) {
            e._process(delta);
        }
    }
    private void _thread_Render(long delta) {
        if (this.entries == null) return;
        Iterator<Entity> iterator = this.entries.iterator();
        while (iterator.hasNext()) {
            Entity e = iterator.next();
            if(!(e.isHidden())) {
                this.game.getCamera().render(e);
            }
            iterator.remove();
        }
    }
    public void execute(long delta) {
        if(this.entries == null) return;
        this._thread_PhysicsProcess(delta);
        this._thread_Process(       delta);
        this._thread_Render(        delta);
    }
}
