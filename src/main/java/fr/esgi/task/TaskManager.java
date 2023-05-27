package fr.esgi.task;
import java.util.List;
import java.util.Scanner;


public class TaskManager {
    static ApplicationConsole applicationConsole;

    private final TaskList taskList ;

    //declaration du scanner pour les entrées clavier
    static Scanner scanner = new Scanner(System.in);
    int choice;

    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    public TaskManager( ApplicationConsole applicationConsole , TaskList taskList ) {
        this.applicationConsole = applicationConsole;
        this.taskList = taskList;
    }

    /**
     * Affiche le menu et appelle la méthode correspondante en fonction du choix de l'utilisateur.
     */
    public void run() {
        //declaration de la variable choice pour le choix de l'utilisateur
       do {
            displayMenu();
           choice = applicationConsole.readLine();
            switch (Integer.parseInt(String.valueOf ( choice )) ) {
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
        applicationConsole.showMessage("-----------------------------------------------");
        applicationConsole.showMessage("Bienvenue dans votre gestionnaire de tâches !");
        applicationConsole.showMessage("1. Ajouter une tâche");
        applicationConsole.showMessage("2. Marquer une tâche comme terminée");
        applicationConsole.showMessage("3. Supprimer une tâche");
        applicationConsole.showMessage("4. Afficher la liste des tâches");
        applicationConsole.showMessage("5. Quitter");
        applicationConsole.showMessage("Saisissez votre choix: ");
        applicationConsole.showMessage("-----------------------------------------------");
    }

    /**
     * Ajoute une tâche à la liste.
     */
    void addTask() {
        applicationConsole.showMessage("Entrez la description de la tâche : ");
        String description = scanner.nextLine();
        taskList.addTask(description);
        applicationConsole.showMessage("La Tâche " + description +  " a été ajoutée avec succès\n");
    }




    /**
     * Marque une tâche comme terminée.
     */
    void markATaskAsCompleted() {
        if (!taskList.getAllTasks ().isEmpty ()) {
            applicationConsole.showMessage("Voila la liste des tâches : ");
            List<Task> tasks = taskList.getAllTasks ();
            tasks.forEach(task -> applicationConsole.showMessage(task.toString()));
        } else {
            applicationConsole.showMessage("La liste est vide\n");
            return;
        }
        applicationConsole.showMessage("Sélectionnez l'ID de la tâche à marquer comme terminée : ");
        int id = applicationConsole.readLine();
        Task task = taskList.markTaskAsCompleted(String.valueOf(id));
        if (task != null) {
            taskList.markTaskAsCompleted(String.valueOf(id));
            applicationConsole.showMessage("Tâche marquée comme terminée avec succès\n");
        } else {
            applicationConsole.showMessage("Tâche non trouvée\n");
        }
    }

    /**
     * Supprime une tâche de la liste.
     */
    void removeTask() {
        if (!taskList.getAllTasks ().isEmpty ()) {
        applicationConsole.showMessage("Voila la liste des tâches : ");
        List<Task> tasks = taskList.getAllTasks ();
        tasks.forEach(task -> applicationConsole.showMessage(task.toString()));
    } else {
        applicationConsole.showMessage("La liste est vide\n");
        return;
    }
        applicationConsole.showMessage("Entrez l'ID de la tâche à supprimer : ");
        int id = applicationConsole.readLine();
        boolean taskRemoved = taskList.removeTask ( id );
        if (taskRemoved) {
            taskList.removeTask(id);
            applicationConsole.showMessage("Tâche supprimée avec succès\n");
        } else {
            applicationConsole.showMessage("Tâche non trouvée\n");
        }
    }


    /**
     * Affiche la liste des tâches.
     */
    void displayTasks() {
        List<Task> tasks = taskList.getAllTasks();
        if (!tasks.isEmpty()) {
            applicationConsole.showMessage("Voila la liste des tâches : ");
            tasks.forEach(task -> applicationConsole.showMessage(task.toString()));
        } else {
          applicationConsole.showMessage("La liste est vide\n");
        }
    }


}