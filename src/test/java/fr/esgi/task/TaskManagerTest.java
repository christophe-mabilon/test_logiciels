package fr.esgi.task;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;


class TaskManagerTest {


    private Scanner scanner;
    ApplicationConsole applicationConsole = new ApplicationConsole ( scanner );
    private TaskManager taskManager;
    private TaskList taskList;



    @BeforeEach
    void setUp () {
        scanner = mock ( Scanner.class );
        taskList = new TaskList();
        ApplicationConsole applicationConsole = new ApplicationConsole(scanner);
        taskManager = new TaskManager ( applicationConsole,taskList );
    }

    @Test
    void run () {
        //on vérifie que la methode run est bien appellé
        taskManager.run ( );
        ApplicationConsole applicationConsole = new ApplicationConsole ( scanner );
        displayMenu ( );
        //on vérifie le message de bienvenue
        assertEquals ( "\"-----------------------------------------------\\n\"+\"Bienvenue dans votre gestionnaire de tâches !\\n\"+\"1. Ajouter une tâche\\n\"+\"2. Marquer une tâche comme terminée\\n\"+\"3. Supprimer une tâche\\n\"+\"4. Afficher la liste des tâches\\n\"+\"5. Quitter\\n\"+\"Saisissez votre choix: \\n\"+\"-----------------------------------------------\\n\"" , displayMenu ( ) , "Le message de bienvenue devrais etre affiché" );
        //on vérifie que le choix 0 n'est pas pris en compte
        assertEquals ( 0 , applicationConsole.showMessage ( "Choix invalide" ) , "Le choix 0 ne devrais pas etre pris en compte" );
        //on vérifie que le choix 1 est bien pris en compte
        assertEquals ( 1 , addTask ( scanner ) , "Le choix 1 devrais etre pris en compte" );
        //on vérifie que le choix 2 est bien pris en compte
        assertEquals ( 2 , markATaskAsCompleted ( ) , "Le choix 2 devrais etre pris en compte" );
        //on vérifie que le choix 3 est bien pris en compte
        assertEquals ( 3 , removeTask ( ) , "Le choix 3 devrais etre pris en compte" );
        //on vérifie que le choix 4 est bien pris en compte
        assertEquals ( 4 , taskManager.displayTasks ( ) , "Le choix 4 devrais etre pris en compte" );
        //on vérifie que le choix 5 est bien pris en compte
        assertEquals ( 5 , applicationConsole.exit ( ) , "Le choix 5 devrais etre pris en compte" );
        //on vérifie que le choix 6 n'est pas pris en compte
        assertEquals ( 6 , applicationConsole.showMessage ( "Choix invalide" ) , "Le choix 6 ne devrais pas etre pris en compte" );
        // on vérifie l'entrée utilisateur
        verify ( scanner ).nextLine ( );
        //on vérifie que la methode addTask a été appellé 3 fois ét à créer 3 taches en simulant l'entrée utilisateur

        when(scanner.nextLine()).thenReturn("1");
        when(scanner.nextLine()).thenReturn("Task 1");

        when(scanner.nextLine()).thenReturn("1");
        when(scanner.nextLine()).thenReturn("Task 2");

        when(scanner.nextLine()).thenReturn("1");
        when(scanner.nextLine()).thenReturn("Task 3");
        assertEquals ( 3 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 3 taches" );
         }


    @Test
    short displayMenu () {
        return 0;
    }

    @Test
    short addTask ( Scanner scanner ) {
        return 0;
    }

    @Test
    short markATaskAsCompleted () {
        return 0;
    }

    @Test
    short removeTask () {
        return 0;
    }

    @Test
    void testDisplayTasks () {
        //on instancie une nouvelle liste de tâche
        TaskList taskList = new TaskList ( );

        //on crée 3 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );
        taskList.addTask ( "Task 3" );

        // on vérifie que la liste n'est pas vide
        assertFalse ( taskList.getAllTasks ( ).isEmpty ( ) , "La liste ne devrait pas etre vide" );

        //on vérifie que la methode addTask a été appellé 3 fois ét à créer 3 taches
        assertEquals ( 3 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 3 taches" );

        //On verifie les donée des taches
        assertEquals ( "Task 1" , taskList.getAllTasks ( ).get ( 0 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "L'etat de la tache devrais etre ici a false" );
        assertEquals ( "Task 2" , taskList.getAllTasks ( ).get ( 1 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 1 ).getDone ( ) , "L'etat de la tache devrais etre ici a false" );
        assertEquals ( "Task 3" , taskList.getAllTasks ( ).get ( 2 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 2 ).getDone ( ) , "L'etat de la tache devrais etre ici a false" );

        //on affiche verifie l'affichege de la liste
        assertEquals ( "[Task1 : { id=1, description='Task 1', isDone=false }, Task2 : { id=2, description='Task 2', isDone=false }, Task3 : { id=3, description='Task 3', isDone=false }]" , taskList.getAllTasks ( ).toString ( ) , "La liste devrais contenir 3taches" );
    }
}