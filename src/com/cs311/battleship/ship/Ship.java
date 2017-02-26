package com.cs311.battleship.ship;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Ship {

    private int x;
    private int y;
    private int length;
    private int hits;
    private Direction direction;

    public Ship(int length) {
        this.length = length;
        this.hits = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLength() {
        return length;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
