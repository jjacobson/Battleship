package com.cs311.battleship.player;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.board.cell.BoardCell;

/**
 * Created by Jeremiah on 2/25/2017.
 */
public class AiPlayer extends Player {

    private boolean lastHit; // last move a hit?
    private BoardCell lastCell; // last guessed cell

    public AiPlayer(Board board) {
        super(board);
    }

    @Override
    public void takeTurn() {
        super.takeTurn();
        if (lastHit) {

        } else {

        }
    }
}
