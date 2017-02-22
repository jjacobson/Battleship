package com.cs311.battleship.board;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
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
        if (!display.isPlacingShip()) {
            return;
        }
        switch (event.getCode()) {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
            case ENTER:
        }
    }
}
