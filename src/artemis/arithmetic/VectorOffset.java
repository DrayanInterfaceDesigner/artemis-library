package artemis.arithmetic;

import artemis.Vector3;

public class VectorOffset extends Vector3 {
    public double offset;
    public VectorOffset(double x, double y, double offset) {
        super(x, y);
        this.offset = offset;
    }
}
