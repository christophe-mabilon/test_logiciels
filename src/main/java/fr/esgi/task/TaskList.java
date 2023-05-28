package fr.esgi.task;

import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator<Task> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId().equals(taskId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean markTaskAsCompleted ( Long taskId ) {
        for (Task task : taskList) {
            if (Objects.equals ( task.getId ( ) , taskId )) {
                task.setDone ( true );
                return true;
            }
        }
        return false;

    }

    /**
     * Retourne la liste des tâches.
     * @return la liste des tâches.
     * @see Task
     */
    public List<Task> getAllTasks () {
        return taskList;
    }

    /**
     * Recherche une tache par son id
     *
     */
    public Task findById( long id){
        return taskList.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }
    public Task findByDescription(String description){
        return taskList.stream().filter(task -> task.getDescription().equals(description)).findFirst().orElse(null);
    }

    public boolean containsTask ( String description ) {
        for (Task task : taskList) {
            if (task.getDescription ( ).equals ( description )) {
                return true;
            }
        }
        return false;
    }
}

