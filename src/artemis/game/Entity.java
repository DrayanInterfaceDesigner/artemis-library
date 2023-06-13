package artemis.game;

import artemis.Vector2;
import artemis.render.Scene;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity implements IEntity{
    protected Game game;
    protected Scene scene;
    public Vector2 position;
    public Vector2 center;
    public boolean paused = false;
    private int cellAt;
    protected Vector2 cameraPosition;
    private boolean hidden;
    public CollisionBox collisionBox;
    private ArrayList<Entity> children;
    public double[] size;
    public Entity(Game game, Scene scene, Vector2 position, double[] size) {
        this.game = game;
        this.scene = scene;
        this.position = position;
        this.size = size;
        this.center = new Vector2(
                this.position.x - this.size[0]/2,
                this.position.y - this.size[1]/2
        );
        this.children = new ArrayList<Entity>();
    }

    public void pushToGame() {
        this.scene.add(this);
    }
    public void setCameraPosition(Vector2 position) {
        this.cameraPosition = position;
    }
    public void getReady() {
        this.pushToGame();

//        this.getFamilyReady();
//        this.floorRay.getReady();
        this._onReady();
    }
    public abstract void _onReady();
    public abstract void _physicsProcess(double delta);
    public abstract void _process(double delta);
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

    public int getCellAt() {
        return cellAt;
    }

    public void setCellAt(int cellAt) {
        this.cellAt = cellAt;
    }
}
