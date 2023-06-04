package artemis.controller;

import artemis.Vector3;

public class MouseEventReturnee {
    private Vector3 clickedAt;
    private boolean RIGHT;
    private boolean LEFT;
    private boolean MIDDLE;
    private int button;
    private int clickCount;
    private Object target;
    public MouseEventReturnee(
            Vector3 clickedAt,
            boolean RIGHT,
            boolean LEFT,
            boolean MIDDLE,
            int button,
            int clickCount,
            Object target)
    {
        this.clickedAt = clickedAt;
        this.RIGHT = RIGHT;
        this.LEFT = LEFT;
        this.MIDDLE = MIDDLE;
        this.button = button;
        this.clickCount = clickCount;
        this.target = target;

    }

    public int getClickCount() {
        return clickCount;
    }
    public Vector3 getClickedAt() {
        return clickedAt;
    }
    public Object getTarget() {
        return target;
    }
    public boolean isRIGHT() {
        return RIGHT;
    }
    public boolean isLEFT() {
        return LEFT;
    }
    public boolean isMIDDLE() {
        return MIDDLE;
    }
    public int getButton() {
        return this.button;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public void setClickedAt(Vector3 clickedAt) {
        this.clickedAt = clickedAt;
    }

    public void setLEFT(boolean LEFT) {
        this.LEFT = LEFT;
    }

    public void setRIGHT(boolean RIGHT) {
        this.RIGHT = RIGHT;
    }

    public void setMIDDLE(boolean MIDDLE) {
        this.MIDDLE = MIDDLE;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
