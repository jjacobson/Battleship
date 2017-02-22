package com.cs311.battleship.board;

import com.cs311.battleship.board.cell.BoardCell;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Jeremiah on 2/20/2017.
 */
public class CellClickListener implements EventHandler<MouseEvent> {

    private BoardDisplay display;
    private BoardCell cell;
    private Board board;


    public CellClickListener(BoardDisplay display, BoardCell cell, Board board) {
        this.display = display;
        this.cell = cell;
        this.board = board;
    }

    @Override
    public void handle(MouseEvent event) {
        if (display.isPlacingShip()) {
            // todo
        } else {

        }
    }
}
