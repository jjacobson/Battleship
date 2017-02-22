package com.cs311.battleship.game;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.board.BoardDisplay;
import com.cs311.battleship.player.Player;
import javafx.stage.Stage;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Game {

    private Board playerBoard;
    private Board enemyBoard;

    public Game(Stage menuStage) throws Exception {
        playerBoard = new Board();
        enemyBoard = new Board();
        BoardDisplay display = new BoardDisplay();
        //board.setBoard(display.getBoard());
        display.start(menuStage, playerBoard, enemyBoard);
    }

    public void makeMove(Player player) {

    }

}
