package Avilova.Lift;

import java.util.ArrayList;
import java.io.Console;

public class SystemOfLifts {
    private ArrayList<Lift> lifts; //список лифтов
    private int numberOfFloors; //этажность
    private PrintConsole printConsole; //консоль для отрисовки
    Console console;

    SystemOfLifts(int numberOfFloors, ArrayList<Lift> lifts, Console console){
       this.numberOfFloors = numberOfFloors;
       this.lifts = lifts;
        printConsole = new PrintConsole(lifts, numberOfFloors, console);
        this.console = console;
    }

    public void run(){


        printConsole.show();
        while (!isEnd()) {
            for (Lift lift : lifts)
                if (lift.passengerList.size() != 0)
                    lift.controller.run();
            printConsole.show();
        }

    }

    public boolean isEnd (){
        for (Lift lift : lifts)
            if (lift.passengerList.size() != 0)
                return  false;
        return  true;
    }

}
