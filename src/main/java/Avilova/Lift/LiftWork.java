package Avilova.Lift;

import java.io.Console;


public class LiftWork {
    public static void main(String[] args) {


        Console console = System.console();
        if(console!=null) {
            // считываем данные с консоли
        /*   String login = console.readLine("Введите логин:");
            char[] password = console.readPassword("Введите пароль:");
            console.printf("Введенны9й логин: %s \n", login);
            console.printf("Введенный пароль: %s \n", new String(password));
*/
            UserInterfase userInterfase = new UserInterfase(console);
            userInterfase.write();
            userInterfase.run();
        }
    }
}
