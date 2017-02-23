package com.cs311.battleship.board;

import com.cs311.battleship.board.cell.BoardCell;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Jeremiah on 2/20/2017.
 */
public class CellClickListener implements EventHandler<MouseEvent> {

    private Board board;
    private BoardCell cell;

    public CellClickListener(BoardCell cell, Board board) {
        this.board = board;
        this.cell = cell;
    }

    @Override
    public void handle(MouseEvent event) {
        if (board.isPlacing()) { // todo check which board
            board.placeShip(board.getShipPlacing(), cell.getX(), cell.getY());
            return;
        }
    }
}
