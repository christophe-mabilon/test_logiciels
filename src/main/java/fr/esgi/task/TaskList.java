package fr.esgi.task;

import java.util.ArrayList;
import java.util.List;

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

    public Task markTaskAsCompleted ( String taskId ) {
        Task task = taskList.stream ( ).filter ( t -> t.getId ( ) == Integer.parseInt ( taskId ) ).findFirst ( ).orElse ( null );
        if (task != null) {
            task.setDone ( true );
            return task;
        } else {
            return null;
        }

    }

    public List<Task> getAllTasks () {
        return taskList;
    }

    /**
     * Recherche une tache par son id
     */
    Task findById( long id){
        Task task = this.taskList.stream ().filter ( t -> t.getId () == id ).findFirst ().orElse ( null );
        return task;


    }
}

