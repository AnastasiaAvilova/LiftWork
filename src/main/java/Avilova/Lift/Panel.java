package Avilova.Lift;
import java.util.ArrayList;
import  java.io.Console;

public class Panel{
    private ArrayList<ObjectOfGraphics> objects; //список объектов отрисовки
    private ArrayList<Lift> lifts; //список лифтов
    private String [][] matr; //матрица отрисовки
    private int numberOfFloors; //этажность
    private Console console;

    Panel(String [][] matr , int numberOfFloors, ArrayList<Lift> lifts, Console console){
        this.matr = matr;
        this.numberOfFloors = numberOfFloors;
        this.lifts = lifts;
        this.console = console;
        this.objects = CreateObjects(lifts);
    }

    private ArrayList<ObjectOfGraphics> CreateObjects(ArrayList<Lift>lifts){
        ArrayList<ObjectOfGraphics> objects= new ArrayList<ObjectOfGraphics>();
        for (Lift lift: lifts)
            objects.add(new ObjectOfGraphics(lift, numberOfFloors, matr, console));
        return  objects;
    }

    public void showGraphics() {
        for (ObjectOfGraphics object: objects)
            object.showGraphics();
    }

    public void showInfo() {
        for (ObjectOfGraphics object: objects)
            object.showInfo();
    }
    public  void showInfoPassange(){
        for (ObjectOfGraphics object: objects)
            object.showInfoPassange();
    }
}
