package artemis.exception;

public class SceneOutOfRange extends Exception{
    public SceneOutOfRange() {
        super();
    }
    public SceneOutOfRange(String message) {
        super(message);
    }
    public SceneOutOfRange(String message, Throwable cause) {
        super(message, cause);
    }
}
