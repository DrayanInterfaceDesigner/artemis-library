package artemis.arithmetic;

import artemis.Vector2;

public class VectorOffset extends Vector2 {
    public double offset;
    public VectorOffset(double x, double y, double offset) {
        super(x, y);
        this.offset = offset;
    }
}
