package com.cs311.battleship.game;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.board.cell.CellColor;
import com.cs311.battleship.console.ConsoleWriter;
import com.cs311.battleship.player.Player;
import com.cs311.battleship.ship.Ship;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by HP1 on 2/13/2017.
 */
public class Game {

    protected Player player;
    protected Player enemy;

    public Game(Stage stage) throws Exception {
    }

    public void playerReady() {
    }

    public void start() {
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
    }

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
