package fr.esgi.task;

import java.util.Scanner;

public class ApplicationConsole {
    private final Scanner scanner;

    public ApplicationConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int readLine() {
        return Integer.parseInt(scanner.nextLine());
    }
}
