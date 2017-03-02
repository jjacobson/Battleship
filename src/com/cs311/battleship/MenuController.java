package com.cs311.battleship;

import com.cs311.battleship.game.MultiPlayerGame;
import com.cs311.battleship.game.SingePlayerGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
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
        ListView<String> list = new ListView<>();
        list.setPrefWidth(355);
        ObservableList<String> items = FXCollections.observableArrayList (
                "Begin the game by placing your battleships. To place them, \n" +
                        "select one by clicking on it and choose a place for it on \n" +
                        "the board.",
                "You can adjust the direction of the ship using your arrow keys. \n" +
                        "Once you are happy with the orientation you can lock in the \n" +
                        "ship by pressing the enter key.",
                "Once all the ships are placed, the game will choose a random \n" +
                        "player to move first.",
                "Fire at tiles by clicking on them. Hits are marked in RED, misses \n" +
                        "in WHITE, and open tiles in BLUE");
        list.setItems(items);

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.add(list, 0, 0);

        Scene scene = new Scene(pane);
        Stage popupStage = new Stage();
        popupStage.setScene(scene);
        popupStage.initModality(Modality.WINDOW_MODAL);
        popupStage.setTitle("Battleship");

        popupStage.show();
    }
}
