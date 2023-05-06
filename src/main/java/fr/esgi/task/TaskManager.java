package fr.esgi.task;
import java.util.List;
import java.util.Scanner;

import static fr.esgi.task.TaskList.getAllTasks;


public class TaskManager {
    private static ApplicationConsole applicationConsole;

    //declaration du scanner pour les entrées clavier
    static Scanner scanner = new Scanner(System.in);
    int choice;

    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    public TaskManager(ApplicationConsole applicationConsole) {

       TaskManager.applicationConsole = applicationConsole;
    }

    /**
     * Affiche le menu et appelle la méthode correspondante en fonction du choix de l'utilisateur.
     */
    public void run() {
        //declaration de la variable choice pour le choix de l'utilisateur
       do {
            displayMenu();
           choice = applicationConsole.readLine();
            switch (choice) {
                case 1 -> addTask();
                case 2 -> markATaskAsCompleted();
                case 3 -> removeTask();
                case 4 -> displayTasks();
                case 5 -> System.exit(0);
                default -> applicationConsole.showMessage("Choix invalide");
            }
        } while (choice>0 && choice<6);
    }

    private void displayMenu() {
        applicationConsole.showMessage("1. Ajouter une tâche");
        applicationConsole.showMessage("2. Marquer une tâche comme terminée");
        applicationConsole.showMessage("3. Supprimer une tâche");
        applicationConsole.showMessage("4. Afficher la liste des tâches");
        applicationConsole.showMessage("5. Quitter");
        applicationConsole.showMessage("Saisissez votre choix: ");
    }

    /**
     * Ajoute une tâche à la liste.
     */
    static void addTask() {
        applicationConsole.showMessage("Entrez la description de la tâche : ");
        String description = scanner.nextLine();
        TaskList.addTask(description);
    }




    /**
     * Marque une tâche comme terminée.
     */
    static void markATaskAsCompleted() {
        applicationConsole.showMessage("Entrez l'ID de la tâche à marquer comme terminée : ");
        int id = applicationConsole.readLine();
        Task task = getAllTasks().stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        if (task != null) {
            TaskList.markTaskAsCompleted(String.valueOf(id));
            applicationConsole.showMessage("Tâche marquée comme terminée avec succès");
        } else {
            applicationConsole.showMessage("Tâche non trouvée");
        }
    }

    /**
     * Supprime une tâche de la liste.
     */
    static void removeTask() {
        applicationConsole.showMessage("Entrez l'ID de la tâche à supprimer : ");
        int id = applicationConsole.readLine();
        Task task = getAllTasks().stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        if (task != null) {
            TaskList.removeTask(id);
            applicationConsole.showMessage("Tâche supprimée avec succès");
        } else {
            applicationConsole.showMessage("Tâche non trouvée");
        }
    }

    /**
     * Affiche la liste des tâches.
     */
    static void displayTasks() {
        List<Task> tasks;
        tasks = getAllTasks();
        if (!tasks.isEmpty()) {
            tasks.forEach(task -> applicationConsole.showMessage(task.toString()));
        } else {
          applicationConsole.showMessage("La liste est vide");
        }
    }


}