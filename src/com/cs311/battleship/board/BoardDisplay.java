package com.cs311.battleship.board;

import com.cs311.battleship.board.cell.BoardCell;
import com.cs311.battleship.board.cell.CellColor;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by HP1 on 2/13/2017.
 */
public class BoardDisplay {

    private Board playerBoard;
    private Board enemyBoard;
    private GridPane playerGrid;
    private GridPane enemyGrid;

    public void start(Stage stage, Board playerBoard, Board enemyBoard) throws Exception {
        this.playerBoard = playerBoard;
        this.enemyBoard = enemyBoard;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));
        BorderPane box = loader.load();
        BoardController controller = loader.getController();
        stage.setTitle("Battleship Game");
        stage.setScene(new Scene(box, 1200, 600));
        stage.centerOnScreen();
        playerGrid = (GridPane) box.lookup("#playerGrid");
        enemyGrid = (GridPane) box.lookup("#enemyGrid");
        populateGrid(playerGrid, playerBoard);
        populateGrid(enemyGrid, enemyBoard);
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
}
