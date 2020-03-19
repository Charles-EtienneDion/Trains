package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField nbTA, nbTB;

    @FXML
    void startTrains(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tracks.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("TP2");
        stage.show();
    }
}
