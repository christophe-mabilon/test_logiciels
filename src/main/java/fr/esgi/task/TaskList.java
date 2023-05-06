package fr.esgi.task;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Classe qui gère la liste des tâches.
 */
public class TaskList {
    //declaration du logger pour l'affichage des messages
    private static final Logger logger = Logger.getLogger(TaskList.class.getName());
    //declaration du scanner pour les entrées clavier
    static Scanner scanner = new Scanner(System.in);
    //declaration de la liste des tâches
    private static List<Task> tasks;





    /**
     * Retourne la liste des tâches.
     */
    public static List<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Ajoute une tâche à la liste.
     */
    static void addTask() {
        logger.info("Entrez la description de la tâche : ");
        String description = scanner.nextLine();
        Task task = new Task(getAllTasks().size() + 1, description, false);
        getAllTasks().add(task);
    }


    /**
     * Marque une tâche comme terminée.
     */
    static void markATaskAsCompleted() {
        logger.info("Entrez l'ID de la tâche à marquer comme terminée : ");
        int id = scanner.nextInt();
        Task task = getAllTasks().stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        if (task != null) {
            task.setDone(true);
            logger.info("Tâche marquée comme terminée avec succès");
        } else {
            logger.info("Tâche non trouvée");
        }
    }

    /**
     * Supprime une tâche de la liste.
     */
    static void removeTask() {
        logger.info("Entrez l'ID de la tâche à supprimer : ");
        int id = scanner.nextInt();
        Task task = getAllTasks().stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        if (task != null) {
            getAllTasks().remove(task);
            logger.info("Tâche supprimée avec succès");
        } else {
            logger.info("Tâche non trouvée");
        }
    }

    /**
     * Affiche la liste des tâches.
     */
    static void displayTasks() {
        getAllTasks().forEach(task -> logger.info(task.toString()));
    }


}

