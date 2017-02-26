package com.cs311.battleship.board.cell;

import com.cs311.battleship.ship.Ship;
import javafx.scene.control.Button;

/**
 * Created by HP1 on 2/13/2017.
 */
public class BoardCell {

    private int x;
    private int y;
    private Button button;
    private boolean containsShip;
    private boolean guessed;
    private Ship ship;

    /**
     * Default constructor for cells with no x,y coordinate
     * used for the placable ships at the beginning of game
     */
    public BoardCell() {

    }

    public BoardCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.containsShip = false;
        this.guessed = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public boolean containsShip() {
        return containsShip;
    }

    public void setContainsShip(boolean containsShip) {
        this.containsShip = containsShip;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    public void setColor(String color) {
        button.setStyle("-fx-background-radius: 0; -fx-background-color: " + color + ";" +
                " -fx-border-radius: 0; -fx-focus-color: transparent;" +
                " -fx-faint-focus-color: transparent; -fx-background-insets: 0, 1, 2;");
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
