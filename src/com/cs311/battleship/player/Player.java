package com.cs311.battleship.player;

import com.cs311.battleship.board.Board;

/**
 * Created by HP1 on 2/20/2017.
 */
public class Player {

    private Board board;
    private boolean turn;

    public Player(Board board) {
        this.board = board;
        this.turn = false;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void takeTurn() {
        setTurn(true);
    }

}
