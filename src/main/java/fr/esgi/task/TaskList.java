package fr.esgi.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe qui gère la liste des tâches.
 */
public class TaskList {
    private List<Task> taskList = new ArrayList<> ( );


    public TaskList () {
    }

    public TaskList ( List<Task> tasks ) {
        taskList = new ArrayList<> ( tasks );
    }

    public void addTask ( String description ) {
        taskList.add ( new Task ( description , false ) );
    }

    public boolean removeTask ( Long taskId ) {
        for (Task task : taskList) {
            if (task.getId ( ).equals ( taskId )) {
                taskList.remove ( task );
                return true;
            }
        }
        return false;
    }

    public boolean markTaskAsCompleted ( int taskId ) {
        for (Task task : taskList) {
            if (Objects.equals ( task.getId ( ) , Long.valueOf ( taskId ) )) {
                task.setDone ( true );
                return true;
            }
        }
        return false;

    }

    public List<Task> getAllTasks () {
        return taskList;
    }

    /**
     * Recherche une tache par son id
     */
    Task findById( long id){
        return taskList.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }
}

