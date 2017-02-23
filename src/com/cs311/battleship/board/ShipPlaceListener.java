package com.cs311.battleship.board;

import com.cs311.battleship.board.ship.Ship;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Jeremiah on 2/20/2017.
 */
public class ShipPlaceListener implements EventHandler<MouseEvent> {

    private Board board;
    private Ship ship;

    public ShipPlaceListener(Board board, Ship ship) {
        this.board = board;
        this.ship = ship;
    }

    @Override
    public void handle(MouseEvent event) {
        board.setPlacing(true);
        board.setShipPlacing(ship);
    }
}
