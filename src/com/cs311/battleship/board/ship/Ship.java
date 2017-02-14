package com.cs311.battleship.board.ship;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Ship {

    private int x;
    private int y;
    private Direction direction;

    public Ship(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
