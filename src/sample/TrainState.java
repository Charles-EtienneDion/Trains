package sample;

public enum TrainState {
    A1, AB, A2, A3, A4, ABC, A5, FINISH, B1, B2, B3, BC, B5, B6, B7;
    private TrainState nextState;

    public TrainState getNextState() {
        return nextState;
    }

    static {
        A1.nextState = AB;
        AB.nextState = A3;
//            A2.nextState = A3;
        A3.nextState = ABC;
        ABC.nextState = A5;
//            A4.nextState = A5;
        A5.nextState = FINISH;
        FINISH.nextState = null;

        B1.nextState = AB;
        AB.nextState = B3;
//            B2.nextState = B3;
        B3.nextState = BC;
        BC.nextState = B5;
        B5.nextState = ABC;
        ABC.nextState = B7;
//            B6.nextState = B7;
        B7.nextState = FINISH;
        FINISH.nextState = null;

    }
//    public enum TrainStateA {
//        A1, AB, A2, A3, A4, ABC, A5, FINISH;
//        private TrainStateA nextState;
//
//        static {
//            A1.nextState = AB;
//            AB.nextState = A3;
////            A2.nextState = A3;
//            A3.nextState = ABC;
//            ABC.nextState = A5;
////            A4.nextState = A5;
//            A5.nextState = FINISH;
//            FINISH.nextState = null;
//        }
//
//        public TrainStateA getNextState() {
//            return this.nextState;
//        }
//    }
//
//    public enum TrainStateB {
//        B1, AB, B2, B3, BC, B5, B6, B7, ABC, FINISH;
//        private TrainStateB nextState;
//
//        static {
//            B1.nextState = AB;
//            AB.nextState = B3;
////            B2.nextState = B3;
//            B3.nextState = BC;
//            BC.nextState = B5;
//            B5.nextState = ABC;
//            ABC.nextState = B7;
////            B6.nextState = B7;
//            B7.nextState = FINISH;
//            FINISH.nextState = null;
//        }
//
//        public TrainStateB getNextState() {
//            return this.nextState;
//        }
//    }
}
