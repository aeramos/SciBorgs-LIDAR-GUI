package gui;

import api.Point;
import api.Server;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Controller extends Pane {
    private Stage stage;
    private Server server;
    private ScheduledExecutorService scheduledExecutorService;

    public Controller(Stage stage) {
        this.stage = stage;
        try {
            server = new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                Point[] points = server.getPoints();
                if (points != null) {
                    Platform.runLater(() -> addPoints(points));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.MILLISECONDS);
    }

    public void addPoints(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            Line line = new Line();
            line.setStartX((stage.getWidth() / 2) + (point.x * 25));
            line.setEndX((stage.getWidth() / 2) + (point.x * 25));
            line.setStartY((stage.getHeight() / 2) - (point.y * 25));
            line.setEndY((stage.getHeight() / 2) - (point.y * 25));
            line.setStrokeWidth(5d);
            if (i == 0) {
                line.setStroke(Color.RED);
            } else {
                line.setStroke(Color.BLACK);
            }
            getChildren().add(line);
        }
    }
}
