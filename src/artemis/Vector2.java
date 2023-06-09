package artemis;

public class Vector2 {

    public double x;
    public double y;
    public Vector2 UP;
    public Vector2 DOWN;
//    private ArrayList<Vertex>

    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 vec2) {
        this.x += vec2.x;
        this.y += vec2.y;
    }
    public void sub(Vector2 vec2) {
        this.x -= vec2.x;
        this.y -= vec2.y;
    }
    public void multiply(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }
    public void divide(double scalar) {
        if (scalar != 0) {
            this.x /= scalar;
            this.y /= scalar;
        }
    }
    public double mag() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    public void normalize(){
        double magnitude = this.mag();
        if (magnitude != 0) {
            this.divide(magnitude);
        }
    }
    public void limit(double max) {
        double magnitude = this.mag();
        if (magnitude > max) {
            this.divide(magnitude);
            this.multiply(max);
        }
    }
    public double distance(Vector2 vec2){
        double dx = vec2.x - this.x;
        double dy = vec2.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double dot(Vector2 vec2) {
        return this.x * vec2.x + this.y * vec2.y;
    }
    public double cross(Vector2 vec2) {
        return this.x * vec2.y - this.y * vec2.x;
    }

//    Static methods.
    public static Vector2 add(Vector2 vec1, Vector2 vec2) {
        return new Vector2(vec1.x + vec2.x, vec1.y + vec2.y);
    }
    public static Vector2 sub(Vector2 vec1, Vector2 vec2) {
        return new Vector2(vec1.x - vec2.x, vec1.y - vec2.y);
    }
    public static Vector2 multiply(Vector2 vec1, double scalar) {
        return new Vector2(vec1.x * scalar, vec1.y * scalar);
    }
    public static Vector2 divide(Vector2 vec1, Vector2 vec2, double scalar) {
        if (scalar != 0) {
            return new Vector2(vec2.x / scalar, vec2.y / scalar);
        }
        return new Vector2(0,0);
    }
    public static double distance(Vector2 vec1, Vector2 vec2) {
        double dx = vec2.x - vec1.x;
        double dy = vec2.y - vec1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public static double dot(Vector2 vec1, Vector2 vec2) {
        return vec1.x * vec2.x + vec1.y * vec2.y;
    }
    public static double cross(Vector2 vec1, Vector2 vec2) {
        return vec1.x * vec2.y - vec1.y * vec2.x;
    }

}
