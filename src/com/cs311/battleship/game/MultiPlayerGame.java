package com.cs311.battleship.game;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.player.Player;
import javafx.stage.Stage;

/**
 * Created by HP1 on 2/13/2017.
 */
public class MultiPlayerGame extends Game {

    public MultiPlayerGame(Stage stage) throws Exception {
        super(stage);
    }

    @Override
    public void makeMove(Player player, Board board, BoardCell cell) {
        super.makeMove(player, board, cell);
    }
}
