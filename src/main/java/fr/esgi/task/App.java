package fr.esgi.task;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(new ApplicationConsole(scanner));
        taskManager.run();
    }
}