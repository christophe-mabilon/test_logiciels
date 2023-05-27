package fr.esgi.task;

import java.util.Scanner;

public class ApplicationConsole {
    private final Scanner scanner;

    public ApplicationConsole ( Scanner scanner ) {
        this.scanner = scanner;
    }

    public void showMessage ( String message ) {
        System.out.println ( message );
    }

    public int readLine () {
        try {
            return Integer.parseInt ( scanner.nextLine ( ) );
        } catch (NumberFormatException e) {
            showMessage ( "Choix Invalid ! Veuillez saisir un nombre" );
            return readLine ( ); // Essaye de relire les données
        }
    }
}
