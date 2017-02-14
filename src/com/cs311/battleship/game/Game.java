package com.cs311.battleship.game;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.board.BoardDisplay;
import javafx.stage.Stage;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Game {

    public Game(Stage menuStage) throws Exception {
        Board board = new Board();
        BoardDisplay display = new BoardDisplay();
        display.start(menuStage);

    }

}
