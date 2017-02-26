package com.cs311.battleship.player;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.game.Game;

/**
 * Created by Jeremiah on 2/25/2017.
 */
public class AiPlayer extends Player {

    private boolean lastHit; // last move a hit?
    private boolean knowDirection;
    private BoardCell lastCell; // last guessed cell

    public AiPlayer(Game game, Board board) {
        super(game, board);
    }

    @Override
    public void takeTurn() {
        super.takeTurn();

        Board enemyBoard = getGame().getPlayer().getBoard();
        BoardCell cell;
        while (true) {
            cell = enemyBoard.getRandomCell();
            if (!cell.isGuessed()) {
                break;
            }
        }
        getGame().makeMove(this, enemyBoard, cell);
    }
}
