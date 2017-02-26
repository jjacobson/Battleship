package com.cs311.battleship.board;

import com.cs311.battleship.board.cell.CellColor;
import com.cs311.battleship.ship.Direction;
import com.cs311.battleship.ship.Ship;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * Created by HP1 on 2/22/2017.
 */
public class BoardKeyListener implements EventHandler<KeyEvent> {

    private BoardDisplay display;
    private Board board;

    public BoardKeyListener(BoardDisplay display, Board board) {
        this.display = display;
        this.board = board;
    }

    @Override
    public void handle(KeyEvent event) {
        if (!board.inPlacementMode()) {
            return;
        }
        Ship ship = board.getShipInPlacement();
        boolean placed = false;
        switch (event.getCode()) {
            case UP:
                placed = board.placeShip(ship, ship.getX(), ship.getY(), Direction.NORTH);
                break;
            case DOWN:
                placed = board.placeShip(ship, ship.getX(), ship.getY(), Direction.SOUTH);
                break;
            case RIGHT:
                placed = board.placeShip(ship, ship.getX(), ship.getY(), Direction.EAST);
                break;
            case LEFT:
                placed = board.placeShip(ship, ship.getX(), ship.getY(), Direction.WEST);
                break;
            case ENTER:
                if (ship.isPlaced()) {
                    board.finalizeShip(ship);
                    display.updateShips(ship);
                }
                break;
        }
        if (placed) {
            board.colorShip(ship, CellColor.SHIP);
        }
    }
}
