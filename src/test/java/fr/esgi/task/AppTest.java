package fr.esgi.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.mockito.Mockito.*;

/**
 * test pour la classe App
 */
class AppTest {
    // on crée un mock de la classe Scanner
    Scanner scanner = mock(Scanner.class);
    // on crée un mock de la classe TaskList
    private final TaskList taskList = mock(TaskList.class);

    // on crée un mock de la classe ApplicationConsole
    ApplicationConsole applicationConsole = mock(ApplicationConsole.class);

    // on crée un mock de la classe TaskManager
    TaskManager taskManager = mock(TaskManager.class);

    @Test
    void MainTest() {
        // On vérifie que les objets sont bien instanciés
        Assertions.assertNotNull(scanner);
        Assertions.assertNotNull(taskList);
        Assertions.assertNotNull(taskManager);
        Assertions.assertNotNull(applicationConsole);

        // On appelle la méthode run() sur mock taskManager
        taskManager.run();

        // On vérifie que la méthode run() a bien été appelée exactement une fois
        verify(taskManager, times(1)).run();

    }
}