package sample;
import java.lang.Math;
public enum TrainStatus {
    late, breakdown, ready, fin;
    private TrainStatus nextStatus;

    public TrainStatus getNextStatus() {
        int max = 3;
        int min = 1;
        int range = max - min + 1;
        int statusInt = (int)(Math.random() * range) + min;
        if (statusInt == 1){
            nextStatus = late;
        }
        else if(statusInt == 2){
            nextStatus = breakdown;
        }else {
            nextStatus = ready;
        }
        return nextStatus;
    }
}
