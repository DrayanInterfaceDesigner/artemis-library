package artemis.game;

import java.util.ArrayList;

public class Grid {
    private int[] size;
    private int[] offset;
    private int[] cellSize;
    private int cellLen;
    private int offset_dx;
    private int offset_dy;
    private ArrayList<ArrayList<Entity>> flatGrid;
    public Grid(int[] size, int[]offset, int cellDivisor) {
        this.size = size;
        this.offset = offset;
        this.cellSize = new int[]{
                (int) (this.size[0]/cellDivisor),
                (int) (this.size[1]/cellDivisor)
        };
        this.cellLen = cellDivisor*cellDivisor;
        this.flatGrid = new ArrayList<>();
        this.populateGrid();
        this.calcOffsetDeviation();
    }

    private void populateGrid() {
        for(int x = 0; x < cellLen*cellLen; x++) {
            ArrayList<Entity> a = new ArrayList<>();
            this.flatGrid.add(a);
        }
    }

    public void push(Entity e, int at) {
        if(at < 0) return;
        if(at > this.flatGrid.size()-1) return;
//        System.out.println("entered: "  + e);
        for(ArrayList<Entity> a : this.flatGrid) {
            if(a.contains(e) && a != (this.flatGrid.get(at))) {
                a.remove(e);
                return;
            }
        }
        if(!(this.flatGrid.get(at).contains(e))) {
            this.flatGrid.get(at).add(e);
        }
    }
    private void calcOffsetDeviation() {
        this.offset_dx = (this.offset[0] - this.size[0])/2;
        this.offset_dy = (this.offset[1] - this.size[1])/2;
    }

    public ArrayList<ArrayList<Entity>> getList() {
        return this.flatGrid;
    }
    public ArrayList<Entity> neighboursAt(int at) {
        if(at > this.flatGrid.size() -1) return null;
        return this.flatGrid.get(at);
    }
    public int getOffset_dx() {
        return offset_dx;
    }

    public int getOffset_dy() {
        return offset_dy;
    }

    public int getCellWidth(){
        return this.cellSize[0];
    }

    public int getCellHeight(){
        return this.cellSize[1];
    }
}
