package com.cs311.battleship;

import com.cs311.battleship.game.Game;
import com.cs311.battleship.game.MultiPlayerGame;
import com.cs311.battleship.game.SingePlayerGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Created by HP1 on 2/13/2017.
 */
public class MenuController {

    @FXML
    public void singlePlayerSelect(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        try {
            new SingePlayerGame(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void multiPlayerSelect(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        try {
            new MultiPlayerGame(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void rulesSelect(ActionEvent event){
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();

        JFrame f = new JFrame("Rules");
        String [] data = {"First click your Battleship and click on the square you would like to place it.",
                "Use the arrow keys to select the direction the ship will face.",
                "Press enter or click the next ship to confirm where the ship will be placed.",
                "When on last ship to place you must hit 'Enter' to confirm its location.",
                "Click on enemy board to guess a tile. 'Red' = hit , 'White' = miss , 'Blue' = open to guess" };

        f.add(new JList<>(data));
        f.pack();
        f.setVisible(true);
    }
}
