package com.cs311.battleship.player;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.console.ConsoleWriter;
import com.cs311.battleship.game.Game;

/**
 * Created by Jeremiah on 2/25/2017.
 */
public class LocalPlayer extends Player {

    public LocalPlayer(Game game, Board board) {
        super(game, board);
    }

    @Override
    public void takeTurn() {
        super.takeTurn();
        ConsoleWriter.printLine("It is now your turn.");
    }

}
