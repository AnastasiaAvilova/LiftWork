package Avilova.Lift;
import java.io.Console;

import java.util.ArrayList;

public class UserInterfase {

    private ArrayList<Lift> lifts; //список лифтов
    private int numberOfFloors; //этажность
    private SystemOfLifts systemOfLifts;
    private Console console;

    UserInterfase(Console console){
        lifts = new ArrayList<Lift>();
        numberOfFloors = 0;
        this.console = console;
    }

    public void write(){

        String str = "";
        int numOfLift = 0;


        str = console.readLine("Введите этажность дома: ");
        while (!isDigital(str))
            str = console.readLine("Ошибка! Введите этажность дома: ");
        numberOfFloors = Integer.valueOf(str);

        str = console.readLine("Введите количество лифтов в доме: ");
        while (!isDigital(str))
            str = console.readLine("Ошибка! Введите количество лифтов в доме: ");
        numOfLift = Integer.valueOf(str);


        for (int i = 0; i < numOfLift; i++){
            int numOfPassanger = 0;
            str = console.readLine("Введите количество пассажиров, которые хотят поехать на лифте №:" + (i+1)+ " ");
            while (!isDigital(str))
                str = console.readLine("Ошибка! Введите количество пассажиров, которые хотят поехать на лифте №:" + (i+1)+ " ");
            numOfPassanger = Integer.valueOf(str);

            int vol = 0;
            str = console.readLine("Введите вместительность лифта №:" + (i+1)+ " ");
            while (!isDigital(str))
                str = console.readLine("Ошибка! Введите вместительность лифта №:" + (i+1)+ " ");
            vol = Integer.valueOf(str);

            int possibleInitialFloor = 0;
            do {
                str = console.readLine("Введите возможный начальный этаж лифта №:" + (i + 1) + " ");

                while (!isDigital(str))
                    str = console.readLine("Ошибка! Введите возможный начальный этаж лифта №:" + (i + 1) + " ");
            } while (Integer.valueOf(str) > numberOfFloors);
            possibleInitialFloor = Integer.valueOf(str);

            int possibleFinaleFloor = 0;
            do {
                str = console.readLine("Введите возможный конечный этаж лифта №:" + (i + 1) + " ");
                while (!isDigital(str))
                    str = console.readLine("Ошибка! Введите возможный конечный этаж лифта №:" + (i + 1) + " ");
            } while ((Integer.valueOf(str) < possibleInitialFloor) && (Integer.valueOf(str) > numberOfFloors ));
            possibleFinaleFloor = Integer.valueOf(str);

            lifts.add( new Lift(true, possibleInitialFloor, vol, possibleInitialFloor, possibleFinaleFloor, numOfPassanger, i));
        }
    }

    public static boolean isDigital(String str) {
        if(str.length()==0 || str.length() > 20)
            return false;
        for(Character x:str.toCharArray())
            if(Character.isLetter(x))
                return false;
        if (Integer.valueOf(str) <= 0)
            return false;
        return true;
    }

    public void run(){
        systemOfLifts = new SystemOfLifts(numberOfFloors,lifts, console);
        systemOfLifts.run();
    }

}
