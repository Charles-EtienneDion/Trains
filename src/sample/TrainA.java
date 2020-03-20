package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.security.PublicKey;

public class TrainA implements Runnable, TrainInterface {

    private int id;
    private TrainState state;
    private Rectangle shape;

    public TrainA(int id) {
        this.id = id;
        this.state = TrainState.A1;
        this.shape = new Rectangle(54, 118, 20, 20);
        this.shape.setFill(Color.RED);
    }

    public int getId() {
        return id;
    }

    public Rectangle getShape() {
        return shape;
    }

    public TrainState getState() {
        return state;
    }

    @Override
    public void updatePosition(double X, double Y) {
        this.getShape().setX(X);
        this.getShape().setY(Y);
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

    @Override
    public synchronized void run() {
        Controller.getInstance().moveTrain(this);
    }
}
