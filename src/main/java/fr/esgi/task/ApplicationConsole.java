package fr.esgi.task;

import java.util.Scanner;

public class ApplicationConsole {
    private final Scanner scanner;

    public ApplicationConsole ( Scanner scanner ) {
        this.scanner = scanner;
    }

    public short showMessage ( String message ) {
        System.out.println ( message );
        return 0;
    }

    public int readLine() {
        return Integer.parseInt ( scanner.nextLine ( ) );
    }


    public short exit() {
        this.showMessage ( "Au revoir !" );
        System.exit ( 0 );
        return 0;
    }

}
