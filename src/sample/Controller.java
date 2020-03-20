package sample;

import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField nbTA, nbTB;

    @FXML
    private Line lineA1, lineABC, lineB1, lineAB, lineB3, lineA5, lineBC, lineB5, lineB7, lineA3;

    private static Controller controller = null;

    public static Controller getInstance()
    {
        return controller;
    }

    @FXML
    void startTrains(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tracks.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("TP2");
        stage.show();
        nbTA.getScene().getWindow().hide();
    }

    @FXML
    void startThreads(ActionEvent event) {
        TrainB trainB = new TrainB(1, TrainState.B1);
        anchorPane.getChildren().add(trainB.getShape());
        trainB.run();
    }

    Line getLine(TrainState state) {
        Line line = null;
        switch (state) {
            case A1:
                line = lineA1;
                break;
            case AB:
                line = lineAB;
                break;
            case A3:
                line = lineA3;
                break;
            case A4:
                line = lineABC;
                break;
            case A5:
                line = null;
                break;
            case B1:
                line = lineB1;
                break;
            case B3:
                line = lineB3;
                break;
            case BC:
                line = lineBC;
                break;
            case B5:
                line = lineB5;
                break;
            case B7:
                line = lineB7;
                break;
        }
        return line;
    }

    void moveTrain(TrainInterface train) {
        PathTransition transition = new PathTransition();
        transition.setNode(train.getShape());
        transition.setDuration(Duration.seconds(3));
        transition.setPath(getLine(train.getState()));
        transition.setCycleCount(1);

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event1 -> {
            System.out.println("Finished");
        });
        pause.play();
        transition.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = this;
    }
}
