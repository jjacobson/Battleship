package com.cs311.battleship.player;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.console.ConsoleWriter;

/**
 * Created by Jeremiah on 2/25/2017.
 */
public class LocalPlayer extends Player {

    public LocalPlayer(Board board) {
        super(board);
    }

    @Override
    public void takeTurn() {
        super.takeTurn();
        ConsoleWriter.printLine("It is now your turn.");
    }

}
