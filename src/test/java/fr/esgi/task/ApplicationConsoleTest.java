package fr.esgi.task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationConsoleTest {

    private Scanner scanner;
    private ApplicationConsole console ;
    private PrintStream originalSystemOut;
    private ByteArrayOutputStream outputStream;


    @BeforeEach
    void setUp() {
        scanner = new Scanner ( System.in );
        console = new ApplicationConsole(scanner);
        originalSystemOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalSystemOut);
    }

    @Test
    void showMessage() {
        String message = "Hello World!";
        console.showMessage(message);
        Assertions.assertEquals(message, outputStream.toString().trim());
    }

    @Test
    void readLine() {
        InputStream stdin = new ByteArrayInputStream ("0".getBytes());
        System.setIn(stdin);
        scanner = new Scanner ( System.in );
        Assertions.assertEquals(0, console.readLine(scanner));
    }

    @Test
    void exit() {
        //on vérifie que la fonction exit() a bien été appelée*/
        Assertions.assertEquals(0, console.exit());

    }





}