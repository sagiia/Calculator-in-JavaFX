package com.sagiia.maman13ex2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Main class serves as the entry point for the JavaFX calculator application.
 */
public class Main extends Application {

    /**
     * The start method initializes and launches the JavaFX application.
     *
     * @param stage The primary stage for the JavaFX application.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file and create a scene
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("maman13ex2-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 250, 240);

        // Set the stage properties
        stage.setTitle("Sagi Menahem - Maman 13Ex2");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method is the entry point of the JavaFX application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch();
    }
}