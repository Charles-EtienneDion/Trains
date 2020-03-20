package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.security.PublicKey;

public class TrainA implements Runnable, TrainInterface {

    private int id;
    private TrainState state;
    private Rectangle shape;

    public TrainA(int id, TrainState state) {
        this.id = id;
        this.state = state;
        this.shape = new Rectangle(10, 10, Color.RED);
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

    public void setState(TrainState state) {
        this.state = state;
    }

    public void enter(){

    }
    public void exit(){

    }
    public void nextState(){
        setState(getState().getNextState());
    }

    @Override
    public void run() {
//        Controller.getInstance().moveTrain(this);
    }
}
