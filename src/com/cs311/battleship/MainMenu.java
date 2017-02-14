package com.cs311.battleship;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Application {

    @Override
    public void start(Stage menu) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main_menu.fxml"));
        VBox pane = loader.load();
        MenuController controller = loader.getController();
        menu.setTitle("Battleship Menu");
        menu.setScene(new Scene(pane, 300, 275));
        menu.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
