package com.cs311.battleship.game;

import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.board.cell.CellColor;
import com.cs311.battleship.board.ship.Direction;
import com.cs311.battleship.board.ship.Ship;
import com.cs311.battleship.player.Player;
import javafx.stage.Stage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by HP1 on 2/13/2017.
 */
public class SingePlayerGame extends Game {

    public SingePlayerGame(Stage menuStage) throws Exception {
        super(menuStage);
        placeEnemeyShips();
    }

    @Override
    public void makeMove(Player player) {
        super.makeMove(player);
    }

    public void placeEnemeyShips() {
        for (Ship ship : getShips()) {
            while (true) {
                BoardCell cell = enemyBoard.getRandomCell();
                if (cell.containsShip()) {
                    continue;
                }
                int x = cell.getX();
                int y = cell.getY();
                int length = ship.getLength();
                List<Direction> directions = enemyBoard.getAvailableDirections(x, y, length);
                if (directions.size() == 0) {
                    continue;
                }
                int randomDirection = ThreadLocalRandom.current().nextInt(0, directions.size());
                Direction direction = directions.get(randomDirection);
                enemyBoard.placeShip(ship, x, y, direction);
                enemyBoard.finalizeShip(ship);
                break;
            }
        }
        enemyBoard.getRandomCell();
    }
}
