package fr.esgi.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe qui gère la liste des tâches.
 */
public class TaskList {
    private static ApplicationConsole applicationConsole;
    private static List<Task> tasks = new ArrayList<> ( );
    TaskList ( ApplicationConsole applicationConsole , List<Task> tasks ) {
        TaskList.tasks = tasks;
        TaskList.applicationConsole = applicationConsole;
    }

    public static void addTask ( String description ) {
        tasks.add ( new Task (  description , false ) );
    }

    public static void removeTask ( int taskId ) {
        tasks.removeIf ( task -> task.getId ( ) == taskId );
    }

    public static void markTaskAsCompleted ( String taskId ) {
        tasks.stream ( ).filter ( task -> task.getId ( ) == Integer.parseInt ( taskId ) ).findFirst ( ).ifPresent ( task -> task.setDone ( true ) );


    }

    public static List<Task> getAllTasks () {

        if (tasks != null) {
            return tasks;

        } else {
            applicationConsole.showMessage ( "La liste est vide" );
            return Collections.emptyList ( );
        }

    }


}

