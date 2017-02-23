package com.cs311.battleship.console;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 * Created by Jeremiah on 2/22/2017.
 */
public class ConsoleWriter {

    private static TextArea textArea;

    public ConsoleWriter(Pane pane) {
        textArea = (TextArea) pane.lookup("#messageBox");
        textArea.setEditable(false);
    }

    public static void printLine(String line) {
        textArea.appendText(line + "\n");
    }
}
