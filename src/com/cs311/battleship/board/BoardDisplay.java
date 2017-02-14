package com.cs311.battleship.board;

import com.cs311.battleship.MenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by HP1 on 2/13/2017.
 */
public class BoardDisplay {

    public void start(Stage board) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));
        GridPane pane = loader.load();
        BoardController controller = loader.getController();
        board.setTitle("Battleship Game");
        board.setScene(new Scene(pane, 1200, 600));
        board.centerOnScreen();
        board.show();
    }
}
