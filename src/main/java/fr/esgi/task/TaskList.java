package fr.esgi.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui gère la liste des tâches.
 */
public class TaskList {
    private static List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public static void addTask(String description) {
        tasks.add(new Task(tasks.size() + 1, description, false));
    }

    public static void removeTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
    }

    public static void markTaskAsCompleted(String taskId) {
        tasks.stream().filter(task -> task.getId() == Integer.parseInt(taskId)).findFirst().ifPresent(task -> task.setDone(true));


    }

    public static List<Task> getAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("La liste est vide");
        }
        return tasks;
    }
}

