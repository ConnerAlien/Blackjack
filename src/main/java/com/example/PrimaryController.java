package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    Button startButton = new Button();

    @FXML
    private void startGame() throws IOException {
        App.setRoot("secondaryController");
    }
}
