package model;


public class Ship {

    private final int length;
    private final Direction direction;
    private final int originX;
    private final int originY;
    private int hits = 0;


    public Ship(int x, int y, int length, Direction direction) {
        this.length = length;
        this.direction = direction;
        this.originX = x;
        this.originY = y;
    }

    public void hit() {
        hits++;
    }

    public boolean isDestroyed() {
        return hits == length;
    }

    public int getOriginX() {
        return originX;
    }

    public int getOriginY() {
        return originY;
    }

    public int getLength() {
        return length;
    }

    public Direction getDirection() {
        return direction;
    }

    public enum Direction {
        HORIZONTAL,
        VERTICAL
    }
}
