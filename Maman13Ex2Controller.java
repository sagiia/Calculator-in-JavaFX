package com.sagiia.maman13ex2;

import java.math.BigDecimal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * The Maman13Ex2Controller class is the controller for a simple JavaFX calculator application.
 * It handles user input and performs arithmetic calculations.
 */
public final class Maman13Ex2Controller {

    private BigDecimal left; // left operand
    private String selectedOperator; // operator selected by user
    private boolean numberInputting; // true if the next digit entered starts a new number

    @FXML
    private TextField display; // displays text representing the calculator state

    /**
     * Initializes the controller. This method is automatically called after the FXML file is loaded.
     * It sets up initial data for the calculator.
     */
    @FXML
    public void initialize() {
        this.left = BigDecimal.ZERO;
        this.selectedOperator = "";
        this.numberInputting = false;
    }

    /**
     * Handles any button click event on the calculator.
     *
     * @param evt The ActionEvent triggered by a button click.
     */
    @FXML
    private void handleOnAnyButtonClicked(ActionEvent evt) {
        Button button = (Button) evt.getSource();
        final String buttonText = button.getText();

        // Clear the calculator and reset values if "C" or "AC" button is pressed
        if (buttonText.equals("C") || buttonText.equals("AC")) {
            if (buttonText.equals("AC")) {
                left = BigDecimal.ZERO;
            }
            selectedOperator = "";
            numberInputting = false;
            display.setText("0");

            return;
        }

        // Handle numeric input (0-9 and decimal point)
        if (buttonText.matches("[0-9.]")) {
            if (!numberInputting) {
                numberInputting = true;
                display.clear();
            }
            display.appendText(buttonText);
            return;
        }

        // Handle arithmetic operators (+, -, *, /)
        if (buttonText.matches("[＋－×÷]")) {
            left = new BigDecimal(display.getText());
            selectedOperator = buttonText;
            numberInputting = false;
            return;
        }

        // Handle equals button for performing calculations
        if (buttonText.equals("=")) {
            final BigDecimal right = numberInputting ? new BigDecimal(display.getText()) : left;
            left = calculate(selectedOperator, left, right);
            display.setText(left.toString());
            numberInputting = false;
        }
    }

    /**
     * Performs arithmetic calculations based on the selected operator.
     *
     * @param operator The arithmetic operator (+, -, *, /).
     * @param left     The left operand.
     * @param right    The right operand.
     * @return The result of the calculation.
     */
    static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right) {
        return switch (operator) {
            case "＋" -> left.add(right);
            case "－" -> left.subtract(right);
            case "×" -> left.multiply(right);
            case "÷" -> left.divide(right);
            default -> right;
        };
    }
}