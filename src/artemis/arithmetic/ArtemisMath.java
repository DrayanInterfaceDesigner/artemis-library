package artemis.arithmetic;

public class ArtemisMath {
    public ArtemisMath(){}
    public double lerp(double a, double b, double t) {
       return (1 - t) * a + t * b;
    }
}
