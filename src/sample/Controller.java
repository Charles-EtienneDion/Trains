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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static sample.TrainStatus.late;
import static sample.TrainStatus.ready;

public class Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField nbTA, nbTB;

    @FXML
    private Line lineA1, lineABC, lineB1, lineAB, lineB3, lineA5, lineBC, lineB5, lineB7, lineA3;
    private int nbTrainA, nbTrainB;

    private static Controller controller = null;
    ArrayList<TrainA> arrayTrainA = new ArrayList<>();
    ArrayList<TrainB> arrayTrainB = new ArrayList<>();

    public static Controller getInstance() {
        return controller;
    }

    public int getNbTrainA() {
        return nbTrainA;
    }

    public void setNbTrainA(int nbTrainA) {
        this.nbTrainA = nbTrainA;
    }

    public int getNbTrainB() {
        return nbTrainB;
    }

    public void setNbTrainB(int nbTrainB) {
        this.nbTrainB = nbTrainB;
    }

    public ArrayList<TrainA> getArrayTrainA() {
        return arrayTrainA;
    }

    public ArrayList<TrainB> getArrayTrainB() {
        return arrayTrainB;
    }

    @FXML
    void startTrains(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tracks.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("TP2");


        getInstance().setNbTrainA(Integer.parseInt(nbTA.getText()));
        getInstance().setNbTrainB(Integer.parseInt(nbTB.getText()));
        initTrains();
        nbTA.getScene().getWindow().hide();

        stage.show();
    }

    public void initTrains() {
        for (int i = 1; i <= getInstance().getNbTrainA(); i++) {
            TrainA trainA = new TrainA(i);
            getInstance().anchorPane.getChildren().add(trainA.getShape());
            getInstance().arrayTrainA.add(trainA);
        }
        for (int x = 1; x <= getInstance().getNbTrainB(); x++) {
            TrainB trainB = new TrainB(x);
            getInstance().anchorPane.getChildren().add(trainB.getShape());
            getInstance().arrayTrainB.add(trainB);
        }
    }

    @FXML
    void startThreads(ActionEvent event) {
        for (TrainA trainA : getInstance().getArrayTrainA()) {
            trainA.run();
        }
        for (TrainB trainB : getInstance().getArrayTrainB()) {
            trainB.run();
        }
    }

    Line getLine(TrainState state) {
        Line line = null;
        switch (state) {
            case A1:
                line = lineA1;
                break;
            case ABa:
                line = lineAB;
                break;
            case A3:
                line = lineA3;
                break;
            case ABCa:
                line = lineABC;
                break;
            case A5:
                line = lineA5;
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
            case ABb:
                line = lineAB;
                break;
            case ABCb:
                line = lineABC;
                break;
        }
        return line;
    }


    void moveTrain(TrainInterface train) {
        if (getLine(train.getState()) == null) {
            //Remove shape from anchorpane
        }
        else {
            if (getLine(train.getState()) != lineAB || getLine(train.getState()) != lineABC) {
                    statusTrain(train);
            }
            else {
                    //Priorite Train B par rapport Train A
                    statusTrain(train);
            }
        }
    }
    void pauseTrain(TrainInterface train) {
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(event1 -> {
            train.getShape().setFill(Color.RED);
            train.updatePosition(train.getShape().getLayoutX(), train.getShape().getLayoutY());
        });
        pause.play();
    }

    void statusTrain(TrainInterface train) {
        if(train.getStatus() == ready){
            PathTransition transition = new PathTransition();
            train.getShape().setFill(Color.GREEN);
            transition.setNode(train.getShape());
            transition.setDuration(Duration.seconds(5));
            transition.setPath(getLine(train.getState()));
            transition.setCycleCount(1);
            pauseTrain(train);
            transition.play();
        }
        else if (train.getStatus() == late){
            PauseTransition late = new PauseTransition(Duration.seconds(5));
            train.getShape().setFill(Color.BLUE);
            late.play();
            pauseTrain(train);
        }
        else{
            PauseTransition repair = new PauseTransition(Duration.seconds(5));
                train.getShape().setFill(Color.YELLOW);
            repair.play();
           pauseTrain(train);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = this;
    }
}
