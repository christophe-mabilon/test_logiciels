package fr.esgi.task;

import java.util.List;
import java.util.Scanner;


public class TaskManager {

    //declaration du scanner pour les entrées clavier
    static Scanner scanner = new Scanner ( System.in );

    private ApplicationConsole applicationConsole = new ApplicationConsole ( scanner );
    private TaskList taskList = new TaskList ( );
    int choice;

    /**
     * Constructeur de la classe TaskManager
     *
     * @param taskList tasklist
     */
    public TaskManager ( TaskList taskList ) {
        this.taskList = taskList;
    }


    /**
     * Constructeur de la classe TaskManager
     *
     * @param applicationConsole applicationConsole
     * @param taskList           tasklist
     */
    public TaskManager ( ApplicationConsole applicationConsole , TaskList taskList ) {
        this.applicationConsole = applicationConsole;
        this.taskList = taskList;
    }


    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    private TaskManager () {

    }

    /**
     * Affiche le menu et appelle la méthode correspondante en fonction du choix de l'utilisateur.
     */
    public void run () {
        do {
            displayMenu ( );
            choice = Integer.parseInt ( scanner.nextLine ( ) );
            if(choice < 0 || choice > 5){
                choice = 0;
            }
            switch (choice) {
                case 1 -> addTask ( scanner );
                case 2 -> markATaskAsCompleted ( );
                case 3 -> removeTask ( );
                case 4 -> displayTasks ( );
                case 5 -> applicationConsole.exit ( );
                default -> applicationConsole.showMessage ( "Choix Invalid ! Veuillez saisir un nombre correct" );
            }
        } while (choice >= 0 && choice < 6);
    }

    /**
     * Affiche le menu.
     *
     * @return
     */
    public short displayMenu () {

        String divider = "-----------------------------------------------\n";
        String welcome = "Bienvenue dans votre gestionnaire de tâches !\n";
        String choix1 = "1. Ajouter une tâche\n";
        String choix2 = "2. Marquer une tâche comme terminée\n";
        String choix3 = "3. Supprimer une tâche\n";
        String choix4 = "4. Afficher la liste des tâches\n";
        String choix5 = "5. Quitter\n";
        String choix6 = "Saisissez votre choix: \n";
        return
                applicationConsole.showMessage ( divider +
                        welcome +
                        divider +
                        choix1 +
                        choix2 +
                        choix3 +
                        choix4 +
                        choix5 +
                        choix6 + divider );
    }

    /**
     * Ajoute une tâche à la liste.
     *
     * @param scanner Scanner
     * @return void
     */
    void addTask ( Scanner scanner ) {
        applicationConsole.showMessage ( "Entrez la description de la tâche : " );
        String description = scanner.nextLine ( );
        taskList.addTask ( description );
        applicationConsole.showMessage ( "La Tâche " + description + " a été ajoutée avec succès\n" );
    }


    /**
     * Marque une tâche comme terminée.
     */
    void markATaskAsCompleted () {
        if (!taskList.getAllTasks ( ).isEmpty ( )) {
            applicationConsole.showMessage ( "Voila la liste des tâches : " );
            List<Task> tasks = taskList.getAllTasks ( );
            tasks.forEach ( task -> applicationConsole.showMessage ( task.toString ( ) ) );
        } else {
            applicationConsole.showMessage ( "La liste est vide\n" );
            return;
        }
        applicationConsole.showMessage ( "Sélectionnez l'ID de la tâche à marquer comme terminée : " );
        int id = applicationConsole.readLine ( );
        boolean task = taskList.markTaskAsCompleted ( (long) id ) ;
        if (task) {
            taskList.markTaskAsCompleted ( (long) id ) ;
            applicationConsole.showMessage ( "Tâche marquée comme terminée avec succès\n" );
        } else {
            applicationConsole.showMessage ( "Tâche non trouvée\n" );
        }
    }

    /**
     * Supprime une tâche de la liste.
     */
    void removeTask () {
        if (!taskList.getAllTasks ( ).isEmpty ( )) {
            applicationConsole.showMessage ( "Voila la liste des tâches : " );
            List<Task> tasks = taskList.getAllTasks ( );
            tasks.forEach ( task -> applicationConsole.showMessage ( task.toString ( ) ) );
        } else {
            applicationConsole.showMessage ( "La liste est vide\n" );
            return;
        }
        applicationConsole.showMessage ( "Entrez l'ID de la tâche à supprimer : " );
        long id = applicationConsole.readLine ( );
        boolean taskRemoved = taskList.removeTask ( (long) id );
        if (taskRemoved) {
            taskList.removeTask ( (long) id );
            applicationConsole.showMessage ( "Tâche supprimée avec succès\n" );
        } else {
            applicationConsole.showMessage ( "Tâche non trouvée\n" );
        }
    }


    /**
     * Affiche la liste des tâches.
     *
     * @return
     */
    short displayTasks () {
        List<Task> tasks = taskList.getAllTasks ( );
        if (!tasks.isEmpty ( )) {
            applicationConsole.showMessage ( "Voila la liste des tâches : " );
            tasks.forEach ( task -> applicationConsole.showMessage ( task.toString ( ) ) );
        } else {
            applicationConsole.showMessage ( "La liste est vide\n" );
        }
        return 0;
    }


}