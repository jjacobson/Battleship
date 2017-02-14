package com.cs311.battleship.board;

import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.board.ship.Direction;
import com.cs311.battleship.board.ship.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Board {

    private int width;
    private int height;
    private List<List<BoardCell>> board;

    public Board() {
        this(10, 10);
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new ArrayList<>();
        for (int x = 0; x < width; x++) {
            board.add(new ArrayList<>());
            for (int y = 0; y < height; y++) {
                BoardCell cell = new BoardCell(x, y);
                board.get(x).add(cell);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BoardCell getCell(int x, int y) {
        return board.get(x).get(y);
    }

    public void displayShip(Ship ship) {

    }
}
