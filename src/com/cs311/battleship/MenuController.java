package com.cs311.battleship;

import com.cs311.battleship.game.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by HP1 on 2/13/2017.
 */
public class MenuController {

    @FXML
    public void singlePlayerSelect(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        try {
            new Game(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void multiPlayerSelect(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        try {
            new Game(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
