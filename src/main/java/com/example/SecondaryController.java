package com.example;


import javafx.fxml.FXML;
import javafx.scene.control.Spinner;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SecondaryController {

    @FXML
    Spinner<Integer> setBet = new Spinner<Integer>();

    @FXML 
    Button standButton = new Button();
    
    @FXML 
    Button hitButton = new Button();

    @FXML
    private Label dealerCardsLabel;
    
    @FXML
    Label winStateLabel;

    @FXML
    Label playerCardsLabel;

    @FXML
    void drawCard() {
        System.out.println("Hey");
    }

     @FXML
    void endTurn() {
        System.out.println("Hey");
    }
}