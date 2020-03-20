package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TrainB implements Runnable, TrainInterface {

    private int id;
    private TrainState state;
    private Circle shape;


    public TrainB(int id) {
        this.id = id;
        this.state = TrainState.B1;
        this.shape = new Circle(64,347,10, Color.RED);
    }

    public int getId() {
        return id;
    }

    public TrainState getState() {
        return state;
    }

    @Override
    public void updatePosition(double X, double Y) {
        this.getShape().setCenterX(X);
        this.getShape().setCenterY(Y);
        this.nextState();
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
    public synchronized void run() {
        Controller.getInstance().moveTrain(this);
    }
}
