package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Controller controller;

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        final String version = "0.1.0";

        stage.setHeight(500);
        stage.setWidth(500);
        controller = new Controller(stage);
        stage.setTitle("SciBorgs LIDAR GUI - Version " + version);
        stage.setScene(new Scene(controller));

        stage.setResizable(false);
        stage.toFront();
        stage.show();
    }
}
