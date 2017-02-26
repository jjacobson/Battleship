package com.cs311.battleship.board;

import com.cs311.battleship.ship.Ship;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Jeremiah on 2/20/2017.
 */
public class ShipPlaceListener implements EventHandler<MouseEvent> {

    private BoardDisplay display;
    private Board board;
    private Ship ship;

    public ShipPlaceListener(BoardDisplay display, Board board, Ship ship) {
        this.display = display;
        this.board = board;
        this.ship = ship;
    }

    @Override
    public void handle(MouseEvent event) {
        if (board.getShipPlacing() == ship) {
            return;
        }
        if (board.isPlacing() && board.isPlaced()) {
            display.updateShips(board.getShipPlacing());
            board.finalizeShip(board.getShipPlacing());
        }
        board.setPlacing(true);
        board.setShipPlacing(ship);
    }
}
