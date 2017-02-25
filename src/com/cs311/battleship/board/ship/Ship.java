package com.cs311.battleship.board.ship;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Ship {

    private int x;
    private int y;
    private int length;
    private Direction direction;

    public Ship(int length) {
        this.length = length;
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

}
