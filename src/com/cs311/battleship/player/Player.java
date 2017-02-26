package com.cs311.battleship.player;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.game.Game;

/**
 * Created by HP1 on 2/20/2017.
 */
public class Player {

    private Game game;
    private Board board;
    private boolean turn;

    public Player(Game game, Board board) {
        this.game = game;
        this.board = board;
        this.turn = false;
    }

    public Board getBoard() {
        return board;
    }

    public Game getGame() {
        return game;
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
