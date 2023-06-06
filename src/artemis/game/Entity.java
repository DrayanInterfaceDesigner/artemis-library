package artemis.game;

import artemis.Vector3;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity implements IEntity{
    protected Game game;
    public Vector3 position;
    public Vector3 center;
    protected Vector3 cameraPosition;
    private boolean hidden;
    public CollisionBox collisionBox;
    private ArrayList<Entity> children;
    protected double[] size;
    public Entity(Game game, Vector3 position, double[] size) {
        this.game = game;
        this.position = position;
        this.size = size;
        this.center = new Vector3(
                this.position.x - this.size[0]/2,
                this.position.y - this.size[1]/2
        );
        this.children = new ArrayList<Entity>();
    }

    public void pushToGame() {
        this.game.add(this);
    }
    public void setCameraPosition(Vector3 position) {
        this.cameraPosition = position;
    }
    public void getReady() {
        this.pushToGame();
//        this.getFamilyReady();
        this._onReady();
    }
    public abstract void _onReady();
    public abstract void _physicsProcess(long delta);
    public abstract void _process(long delta);
    public abstract void render(Graphics2D ctx);

    public boolean isHidden() {
        return this.hidden;
    }

    public void addChild (Entity e) {
        if(!this.children.contains(e)) {
            this.children.add(e);
        }
    }
    public void destroyChild(Entity e) {
        if(this.children.contains(e)) {
            if(this.game.getEntities().contains(e)) {
                this.game.destroy(e);
            }
            this.children.remove(e);
        }
    }
    public void dangerouslyRemoveChild(Entity e) {
        if(this.children.contains(e)) {
            this.children.remove(e);
        }
    }
    public void getFamilyReady() {
        for(Entity e : this.children) {
            e.getReady();
        }
    }
    public ArrayList<Entity> getChildren() {
        return this.children;
    }
    public void hide(boolean status) {
        this.hidden = status;
        for(Entity child : this.children) {
            child.hide(status);
        }
    }
    public void destroy(){
        this.game.destroy(this);
    }
}
