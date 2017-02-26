package com.cs311.battleship.board;

import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.board.cell.CellColor;
import com.cs311.battleship.ship.Direction;
import com.cs311.battleship.ship.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.cs311.battleship.ship.Direction.*;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Board {

    private int width;
    private int height;
    private List<List<BoardCell>> board;
    private List<Ship> ships;
    private boolean enemy;

    // for placing ships at game start
    private Ship shipPlacing;
    private boolean placing;
    private boolean placed;

    public Board(List<Ship> ships, boolean enemy) {
        this(ships, enemy, 10, 10);
    }

    public Board(List<Ship> ships, boolean enemy, int width, int height) {
        this.enemy = enemy;
        this.width = width;
        this.height = height;
        this.ships = ships;
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
        return !(x > width - 1 || x < 0 || y > height - 1 || y < 0);
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

    public BoardCell getRandomCell() {
        int x = ThreadLocalRandom.current().nextInt(0, width);
        int y = ThreadLocalRandom.current().nextInt(0, height);
        return board.get(x).get(y);
    }

    public boolean placeShip(Ship ship, int x, int y) {
        List<Direction> directions = getAvailableDirections(x, y, ship.getLength());
        if (directions.size() == 0) {
            return false;
        }
        return placeShip(ship, x, y, directions.get(0));
    }

    public boolean placeShip(Ship ship, int x, int y, Direction direction) {
        List<Direction> directions = getAvailableDirections(x, y, ship.getLength());
        if (!directions.contains(direction)) {
            return false;
        }
        if (isPlaced()) {
            removeShip(getShipPlacing());
        }
        ship.setDirection(direction);
        ship.setX(x);
        ship.setY(y);
        setPlaced(true);
        return true;
    }

    public void colorShip(Ship ship, String color) {
        for (BoardCell cell : getCells(ship)) {
            cell.setColor(color);
        }
    }

    public void finalizeShip(Ship ship) {
        for (BoardCell cell : getCells(ship)) {
            cell.setContainsShip(true);
            cell.setShip(ship);
        }
        // reset placing states
        setPlacing(false);
        setPlaced(false);
        setShipPlacing(null);
    }

    public void removeShip(Ship ship) {
        for (BoardCell cell : getCells(ship)) {
            cell.setColor(CellColor.WATER);
        }
        setPlaced(false);
    }

    public List<Direction> getAvailableDirections(int x, int y, int length) {
        List<Direction> directions = new ArrayList<>(Arrays.asList(NORTH, SOUTH, EAST, WEST));
        for (int i = 0; i < length; i++) {
            // north
            if (!validCell(x, y - i) || cellOccupied(x, y - i)) {
                directions.remove(NORTH);
            }
            // south
            if (!validCell(x, y + i) || cellOccupied(x, y + i)) {
                directions.remove(SOUTH);
            }
            // east
            if (!validCell(x + i, y) || cellOccupied(x + i, y)) {
                directions.remove(EAST);
            }
            // west
            if (!validCell(x - i, y) || cellOccupied(x - i, y)) {
                directions.remove(WEST);
            }
        }
        return directions;
    }

    private List<BoardCell> getCells(Ship ship) {
        List<BoardCell> cells = new ArrayList<>();
        int x = ship.getX();
        int y = ship.getY();
        for (int i = 0; i < ship.getLength(); i++) {
            BoardCell cell = null;
            switch (ship.getDirection()) {
                case NORTH:
                    cell = getCell(x, y - i);
                    break;
                case SOUTH:
                    cell = getCell(x, y + i);
                    break;
                case EAST:
                    cell = getCell(x + i, y);
                    break;
                case WEST:
                    cell = getCell(x - i, y);
                    break;
            }
            cells.add(cell);
        }
        return cells;
    }

    public Ship getShipPlacing() {
        return shipPlacing;
    }

    public void setShipPlacing(Ship ship) {
        this.shipPlacing = ship;
    }

    public boolean isPlacing() {
        return placing;
    }

    public void setPlacing(boolean placing) {
        this.placing = placing;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    public boolean isEnemy() {
        return enemy;
    }

    public List<Ship> getShips() {
        return ships;
    }
}
