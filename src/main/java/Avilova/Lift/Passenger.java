package Avilova.Lift;

public class Passenger {
    private int floorOfDeparture; //этаж отправления
    private int floorOfDestination; //этаж назначения
    private  int probabilityOfEnter; //вероятность захода
    private boolean isInLift; //в лифте
    private boolean isLater; //true-приехать позже

    static final int BorderOfProbability = 20;
    static final int MaxBorder = 251;

    Passenger(int possibleInitialFloor, int possibleFinaleFloor){
        this.floorOfDeparture = possibleInitialFloor + (int)(Math.random() * ((possibleFinaleFloor - possibleInitialFloor) + 1));
        do {
            this.floorOfDestination = possibleInitialFloor + (int) (Math.random() * ((possibleFinaleFloor - possibleInitialFloor) + 1));
        } while (this.floorOfDeparture == this.floorOfDestination);

        this.probabilityOfEnter = (int)(Math.random() * MaxBorder);

        this.isLater = false;
    }

    public int getFloorOfDeparture() {
        return floorOfDeparture;
    }

    public int getFloorOfDestination() {
        return floorOfDestination;
    }

    public void setIsLater(boolean later){
        this.isLater = later;
    }

    public boolean getIsLater() {
        return isLater;
    }

    public boolean getIsInLift() {
        return isInLift;
    }

    public void setIsInLift(boolean isInLift) {
        this.isInLift  = isInLift;
    }

    public boolean isSuit() {
        if (this.probabilityOfEnter < BorderOfProbability) {
            this.probabilityOfEnter = (int)(Math.random() * MaxBorder);
            return false;
        }
        return true;
    }
}
