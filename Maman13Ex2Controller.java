package com.sagiia.maman13ex2;

import java.math.BigDecimal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public final class Maman13Ex2Controller {

    private BigDecimal left;
    private String selectedOperator;
    private boolean numberInputting;

    @FXML
    private TextField display;

    @FXML
    public void initialize() {
        this.left = BigDecimal.ZERO;
        this.selectedOperator = "";
        this.numberInputting = false;
    }

    @FXML
    private void handleOnAnyButtonClicked(ActionEvent evt) {
        Button button = (Button) evt.getSource();
        final String buttonText = button.getText();
        if (buttonText.equals("C") || buttonText.equals("AC")) {
            if (buttonText.equals("AC")) {
                left = BigDecimal.ZERO;
            }
            selectedOperator = "";
            numberInputting = false;
            display.setText("0");

            return;
        }
        if (buttonText.matches("[0-9.]")) {
            if (!numberInputting) {
                numberInputting = true;
                display.clear();
            }
            display.appendText(buttonText);
            return;
        }
        if (buttonText.matches("[＋－×÷]")) {
            left = new BigDecimal(display.getText());
            selectedOperator = buttonText;
            numberInputting = false;
            return;
        }
        if (buttonText.equals("=")) {
            final BigDecimal right = numberInputting ? new BigDecimal(display.getText()) : left;
            left = calculate(selectedOperator, left, right);
            display.setText(left.toString());
            numberInputting = false;
        }
    }

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