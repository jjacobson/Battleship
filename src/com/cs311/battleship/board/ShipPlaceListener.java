package com.cs311.battleship.board;

import com.cs311.battleship.board.ship.Ship;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Jeremiah on 2/20/2017.
 */
public class ShipPlaceListener implements EventHandler<MouseEvent> {

    private BoardDisplay display;
    private Ship ship;

    public ShipPlaceListener(BoardDisplay display, Ship ship) {
        this.display = display;
        this.ship = ship;
    }

    @Override
    public void handle(MouseEvent event) {
        display.setPlacingShip(true);
        display.setShipPlacing(ship);
    }
}
