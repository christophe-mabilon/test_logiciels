package fr.esgi.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationConsoleTest {

    private Scanner scanner;
    private ApplicationConsole console ;
    private ByteArrayOutputStream outputStream;

    /**
     * méthode  de demarage qui permet de mettre en place les tests et d'instancier les dépandances
     */
    @BeforeEach
    void setUp() {
        scanner = new Scanner ( System.in );
        console = new ApplicationConsole(scanner);
    }


    /**
     * Méthode qui permet de tester si le message est affiché
     * @return void ne retourne rien
     *
     */
    @Test
    void showMessage() {
        String message = "Hello World!";
        console.showMessage(message);
        Assertions.assertEquals(message, outputStream.toString().trim());
    }


    /**
     * Méthode qui permet de lire une ligne
     * @return void ne retourne rien
     *
     */
    @Test
    void readLine() {
        InputStream stdin = new ByteArrayInputStream ("0".getBytes());
        System.setIn(stdin);
        scanner = new Scanner ( System.in );
        Assertions.assertEquals(0, console.readLine(scanner));

        stdin = new ByteArrayInputStream ("1".getBytes());
        System.setIn(stdin);
        scanner = new Scanner ( System.in );
        Assertions.assertEquals(1, console.readLine(scanner));

        stdin = new ByteArrayInputStream ("2".getBytes());
        System.setIn(stdin);
        scanner = new Scanner ( System.in );
        Assertions.assertEquals(2, console.readLine(scanner));

        stdin = new ByteArrayInputStream ("3".getBytes());
        System.setIn(stdin);
        scanner = new Scanner ( System.in );
        Assertions.assertEquals(3, console.readLine(scanner));

        stdin = new ByteArrayInputStream ("4".getBytes());
        System.setIn(stdin);
        scanner = new Scanner ( System.in );
        Assertions.assertEquals(4, console.readLine(scanner));
    }


    /**
     * Méthode qui permet de quitter le programme
     * @return 0 si le programme est quitté
     * @return 1 si le programme n'est pas quitté
     * @return -1 si le programme est quitté
     */
    @Test
    void exit() {
        ApplicationConsole console = mock(ApplicationConsole.class);
        when(console.exit()).thenReturn( (short) 0 );
        when(console.exit()).thenReturn( Short.valueOf ( "1" ) );
        when(console.exit()).thenReturn( Short.valueOf ( "-1" ) );
        Assertions.assertEquals(-1, console.exit());
    }
}