package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
