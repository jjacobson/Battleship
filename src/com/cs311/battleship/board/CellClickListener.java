package com.cs311.battleship.board;

import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.board.cell.CellColor;
import com.cs311.battleship.console.ConsoleWriter;
import com.cs311.battleship.game.Game;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Jeremiah on 2/20/2017.
 */
public class CellClickListener implements EventHandler<MouseEvent> {

    private Game game;
    private Board board;
    private BoardCell cell;

    public CellClickListener(Game game, Board board, BoardCell cell) {
        this.game = game;
        this.board = board;
        this.cell = cell;
    }

    @Override
    public void handle(MouseEvent event) {
        if (board.isPlacing() && !board.isEnemy()) {
            if (board.placeShip(board.getShipPlacing(), cell.getX(), cell.getY())) {
                board.colorShip(board.getShipPlacing(), CellColor.SHIP);
            } else {
                ConsoleWriter.printLine("There is no space for a ship there.");
            }
            return;
        }
        if (board.isEnemy()) {
            makeMove();
        }
    }

    private void makeMove() {
        if (!game.getPlayer().isTurn()) {
            ConsoleWriter.printLine("It's not your turn yet.");
            return;
        }
        if (cell.isGuessed()) {
            ConsoleWriter.printLine("You have already fired at that tile!");
            return;
        }
        game.makeMove(game.getPlayer(), board, cell);
    }
}
