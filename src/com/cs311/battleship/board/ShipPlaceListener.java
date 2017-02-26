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
        if (board.getShipInPlacement() == ship) {
            return;
        }
        if (board.inPlacementMode() && board.getShipInPlacement().isPlaced()) {
            display.updateShips(board.getShipInPlacement());
            board.finalizeShip(board.getShipInPlacement());
        }
        board.setPlacementMode(true);
        board.setShipInPlacement(ship);
    }
}
