package com.cs311.battleship.game;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.board.cell.CellColor;
import com.cs311.battleship.console.ConsoleWriter;
import com.cs311.battleship.player.Player;
import com.cs311.battleship.ship.Ship;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Game {

    protected Stage stage;

    protected Player player;
    protected Player enemy;
    protected boolean running;

    public Game(Stage stage) throws Exception {
        this.stage = stage;
        this.running = false;
    }

    public void playerReady() {
    }

    public void start() {
        this.running = true;
        // choose a random player to take their turn first
        int randomPlayer = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomPlayer == 0) {
            ConsoleWriter.printLine("You have been chosen to go first.");
            player.takeTurn();
        } else {
            ConsoleWriter.printLine("The enemy has been chosen to go first.");
            enemy.takeTurn();
        }
    }

    public void makeMove(Player player, Board board, BoardCell cell) {
        if (!running) {
            return;
        }
        cell.setGuessed(true);
        if (cell.containsShip()) {
            Ship ship = cell.getShip();
            cell.setColor(CellColor.HIT);
            ship.setHits(ship.getHits() + 1);
            if (board.isEnemy()) {
                playerHitEnemy(board, cell);
            } else {
                enemyHitPlayer(board, cell);
            }
        } else {
            cell.setColor(CellColor.MISS);
            if (board.isEnemy()) {
                playerMiss(board, cell);
            } else {
                enemyMiss(board, cell);
            }
        }
        if (board.isEnemy()) {
            getPlayer().setTurn(false);
            getEnemy().takeTurn();
        } else {
            getEnemy().setTurn(false);
            getPlayer().takeTurn();
        }
    }

    public void playerHitEnemy(Board board, BoardCell cell) {
        Ship ship = cell.getShip();
        if (ship.getHits() == ship.getLength()) {
            ConsoleWriter.printLine("You destroyed an enemy ship!");
            board.getShips().remove(ship);
            if (board.getShips().size() == 0) {
                endGame(true);
            }
        } else {
            ConsoleWriter.printLine("You hit an enemy ship!");
        }
    }

    public void enemyHitPlayer(Board board, BoardCell cell) {
        Ship ship = cell.getShip();
        if (ship.getHits() == ship.getLength()) {
            ConsoleWriter.printLine("The enemy has destroyed one of your ships!");
            board.getShips().remove(ship);
            if (board.getShips().size() == 0) {
                endGame(false);
            }
        } else {
            ConsoleWriter.printLine("The enemy has hit one of your ships!");
        }
    }

    public void playerMiss(Board board, BoardCell cell) {
        ConsoleWriter.printLine("Your shot has missed the enemy ships.");

    }

    public void enemyMiss(Board board, BoardCell cell) {
        ConsoleWriter.printLine("The enemy has missed.");

    }

    public void endGame(boolean win) {
        running = false;
        player.setTurn(false);
        enemy.setTurn(false);
        if (win) {
            ConsoleWriter.printLine("You have destroyed all the enemy ships and won the game!");
        } else {
            ConsoleWriter.printLine("All of your ships have been destroyed.");
        }
        showGameEndAlert(win);
    }

    private void showGameEndAlert(boolean win) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Over");
        if (win) {
            alert.setHeaderText("Congratulations, you defeated all the enemy ships and won the game!");
        } else {
            alert.setHeaderText("Sorry, all of your ships were defeated by the enemy.");
        }
        alert.setContentText("Would you like to start a new game?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            startNewGame();
        }
    }

    public void startNewGame() {}

    protected List<Ship> getShips() {
        List<Ship> ships = new ArrayList<>();
        ships.add(new Ship(5));
        ships.add(new Ship(4));
        ships.add(new Ship(3));
        ships.add(new Ship(3));
        ships.add(new Ship(2));
        return ships;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getEnemy() {
        return enemy;
    }

}
