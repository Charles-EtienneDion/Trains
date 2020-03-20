package sample;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public interface TrainInterface {
    public void enter();
    public void exit();
    public void nextState();
    public int getId();
    public Shape getShape();
    public TrainState getState();
}
