package com.cs311.battleship.player;

import com.cs311.battleship.board.Board;
import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.game.Game;
import com.cs311.battleship.ship.Direction;
import com.cs311.battleship.ship.Ship;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.cs311.battleship.ship.Direction.*;

/**
 * Created by Jeremiah on 2/25/2017.
 */
public class AiPlayer extends Player {

    private AiState state;
    private boolean reverse;

    private List<BoardCell> previousHits;

    public AiPlayer(Game game, Board board) {
        super(game, board);
        this.previousHits = new ArrayList<>();
        this.state = AiState.RANDOM;
        this.reverse = false;
    }

    @Override
    public void takeTurn() {
        super.takeTurn();
        switch (state) {
            case LAST_DESTROYED:
            case RANDOM:
                handleRandomGuess();
                break;
            case LAST_HIT:
            case HIT_LAST_MISSED:
                handleLastHit();
                break;
        }
    }

    private void handleLastHit() {
        Board enemyBoard = getGame().getPlayer().getBoard();
        if (previousHits.size() == 1) {
            List<Direction> adjDirections = getValidDirections(previousHits.get(0));
            int dir = ThreadLocalRandom.current().nextInt(0, adjDirections.size());
            Direction direction = adjDirections.get(dir);
            BoardCell cell = getCellInDirection(previousHits.get(0), direction);
            checkCell(cell);
            getGame().makeMove(this, enemyBoard, cell);
        } else if (previousHits.size() > 1) {
            BoardCell twoBack = previousHits.get(previousHits.size() - 2);
            BoardCell oneBack = previousHits.get(previousHits.size() - 1);
            Direction direction = getDirection(twoBack, oneBack);
            if (reverse) {
                BoardCell cell = getCellInDirection(oneBack, direction);
                if (cell == null || cell.isGuessed()) {
                    // try new direction
                    reverse = false;
                    Collections.reverse(previousHits);
                    BoardCell first = previousHits.get(0);
                    previousHits.clear();
                    previousHits.add(first);
                    handleLastHit();
                } else {
                    checkCell(cell);
                    getGame().makeMove(this, enemyBoard, cell);
                }
            } else {
                BoardCell cell = getCellInDirection(oneBack, direction);
                if (cell == null || cell.isGuessed()) {
                    reverse = true;
                    Collections.reverse(previousHits);
                    handleLastHit();
                } else {
                    checkCell(cell);
                    getGame().makeMove(this, enemyBoard, cell);
                }
            }
        }
    }

    private void handleRandomGuess() {
        Board enemyBoard = getGame().getPlayer().getBoard();
        BoardCell cell;
        while (true) {
            cell = enemyBoard.getRandomCell();
            if (!cell.isGuessed()) {
                break;
            }
        }
        checkCell(cell);
        getGame().makeMove(this, enemyBoard, cell);
    }


    private void checkCell(BoardCell cell) {
        if (cell.containsShip()) {
            Ship target = cell.getShip();
            state = AiState.LAST_HIT;
            if (target.getHits() + 1 == target.getLength()) {
                state = AiState.LAST_DESTROYED;
                previousHits.clear();
                reverse = false;
                return;
            }
            previousHits.add(cell);
        } else if (state == AiState.HIT_LAST_MISSED || state == AiState.LAST_HIT) {
            state = AiState.HIT_LAST_MISSED;
        }
    }

    private List<Direction> getValidDirections(BoardCell cell) {
        List<Direction> directions = new ArrayList<>();
        int x = cell.getX();
        int y = cell.getY();
        Board enemyBoard = getGame().getPlayer().getBoard();
        if (enemyBoard.validCell(x, y - 1) && !enemyBoard.getCell(x, y - 1).isGuessed()) {
            directions.add(NORTH);
        }
        // south
        if (enemyBoard.validCell(x, y + 1) && !enemyBoard.getCell(x, y + 1).isGuessed()) {
            directions.add(SOUTH);
        }
        // east
        if (enemyBoard.validCell(x + 1, y) && !enemyBoard.getCell(x + 1, y).isGuessed()) {
            directions.add(EAST);
        }
        // west
        if (enemyBoard.validCell(x - 1, y) && !enemyBoard.getCell(x - 1, y).isGuessed()) {
            directions.add(WEST);
        }
        return directions;
    }

    private Direction getDirection(BoardCell first, BoardCell last) {
        int firstX = first.getX();
        int firstY = first.getY();

        int lastX = last.getX();
        int lastY = last.getY();

        // north or south
        if (firstX == lastX) {
            if (firstY > lastY) {
                return Direction.NORTH;
            } else {
                return Direction.SOUTH;
            }
        } else if (firstY == lastY) {
            if (firstX > lastX) {
                return Direction.WEST;
            } else {
                return Direction.EAST;
            }
        }
        return null;
    }


    private BoardCell getCellInDirection(BoardCell start, Direction direction) {
        Board enemyBoard = getGame().getPlayer().getBoard();
        int x = start.getX();
        int y = start.getY();
        switch (direction) {
            case NORTH:
                y -= 1;
                break;
            case SOUTH:
                y += 1;
                break;
            case EAST:
                x += 1;
                break;
            case WEST:
                x -= 1;
                break;
        }
        return enemyBoard.validCell(x, y) ? enemyBoard.getCell(x, y) : null;
    }
}
