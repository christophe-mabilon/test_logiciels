package fr.esgi.task;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;



class TaskManagerTest {

    @Test
    public void menuTest_addTask(){
        ApplicationConsole applicationConsoleMock = mock(ApplicationConsole.class);
        when(applicationConsoleMock.readLine()).thenReturn(1);

        TaskManager target = new TaskManager(applicationConsoleMock);
        target.run();

        verify(applicationConsoleMock, times(1)).showMessage("1. Ajouter une tâche");
    }

    @Test
    public void menuTest_markATaskAsCompleted(){
        ApplicationConsole applicationConsoleMock = mock(ApplicationConsole.class);

        when(applicationConsoleMock.readLine()).thenReturn(2);

        TaskManager target = new TaskManager(applicationConsoleMock);
        target.run();

        verify(applicationConsoleMock, times(1)).showMessage("2. Marquer une tâche comme terminée");
    }

    @Test
    public void menuTest_removeTask(){
        ApplicationConsole applicationConsoleMock = mock(ApplicationConsole.class);

        when(applicationConsoleMock.readLine()).thenReturn(3);

        TaskManager target = new TaskManager(applicationConsoleMock);
        target.run();

        verify(applicationConsoleMock, times(1)).showMessage("3. Supprimer une tâche");
    }

    @Test
    public void menuTest_displayTasks(){
        ApplicationConsole applicationConsoleMock = mock(ApplicationConsole.class);

        when(applicationConsoleMock.readLine()).thenReturn(4);

        TaskManager target = new TaskManager(applicationConsoleMock);
        target.run();

        verify(applicationConsoleMock, times(1)).showMessage("1. Ajouter une tâche");
    }
    @Test
    public void menuTest_exit(){
        ApplicationConsole applicationConsoleMock = mock(ApplicationConsole.class);

        when(applicationConsoleMock.readLine()).thenReturn(5);

        TaskManager target = new TaskManager(applicationConsoleMock);
        target.run();

        verify(applicationConsoleMock, times(1)).showMessage("5. Quitter");
    }

    @Test
    public void menuTest_errorChoice(){
        ApplicationConsole applicationConsoleMock = mock(ApplicationConsole.class);

        when(applicationConsoleMock.readLine()).thenReturn(6);

        TaskManager target = new TaskManager(applicationConsoleMock);
        target.run();

        verify(applicationConsoleMock, times(1)).showMessage("Choix invalide");
    }
}