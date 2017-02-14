package com.cs311.battleship.board.ship;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Ship {

    private int x;
    private int y;
    private int length;
    private Direction direction;

    public Ship(int x, int y, int length, Direction direction) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public Direction getDirection() {
        return direction;
    }
}
