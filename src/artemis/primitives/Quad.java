package artemis.primitives;


import java.util.ArrayList;

public class Quad {
    private Tri abc;
    private Tri cdb;
    private ArrayList<Tri> tris;
    public Quad(Tri abc, Tri cdb) {
        this.abc = abc;
        this.cdb = cdb;
        this.tris = new ArrayList<Tri>();
        this.mount();
    }
    private void mount (){
        this.tris.add(this.abc);
        this.tris.add(this.cdb);
    }

    public ArrayList<Tri> getTris() {
        return tris;
    }
}
