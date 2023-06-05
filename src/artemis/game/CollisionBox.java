package artemis.game;

import artemis.Vector3;
import artemis.arithmetic.ArtemisMath;
import artemis.arithmetic.VectorOffset;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class CollisionBox extends Entity implements IEntity{
    private Grid collisionGrid;
    private Entity entity;
    private double[][] boundingBox;
    public Color color;
    public ArrayList<Entity> collidingWith;
    public double lastCollisionOffset;
    public CollisionBox(Game game, Vector3 position, double[] size, Grid collisionGrid, Entity entity) {
        super(game, position, size);
        this.collisionGrid = collisionGrid;
        this.entity = entity;
        this.boundingBox = this.calcBoundingBox();
        this.collidingWith = new ArrayList<Entity>();
        this.color = new Color(0,255,0);
    }
    public double[][] calcBoundingBox() {
        if(this.size == null) {
            return new double[][]{
                    {0,0},
                    {0,0},
                    {0,0},
                    {0,0}
            };
        };

        return new double[][]{
                {this.position.x + 0, this.position.y + 0},
                {this.position.x + this.size[0], this.position.y + 0},
                {this.position.x + this.size[0], this.position.y + this.size[1]},
                {this.position.x + 0, this.position.y + this.size[1]}
        };
    }

    public VectorOffset calcLineIntersection(double[] a, double[] b, double[] c, double[] d) {

        double tTop = (d[0] - c[0]) * (a[1] - c[1]) - (d[1] - c[1]) * (a[0] - c[0]);
        double uTop = (c[1] - a[1]) * (a[0] - b[0]) - (c[0] - a[0]) * (a[1] - b[1]);
        double bottom = (d[1] - c[1]) * (b[0] - a[0]) - (d[0] - c[0]) * (b[1] - a[1]);

        if(bottom != 0) {
            double t = tTop / bottom;
            double u = uTop / bottom;

            if(t >= 0 && t <= 1 && u >= 0 && u <= 1) {
                ArtemisMath math = new ArtemisMath();
                this.lastCollisionOffset = t;
                return new VectorOffset(
                        math.lerp(a[0], b[0], t),
                        math.lerp(a[1], b[1], t),
                        t
                );
            }
        }
        return null;
    }

    public boolean calcRoughInternalIntersection(Entity target) {
        if(this.position.x + this.size[0] >= target.position.x
                && this.position.x + this.size[0] <= target.position.x + target.size[0]) {
            System.out.println(this.position.x + this.size[0] + "/" +target.position.x + " " + this.position.x + this.size[0] + "/" + target.position.x + target.size[0]);
            return this.position.y + this.size[1] >= target.position.y
                    && this.position.y + this.size[1] <= target.position.y + target.size[1];
        }
        return false;
    }

    public boolean checkCollision(Entity target) {
        if(target.collisionBox == null) return false;
        double[][] polyA = this.calcBoundingBox();
        double[][] polyB = target.collisionBox.calcBoundingBox();
        double[] a = polyA[0];
        double[] b = polyA[1];
        double[] c = polyB[0];
        double[] d = polyB[1];
        for(int i = 0; i < polyA.length; i++) {
            for(int k = 0; k < polyB.length; k++) {
                VectorOffset touch = this.calcLineIntersection(
                        polyA[i],
                        polyA[(i + 1) % polyA.length],
                        polyB[k],
                        polyB[(k+1) % polyB.length]
                );
                if(touch != null) {
                    this.color = new Color(255,0,0);
                    target.collisionBox.color = new Color(0,0,255);
                    return true;
                }
            }
        }
        this.color = new Color(0,255,0);
        target.collisionBox.color = new Color(0,0,0);
        return false;
    }
    public boolean isColliding(){
        int collCounter = 0;
//        this.collisionGrid.getCell(this.entity)
        for(Entity e : this.game.entities) {
            if(this.entity == e) continue;
            if(this.checkCollision(e)) {
                addCollision(e);
                collCounter++;
                System.out.println("Entity collided: " + e);
            }
            else {
                if(this.collidingWith.contains(e)) {
                    this.collidingWith.remove(e);
                }
            }
        }
        return collCounter > 0;
    }
    private void addCollision(Entity target) {
        if(!(this.collidingWith.contains(target))) {
            this.collidingWith.add(target);
        }
    }
    @Override
    public void _onReady() {}

    @Override
    public void _physicsProcess(long delta) {

    }
    @Override
    public void _process(long delta) {
        this.boundingBox = this.calcBoundingBox();
    }
    @Override
    public boolean isOnScreen() {
        return false;
    }

    @Override
    public void render(Graphics2D ctx) {

        for(int p = 1; p < this.boundingBox.length + 1; p++){
            int i = p > (this.boundingBox.length -1) ? 0 : p;
            Path2D path = new Path2D.Double();
            ctx.setColor(this.color);
            ctx.setStroke(new BasicStroke(5));
            path.moveTo(this.boundingBox[p-1][0], this.boundingBox[p-1][1]);
            path.lineTo(this.boundingBox[i][0], this.boundingBox[i][1]);
            path.closePath();
            ctx.draw(path);
        }

    }
}
