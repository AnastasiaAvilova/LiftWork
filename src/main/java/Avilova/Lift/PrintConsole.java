package Avilova.Lift;

import java.io.Console;
import java.util.ArrayList;


public class PrintConsole {

    private ArrayList<Lift> lifts; //список лифтов
    private String [][] matr; //матрица отрисовки
    private int numberOfFloors; //этажность
    private String strinfo; //инфомационная строка
    private Panel panel; //панель
    private Console console;

    PrintConsole(ArrayList<Lift> lifts, int numberOfFloors, Console console){
        this.lifts = lifts;
        this.numberOfFloors = numberOfFloors;
        strinfo = "";
        matr = new String[2 * numberOfFloors + 1][7 + (lifts.size() - 1) * 4];
        createMatr();
        this.console = console;
        panel = new Panel(matr, numberOfFloors, lifts, this.console);
    }

    private void createMatr() {

        for (int i = 0; i <= 2 * numberOfFloors; i++)
            for (int j = 0; j <= 6 + (lifts.size() - 1) * 4; j++)
                matr[i][j] = "   ";

        // рисуем "-"
        for (int i = 0; i <= 2 * numberOfFloors; i += 2)
            for (int j = 3; j < 6 + (lifts.size() - 1) * 4; j++)
                matr[i][j] = "---";

        // рисуем "|"
        for (int i = 1; i < 2 * numberOfFloors; i++) {
            matr[i][0] = " | ";
            matr[i][2] = " | ";
            matr[i][6 + (lifts.size() - 1) * 4] = " | ";
        }

        // рисуем номер лифта
        for (int i = 1, j = 0; i < 2 * numberOfFloors; i += 2, j++)
            if (numberOfFloors - j <= 9)
                matr[i][1] = Integer.toString(numberOfFloors - j) + "  ";
            else
                matr[i][1] = Integer.toString(numberOfFloors - j)+ " ";

        for (int i = 1; i <= 2 * numberOfFloors - 1; i += 2)
            for (int j = 0; j < lifts.size(); j++)
                matr[i][6 + 4 * j] = " | ";
        ;
    }

    public void show(){




        panel.showGraphics();
        printMatr();
        panel.showInfo();
        ShowInfoPassange();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return;
        }
    }

    private void printMatr(){
        for (int i = 0; i <= 2 * numberOfFloors; i ++) {
            for (int j = 0; j <= 6 + (lifts.size() - 1) * 4; j++)
                console.printf(matr[i][j]);
            console.printf("\n");
        }
    }

    public void ShowInfoPassange(){
        panel.showInfoPassange();
    }
}
