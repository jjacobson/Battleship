package com.cs311.battleship.board;

import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.board.cell.CellColor;
import com.cs311.battleship.board.ship.Ship;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP1 on 2/13/2017.
 */
public class BoardDisplay {

    private Board playerBoard;
    private Board enemyBoard;

    public void start(Stage stage, Board playerBoard, Board enemyBoard) throws Exception {
        this.playerBoard = playerBoard;
        this.enemyBoard = enemyBoard;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));
        Pane box = loader.load();
        BoardController controller = loader.getController();
        stage.setTitle("Battleship Game");
        stage.setScene(new Scene(box, 1200, 600));
        stage.centerOnScreen();
        // populate grids
        GridPane playerGrid = (GridPane) box.lookup("#playerGrid");
        GridPane enemyGrid = (GridPane) box.lookup("#enemyGrid");
        populateGrid(playerGrid, playerBoard);
        populateGrid(enemyGrid, enemyBoard);
        //populate ship placer
        VBox shipBox = (VBox) box.lookup("#shipBox");
        displayPlaceableShips(shipBox);

        stage.show();
    }

    private void populateGrid(GridPane grid, Board board) {
        grid.setStyle("-fx-background-color: black; -fx-padding: 2; -fx-hgap: 2; -fx-vgap: 2;");
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                BoardCell cell = board.getCell(x, y);
                Button button = new Button();
                button.setMinWidth(30);
                button.setMinHeight(30);
                //button.setOnMouseClicked();
                cell.setButton(button);
                cell.setColor(CellColor.WATER);
                grid.add(button, x, y);
            }
        }
    }

    private void displayPlaceableShips(VBox shipBox) {
        List<Ship> ships = new ArrayList<>();
        for (int i = 2; i < 7; i++) {
            ships.add(new Ship(i));
        }
        for (Ship ship : ships) {
            displayShip(shipBox, ship);
        }
    }

    private void displayShip(VBox shipContainer, Ship ship) {
        // parent display box
        HBox parent = new HBox();
        // child display box
        HBox child = new HBox(2);
        child.setPadding(new Insets(1, 1, 1, 1));
        child.setStyle("-fx-background-color: black;");
        for (int i = 0; i < ship.getLength(); i++) {
            BoardCell cell = new BoardCell(); // todo handle
            Button button = new Button();
            button.setMinWidth(25);
            button.setMinHeight(25);
            cell.setButton(button);
            cell.setColor(CellColor.SHIP);
            child.getChildren().add(button);
        }
        parent.getChildren().add(child);
        shipContainer.getChildren().add(parent);
    }
}
