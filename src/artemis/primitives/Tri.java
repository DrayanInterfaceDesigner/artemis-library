package artemis.primitives;

import java.awt.*;

public class Tri {
    public Vertex a;
    public Vertex b;
    public Vertex c;
    private Color color;

    public Tri(Vertex a, Vertex b, Vertex c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
