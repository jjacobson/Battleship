package com.cs311.battleship.board.ship;

import com.cs311.battleship.board.BoardController;
import com.cs311.battleship.board.cell.BoardCell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Ship {

    private int x;
    private int y;
    private int length;
    private Direction direction;
    private boolean placed;

    public Ship(int length) {
        this.length = length;
        this.placed = false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isPlaced() {
        return placed;
    }
}
