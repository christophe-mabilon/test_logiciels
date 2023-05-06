package fr.esgi.task;
import java.util.List;
import java.util.Scanner;

import static fr.esgi.task.TaskList.getAllTasks;


public class TaskManager {
    private static TaskList taskList;
    private Task task;
    //declaration du scanner pour les entrées clavier
    static Scanner scanner = new Scanner(System.in);


    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    public TaskManager() {
        taskList = new TaskList();
        task = new Task();
    }

    /**
     * Affiche le menu et appelle la méthode correspondante en fonction du choix de l'utilisateur.
     */
    public void run() {
        //declaration de la variable choice pour le choix de l'utilisateur
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addTask();
                case 2 -> markATaskAsCompleted();
                case 3 -> removeTask();
                case 4 -> displayTasks();
                case 5 -> System.exit(0);
                default -> System.out.println("Choix invalide");
            }
        } while (choice != 5);
    }

    private void displayMenu() {
        System.out.println("1. Ajouter une tâche");
        System.out.println("2. Marquer une tâche comme terminée");
        System.out.println("3. Supprimer une tâche");
        System.out.println("4. Afficher la liste des tâches");
        System.out.println("5. Quitter");
        System.out.println("Saisissez votre choix: ");
    }

    /**
     * Ajoute une tâche à la liste.
     */
    static void addTask() {
        System.out.println("Entrez la description de la tâche : ");
        String description = scanner.nextLine();
        TaskList.addTask(description);
    }




    /**
     * Marque une tâche comme terminée.
     */
    static void markATaskAsCompleted() {
        System.out.println("Entrez l'ID de la tâche à marquer comme terminée : ");
        int id = scanner.nextInt();
        Task task = getAllTasks().stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        if (task != null) {
            TaskList.markTaskAsCompleted(String.valueOf(id));
            System.out.println("Tâche marquée comme terminée avec succès");
        } else {
            System.out.println("Tâche non trouvée");
        }
    }

    /**
     * Supprime une tâche de la liste.
     */
    static void removeTask() {
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        int id = scanner.nextInt();
        Task task = getAllTasks().stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        if (task != null) {
            TaskList.removeTask(id);
            System.out.println("Tâche supprimée avec succès");
        } else {
            System.out.println("Tâche non trouvée");
        }
    }

    /**
     * Affiche la liste des tâches.
     */
    static void displayTasks() {
        List<Task> tasks;
        tasks = getAllTasks();
        if (!tasks.isEmpty()) {
            tasks.forEach(task -> System.out.println(task.toString()));
        } else {
          System.out.println("La liste est vide");
        }
    }


}