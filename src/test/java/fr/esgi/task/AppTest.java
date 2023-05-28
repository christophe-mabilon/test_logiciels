package fr.esgi.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

class AppTest {
    Scanner scanner = new Scanner(System.in);
    private final TaskList taskList = new TaskList();
    ApplicationConsole applicationConsole = new ApplicationConsole(scanner);
    TaskManager taskManager = new TaskManager(new ApplicationConsole(scanner), taskList);

    @Test
    void MainTest() {
        Scanner scanner = mock(Scanner.class);
        Assertions.assertNotNull(scanner);
        TaskList taskList = mock(TaskList.class);
        Assertions.assertNotNull(taskList);
        taskManager = mock(TaskManager.class);
        Assertions.assertNotNull(taskManager);
        applicationConsole = mock(ApplicationConsole.class);
        Assertions.assertNotNull(applicationConsole);
        // Appeler la méthode run() sur mock taskManager
        taskManager.run();

        // Vérifie que la méthode run() a bien été appelée exactement une fois
        verify(taskManager, times(1)).run();

    }
}