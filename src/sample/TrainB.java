package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TrainB implements Runnable, TrainInterface {

    private int id;
    private TrainState state;
    private Circle shape;


    public TrainB(int id, TrainState state) {
        this.id = id;
        this.state = state;
        this.shape = new Circle(64,125,10, Color.RED);
    }

    public int getId() {
        return id;
    }

    public TrainState getState() {
        return state;
    }

    public void setState(TrainState state) {
        this.state = state;
    }

    public void enter() {

    }

    public void exit() {

    }

    public void nextState() {
        setState(getState().getNextState());
    }

    public Circle getShape() {
        return shape;
    }

    @Override
    public void run() {
        Controller.getInstance().moveTrain(this);
    }
}
