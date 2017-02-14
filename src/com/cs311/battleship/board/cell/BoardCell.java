package com.cs311.battleship.board.cell;

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

    public void setButton(Button button) {
        this.button = button;
    }

    public Button getButton() {
        return button;
    }

    public boolean containsShip() {
        return containsShip;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setColor(String color) {
        button.setStyle("-fx-background-radius: 0; -fx-background-color: " + color + ";" +
                " -fx-border-radius: 0; -fx-focus-color: transparent;");
    }
}
