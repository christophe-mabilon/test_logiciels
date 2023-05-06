package fr.esgi.task;

import java.util.Scanner;

import static fr.esgi.task.TaskList.*;
import static fr.esgi.task.TaskList.displayTasks;

public class TaskManager {

    //declaration du scanner pour les entrées clavier
    static Scanner scanner = new Scanner(System.in);
    //declaration de la variable choice pour le choix de l'utilisateur
    static  int choice = scanner.nextInt();

    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    public TaskManager() {

    }



    /**
     * Affiche le menu et appelle la méthode correspondante en fonction du choix de l'utilisateur.
     * @see Exception
     */
    public  void menu() {
        try{
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Marquer une tâche comme terminée");
            System.out.println("3. Supprimer une tâche");
            System.out.println("4. Display the tasks");
            System.out.println("5. Afficher la liste des tâches");
            System.out.println("Saisissez votre choix: ");

            switch (choice) {
                case 1 -> addTask();
                case 2 -> markATaskAsCompleted();
                case 3 -> removeTask();
                case 4 -> displayTasks();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }catch(Exception e){
            System.out.println("Invalid choice");
        }
        while (TaskManager.choice >0 && TaskManager.choice <= 5) Thread.onSpinWait();
    }
}

