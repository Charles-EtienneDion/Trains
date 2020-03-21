package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TrainA implements Runnable, TrainInterface {

    private int id;
    private TrainState state;
    private TrainStatus status;
    private Rectangle shape;

    public TrainA(int id) {
        this.id = id;
        this.state = TrainState.A1;
        this.status = TrainStatus.ready;
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

    public TrainStatus getStatus() {
        return status;
    }

    @Override
    public void updatePosition(double X, double Y) {
        this.getShape().setX(X);
        this.getShape().setY(Y);
        this.nextState();
        this.nextStatus();
    }

    public void setState(TrainState state) {
        this.state = state;
    }
    public void setStatus(TrainStatus status) {
        this.status = status;
    }

    public void enter() {

    }

    public void exit() {

    }

    public void nextState() {
        if(getStatus() == TrainStatus.ready){
            setState(getState().getNextState());
        }
        setState(getState());
    }
    public void nextStatus() {
        setStatus(getStatus().getNextStatus());
    }

    @Override
    public synchronized void run() {
        Controller.getInstance().moveTrain(this);
    }
}
