package Avilova.Lift;
import java.util.ArrayList;

public class Lift {
    private boolean rout; //направление true-вверх false-вниз
    private int location; //местонахождение
    private int vol; //вместительность
    private int possibleInitialFloor; //возможный начальный этаж
    private int possibleFinaleFloor; //возможный конечный этаж
    public ArrayList<Passenger> passengerList; //список пассажиров
    private int number; //номер лифта
    public ControllerOfLift controller;

    Lift(boolean rout, int location,int vol,int possibleInitialFloor,int possibleFinaleFloor, int numberOfPassenger, int number){
        this.rout = rout;
        this.location = location;
        this.vol = vol;
        this.possibleInitialFloor = possibleInitialFloor;
        this.possibleFinaleFloor = possibleFinaleFloor;
        this.passengerList = createPassanger(numberOfPassenger);
        this.number = number;
        controller = new ControllerOfLift(this);
    }

    public boolean getRout() {
        return rout;
    }

    public void setRout(boolean rout) {
        this.rout  = rout;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location  = location;
    }

    public int getVol() {
        return vol;
    }

    public int getPossibleInitialFloor() {
        return possibleInitialFloor;
    }

    public int getPossibleFinaleFloor() {
        return possibleFinaleFloor;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Passenger> createPassanger(int numberOfPassenger){
        ArrayList<Passenger> passengerList= new ArrayList<Passenger>();
        for (int i = 0; i < numberOfPassenger; i++)
            passengerList.add(new Passenger( this.possibleInitialFloor, this.possibleFinaleFloor));
        return  passengerList;
    }

    public int colOfPassangeInLift(){
        int col = 0;
        for (int i = 0; i < passengerList.size(); i++)
            if (passengerList.get(i).getIsInLift())
                col++;
        return col;
    }
}
