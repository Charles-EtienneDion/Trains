package sample;

import javafx.scene.shape.Shape;

public interface TrainInterface {
    public void enter();
    public void exit();
    public void nextState();
    public void nextStatus();
    public int getId();
    public Shape getShape();
    public TrainState getState();
    public TrainStatus getStatus();
    public void updatePosition(double X, double Y);
}
