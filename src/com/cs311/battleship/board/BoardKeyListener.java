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
        if (!board.isPlacing()) {
            return;
        }
        Ship ship = board.getShipPlacing();
        switch (event.getCode()) {
            case UP:
                board.placeShip(ship, ship.getX(), ship.getY(), Direction.NORTH);
                board.colorShip(ship, CellColor.SHIP);
                break;
            case DOWN:
                board.placeShip(ship, ship.getX(), ship.getY(), Direction.SOUTH);
                board.colorShip(ship, CellColor.SHIP);
                break;
            case RIGHT:
                board.placeShip(ship, ship.getX(), ship.getY(), Direction.EAST);
                board.colorShip(ship, CellColor.SHIP);
                break;
            case LEFT:
                board.placeShip(ship, ship.getX(), ship.getY(), Direction.WEST);
                board.colorShip(ship, CellColor.SHIP);
                break;
            case ENTER:
                if (board.isPlaced()) {
                    board.finalizeShip(ship);
                    display.updateShips(ship);
                }
                break;
        }
    }
}
