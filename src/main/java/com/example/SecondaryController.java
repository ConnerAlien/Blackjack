package com.example;


import java.io.IOException;

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

    String[] deckCards = {"0", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    int yourTotal = 0;
    int dealerTotal = 0;

    
    @FXML
    void drawCard() {
        int yourPick = (int)(Math.random() * 13 + 1);
        System.out.println("You drew: " + deckCards[yourPick]);
        
        if ((dealerTotal < yourTotal) && (dealerTotal < 21)) {
            dealerDraw();
        }
        int yourValue = checkCard(yourPick, yourTotal);
            
        yourTotal = yourTotal + yourValue;
       

        System.out.println("YOUR TOTAL: " + yourTotal);
        System.out.println("DEALER TOTAL: " + dealerTotal);

        if ((yourTotal >= 21) || (dealerTotal >= 21)) {
            endTurn();
        }
    }
    
    public int dealerDraw() {
        int dealerPick = (int)(Math.random() * 13 + 1);
        System.out.println("Dealer drew: " + deckCards[dealerPick]);
        int dealerValue = checkCard(dealerPick, dealerTotal);
        dealerTotal = dealerTotal + dealerValue;
        return dealerValue;
    }

    @FXML
    void endTurn() {
        if ((dealerTotal < yourTotal) && (dealerTotal < 21)) {
            int dealerPick = (int)(Math.random() * 13 + 1);
            System.out.println("Dealer drew: " + deckCards[dealerPick]);
            int dealerValue = checkCard(dealerPick, dealerTotal);
            dealerTotal = dealerTotal + dealerValue; 
        }
        System.out.println();
        System.out.println("YOUR FINAL TOTAL: " + yourTotal);
        System.out.println("DEALER FINAL TOTAL: " + dealerTotal);

        if ((yourTotal < 21) && (yourTotal > dealerTotal)) {
            System.out.println("You won! - (condition 1)");
        }
        else if ((yourTotal > 21) && (yourTotal < dealerTotal)) {
            System.out.println("You won! - (condition 2)");
        }
        else if ((yourTotal == 21) && (dealerTotal != 21)) {
            System.out.println("You won! - (condition 3)");
        }
        else if ((dealerTotal > 21) && (dealerTotal > yourTotal)) {
            System.out.println("You won! - (condition 4)");
        }
        else if (yourTotal == dealerTotal) {
            System.out.println("Push! - (Tie)");
        }
        else {
            System.out.println("You lost!");
        }

        System.out.println();
        System.out.println("New Round. \n");
        yourTotal = 0;
        dealerTotal = 0;
    }

    public static int checkCard(int personsPick, int personsTotal) {
        String[] deckCards = {"0", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int value = personsPick;
        
        if (deckCards[personsPick] == "A") {
            if (personsTotal + 11 <= 21) {
                value = 11;
            }
            else {
                value = 1;
            }
        }
        if (deckCards[personsPick] == "J") {
            value = 10;
        }
        if (deckCards[personsPick] == "Q") {
            value = 10;
        }
        if (deckCards[personsPick] == "K") {
            value = 10;
        }
        return value;
    }
}