package com.cs311.battleship.game;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.board.BoardDisplay;
import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.console.ConsoleWriter;
import com.cs311.battleship.player.AiPlayer;
import com.cs311.battleship.player.LocalPlayer;
import com.cs311.battleship.ship.Direction;
import com.cs311.battleship.ship.Ship;
import javafx.stage.Stage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by HP1 on 2/13/2017.
 */
public class SingePlayerGame extends Game {

    public SingePlayerGame(Stage stage) throws Exception {
        super(stage);
        this.player = new LocalPlayer(this, new Board(getShips(), false));
        this.enemy = new AiPlayer(this, new Board(getShips(), true));
        BoardDisplay display = new BoardDisplay(this, player.getBoard(), enemy.getBoard());
        display.start(stage);

        ConsoleWriter.printLine("Welcome to battleship!");
        ConsoleWriter.printLine("Place your ships to begin the game.");

        placeEnemyShips();
    }

    @Override
    public void playerReady() {
        start();
    }

    @Override
    public void startNewGame() {
        try {
            new SingePlayerGame(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void placeEnemyShips() {
        for (Ship ship : enemy.getBoard().getShips()) {
            while (true) {
                BoardCell cell = enemy.getBoard().getRandomCell();
                if (cell.containsShip()) {
                    continue;
                }
                int x = cell.getX();
                int y = cell.getY();
                int length = ship.getLength();
                List<Direction> directions = enemy.getBoard().getAvailableDirections(x, y, length);
                if (directions.size() == 0) {
                    continue;
                }
                int randomDirection = ThreadLocalRandom.current().nextInt(0, directions.size());
                Direction direction = directions.get(randomDirection);
                enemy.getBoard().placeShip(ship, x, y, direction);
                enemy.getBoard().finalizeShip(ship);
                break;
            }
        }
        enemy.getBoard().getRandomCell();
    }
}
