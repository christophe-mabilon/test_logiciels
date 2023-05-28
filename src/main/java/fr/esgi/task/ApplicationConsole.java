package fr.esgi.task;

import java.util.Scanner;

public class ApplicationConsole {
    private final Scanner scanner;

public ApplicationConsole(Scanner scanner) {
        this.scanner = new Scanner ( System.in );
    }




    public Object showMessage ( String message ) {
        System.out.println ( message );
        return null;
    }

    public int readLine(Scanner scanner) {
    return  Integer.parseInt ( scanner.nextLine ( ) );
    }


    public short exit() {
        this.showMessage ( "Au revoir !" );
        System.exit ( 0 );

        return 0;
    }

}
