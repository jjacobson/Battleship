package com.cs311.battleship.board;

import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.board.cell.CellColor;
import com.cs311.battleship.board.ship.Direction;
import com.cs311.battleship.board.ship.Ship;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP1 on 2/13/2017.
 */
@SuppressWarnings("Duplicates")
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

    /**
     * Determine if a cell is a valid cell on the board
     *
     * @param x value of cell
     * @param y value of cell
     * @return whether or not the cell is on the board
     */
    public boolean validCell(int x, int y) {
        return !(x > width || y > height);
    }

    /**
     * Determine if a cell is occupied by a ship
     *
     * @param x value of cell
     * @param y value of cell
     * @return whether or not the cell is occupied
     */
    public boolean cellOccupied(int x, int y) {
        return getCell(x, y).containsShip();
    }

    public void placeShip(Ship ship, int x, int y) {

    }

    public void placeShip(Ship ship, int x, int y, Direction direction) {

    }

    public void removeShip(Ship ship) {

    }

    public void finalizeShip(Ship ship) {

    }

    public boolean validShipLocation(Ship ship) {
        int x = ship.getX();
        int y = ship.getY();
        switch (ship.getDirection()) {
            case NORTH:
                for (int i = 0; i < ship.getLength(); i++) {
                    if (!validCell(x, y + i)) {
                        return false;
                    }
                    if (cellOccupied(x, y + i)) {
                        return false;
                    }
                }
                break;
            case SOUTH:
                for (int i = 0; i < ship.getLength(); i++) {
                    if (!validCell(x, y - i)) {
                        return false;
                    }
                    if (cellOccupied(x, y - i)) {
                        return false;
                    }
                }
                break;
            case EAST:
                for (int i = 0; i < ship.getLength(); i++) {
                    if (!validCell(x + i, y)) {
                        return false;
                    }
                    if (cellOccupied(x + i, y)) {
                        return false;
                    }
                }
                break;
            case WEST:
                for (int i = 0; i < ship.getLength(); i++) {
                    if (!validCell(x - i, y)) {
                        return false;
                    }
                    if (cellOccupied(x - i, y)) {
                        return false;
                    }
                }
                break;
        }
        return true;
    }

    /**
     * Display a ship on the board
     * We use this to display ships as they are being placed
     * Ship placement validation expected before calling
     *
     * @param ship to display
     */
    public void displayShip(Ship ship) {
        switch (ship.getDirection()) {
            case NORTH:
                for (int i = 0; i < ship.getLength(); i++) {
                    board.get(ship.getX()).get(ship.getY() + i).setColor(CellColor.SHIP);
                }
                break;
            case SOUTH:
                for (int i = 0; i < ship.getLength(); i++) {
                    board.get(ship.getX()).get(ship.getY() - i).setColor(CellColor.SHIP);
                }
                break;
            case EAST:
                for (int i = 0; i < ship.getLength(); i++) {
                    board.get(ship.getX() + i).get(ship.getY()).setColor(CellColor.SHIP);
                }
                break;
            case WEST:
                for (int i = 0; i < ship.getLength(); i++) {
                    board.get(ship.getX() - i).get(ship.getY()).setColor(CellColor.SHIP);
                }
        }
    }



}
