package com.cs311.battleship.board;

import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.board.cell.CellColor;
import com.cs311.battleship.ship.Ship;
import com.cs311.battleship.console.ConsoleWriter;
import com.cs311.battleship.game.Game;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HP1 on 2/13/2017.
 */
public class BoardDisplay {

    private Game game;
    private Board playerBoard;
    private Board enemyBoard;

    private Map<Ship, HBox> shipDisplays;
    private Pane pane;

    public BoardDisplay(Game game, Board playerBoard, Board enemyBoard) {
        this.game = game;
        this.playerBoard = playerBoard;
        this.enemyBoard = enemyBoard;
    }

    public void start(Stage stage) throws Exception {
        this.shipDisplays = new HashMap<>();
        // load scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));
        pane = loader.load();
        new ConsoleWriter(pane);
        stage.setTitle("Battleship Game");
        Scene scene = new Scene(pane, 1200, 600);
        stage.setScene(scene);
        stage.centerOnScreen();

        // key press listener
        scene.setOnKeyPressed(new BoardKeyListener(this, playerBoard));

        // populate grids
        GridPane playerGrid = (GridPane) pane.lookup("#playerGrid");
        GridPane enemyGrid = (GridPane) pane.lookup("#enemyGrid");
        populateGrid(playerGrid, playerBoard);
        populateGrid(enemyGrid, enemyBoard);
        //populate ship placer
        VBox shipBox = (VBox) pane.lookup("#shipBox");
        displayShipPlacementBox(shipBox);

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
                button.setOnMouseClicked(new CellClickListener(game, board, cell));
                cell.setButton(button);
                cell.setColor(CellColor.WATER);
                grid.add(button, x, y);
            }
        }
    }

    private void displayShipPlacementBox(VBox shipBox) {
        for (Ship ship : playerBoard.getShips()) {
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
                button.setOnMouseClicked(new ShipPlaceListener(this, playerBoard, ship));
                cell.setButton(button);
                cell.setColor(CellColor.SHIP);
                child.getChildren().add(button);
            }
            parent.getChildren().add(child);
            shipBox.getChildren().add(parent);
            shipDisplays.put(ship, parent);
        }
    }

    public void updateShips(Ship ship) {
        shipDisplays.get(ship).setVisible(false);
        shipDisplays.remove(ship);
        if (shipDisplays.size() == 0) {
            removeShipBox();
            game.playerReady();
        }
    }

    public void removeShipBox() {
        VBox shipDisplay = (VBox) pane.lookup("#shipDisplay");
        shipDisplay.setVisible(false);
    }
}
