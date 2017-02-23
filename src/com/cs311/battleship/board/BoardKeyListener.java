package com.cs311.battleship.board;

import com.cs311.battleship.board.ship.Direction;
import com.cs311.battleship.board.ship.Ship;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by HP1 on 2/22/2017.
 */
public class BoardKeyListener implements EventHandler<KeyEvent> {

    private Board board;

    public BoardKeyListener(Board board) {
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
                break;
            case DOWN:
                board.placeShip(ship, ship.getX(), ship.getY(), Direction.SOUTH);
                break;
            case RIGHT:
                board.placeShip(ship, ship.getX(), ship.getY(), Direction.EAST);
                break;
            case LEFT:
                board.placeShip(ship, ship.getX(), ship.getY(), Direction.WEST);
                break;
            case ENTER:
                board.finalizeShip(ship);
                break;
        }
    }
}
