package com.example;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SecondaryController implements Initializable{

    @FXML
    Spinner<Integer> setBetSpinner = new Spinner<Integer>();
    SpinnerValueFactory<Integer> ageSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 200, 10);

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
    Label yourWinningsLabel;

    @FXML
    Label playerTotalLabel;

    @FXML 
    Label dealerTotalLabel;

    String[] deckCards = {"0", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    int yourTotal = 0;
    int dealerTotal = 0;
    int roundCounter = 1;
    int winningsTotal = 0;

    @FXML
    private int getBet()  {
        int betValue = setBetSpinner.getValue();
        return betValue;
    }

    @FXML
    void drawCard() {
        int yourPick = (int)(Math.random() * 13 + 1);
        String output = "You drew: " + deckCards[yourPick];
        playerCardsLabel.setText(output);
        System.out.println("You drew: " + deckCards[yourPick]);

        if ((dealerTotal <= yourTotal) && (dealerTotal < 16)) {
            dealerDraw();
        }
        else if ((dealerTotal > yourTotal) && (dealerTotal < 16)) {
            dealerDraw();
        }
        int yourValue = checkCard(yourPick, yourTotal);
            
        yourTotal = yourTotal + yourValue;
       

        System.out.println("YOUR TOTAL: " + yourTotal);
        output = "YOUR TOTAL: " + yourTotal;
        playerTotalLabel.setText(output);
        System.out.println("DEALER TOTAL: " + dealerTotal);
        output = "DEALER TOTAL: " + dealerTotal;
        dealerTotalLabel.setText(output);
        winStateLabel.setText("Round " + roundCounter);
        
        if ((yourTotal >= 21) || (dealerTotal >= 21)) {
            endTurn();
        }
    }
    
    public int dealerDraw() {
        int dealerPick = (int)(Math.random() * 13 + 1);
        String output = "Dealer drew: " + deckCards[dealerPick];
        dealerCardsLabel.setText(output);
        System.out.println("Dealer drew: " + deckCards[dealerPick]);
        int dealerValue = checkCard(dealerPick, dealerTotal);
        dealerTotal = dealerTotal + dealerValue;
        return dealerValue;
    }

    @FXML
    void endTurn() {
        if ((dealerTotal < yourTotal) && (dealerTotal < 16)) {
            int dealerPick = (int)(Math.random() * 13 + 1);
            String output = "Dealer drew: " + deckCards[dealerPick];
            dealerCardsLabel.setText(output);
            System.out.println("Dealer drew: " + deckCards[dealerPick]);
            int dealerValue = checkCard(dealerPick, dealerTotal);
            dealerTotal = dealerTotal + dealerValue; 
        }
        System.out.println();
        String output = "YOUR FINAL TOTAL: " + yourTotal;
        playerTotalLabel.setText(output);
        System.out.println("YOUR FINAL TOTAL: " + yourTotal);
        output = "DEALER FINAL TOTAL: " + dealerTotal;
        dealerTotalLabel.setText(output);
        System.out.println("DEALER FINAL TOTAL: " + dealerTotal);

        

        if ((yourTotal < 21) && (yourTotal > dealerTotal)) {
            output = "You won!";
            winStateLabel.setText(output);
            System.out.println("You won! - (condition 1)");
            output = "Total: " + (winningsTotal + (getBet() * 2));
            yourWinningsLabel.setText(output);
        }
        else if ((yourTotal > 21) && (yourTotal < dealerTotal)) {
            output = "You won!";
            winStateLabel.setText(output);
            System.out.println("You won! - (condition 2)");
            output = "Total: " + (winningsTotal + (getBet() * 2));
            yourWinningsLabel.setText(output);
        }
        else if ((yourTotal == 21) && (dealerTotal != 21)) {
            output = "You won!";
            winStateLabel.setText(output);
            System.out.println("You won! - (condition 3)");
            output = "Total: " + (winningsTotal + (getBet() * 2));
            yourWinningsLabel.setText(output);
        }
        else if ((dealerTotal > 21) && (dealerTotal > yourTotal)) {
            output = "You won!";
            winStateLabel.setText(output);
            System.out.println("You won! - (condition 4)");
            output = "Total: " + (winningsTotal + (getBet() * 2));
            yourWinningsLabel.setText(output);
        }
        else if (yourTotal == dealerTotal) {
            output = "Push!";
            winStateLabel.setText(output);
            System.out.println("Push! - (Tie)");
            output = "Total: " + winningsTotal;
            yourWinningsLabel.setText(output);
        }
        else {
            output = "You lost!";
            winStateLabel.setText(output);
            System.out.println("You lost!");
            output = "Total: " + (winningsTotal - (getBet() * 2));
            yourWinningsLabel.setText(output);
        }

        System.out.println();
        System.out.println("-- New Round. --\n");
        yourTotal = 0;
        dealerTotal = 0;
        roundCounter ++; 
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
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        setBetSpinner.setValueFactory(ageSpinnerValueFactory);
    }
}