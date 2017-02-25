package com.cs311.battleship.game;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.board.BoardDisplay;
import com.cs311.battleship.board.ship.Ship;
import com.cs311.battleship.console.ConsoleWriter;
import com.cs311.battleship.player.Player;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Game {

    protected Board playerBoard;
    protected Board enemyBoard;

    public Game(Stage stage) throws Exception {
        playerBoard = new Board(this);
        enemyBoard = new Board(this);
        BoardDisplay display = new BoardDisplay(this, playerBoard, enemyBoard);
        display.start(stage);

        ConsoleWriter.printLine("Hello world!");
    }

    public void makeMove(Player player) {

    }

    public List<Ship> getShips() {
        List<Ship> ships = new ArrayList<>();
        ships.add(new Ship(5));
        ships.add(new Ship(4));
        ships.add(new Ship(3));
        ships.add(new Ship(3));
        ships.add(new Ship(2));
        return ships;
    }

}
