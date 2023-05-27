package fr.esgi.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui gère la liste des tâches.
 */
public class TaskList {
    private List<Task> tasks = new ArrayList<> ( );

    public TaskList () {
    }

    public TaskList ( List<Task> tasks ) {
        this.tasks = tasks;

    }

    public void addTask ( String description ) {
        tasks.add ( new Task ( description , false ) );
    }

    public boolean removeTask ( int taskId ) {
        if (tasks.stream ( ).anyMatch ( task -> task.getId ( ) == taskId )) {
            tasks.removeIf ( task -> task.getId ( ) == taskId );
            return true;
        } else {
            return false;
        }

    }

    public Task markTaskAsCompleted ( String taskId ) {
        Task task = tasks.stream ( ).filter ( t -> t.getId ( ) == Integer.parseInt ( taskId ) ).findFirst ( ).orElse ( null );
        if (task != null) {
            task.setDone ( true );
            return task;
        } else {
            return null;
        }

    }

    public List<Task> getAllTasks () {
        return tasks;
    }


}

