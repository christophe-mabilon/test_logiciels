package fr.esgi.task;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class TaskManagerTest {

    private TaskList taskList = new TaskList ( );
    private Scanner scanner = new Scanner ( System.in );

    /**
     * On initialise les variables avant chaque test
     */
    @BeforeEach
    void setUp () {
        taskList = new TaskList ( );
        scanner = mock ( Scanner.class );
    }

    /**
     * On démarre le menu de l'application
     */
    @Test
    void run () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //on instancie une nouvelle liste de tâche
        TaskList taskList = new TaskList ( );

        //on crée 3 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );
        taskList.addTask ( "Task 3" );

        // on vérifie que la liste n'est pas vide
        assertFalse ( taskList.getAllTasks ( ).isEmpty ( ) , "La liste ne devrait pas être vide" );

        //on vérifie que la methode addTask a été appellé 3 fois ét à créer 3 taches
        assertEquals ( 3 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 3 taches" );

        //On vérifie les donée des taches
        assertEquals ( "Task 1" , taskList.getAllTasks ( ).get ( 0 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 2" , taskList.getAllTasks ( ).get ( 1 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 1 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 3" , taskList.getAllTasks ( ).get ( 2 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 2 ).getDone ( ) , "L'état de la tache devrais être ici a false" );

        //on affiche vérifie l'affichage de la liste
        assertEquals ( "[Task{id=1, description='Task 1', isDone=false}, Task{id=2, description='Task 2', isDone=false}, Task{id=3, description='Task 3', isDone=false}]" , taskList.getAllTasks ( ).toString ( ) , "La liste devrais contenir 3taches" );
    }

    /**
     * On affiche le menu de l'application
     */
    @Test
    void displayMenu () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //on crée 3 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );
        taskList.addTask ( "Task 3" );

        // on vérifie que la liste n'est pas vide
        assertFalse ( taskList.getAllTasks ( ).isEmpty ( ) , "La liste ne devrait pas être vide" );

        //on vérifie que la methode addTask a été appellé 3 fois ét à créer 3 taches
        assertEquals ( 3 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 3 taches" );

        //On vérifie les donée des taches
        assertEquals ( "Task 1" , taskList.getAllTasks ( ).get ( 0 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 2" , taskList.getAllTasks ( ).get ( 1 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 1 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 3" , taskList.getAllTasks ( ).get ( 2 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 2 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        //on vérifie que l'affichage de la liste contient bien 3 taches et que les taches sont bien instanciées
        assertEquals ( "[Task{id=1, description='Task 1', isDone=false}, Task{id=2, description='Task 2', isDone=false}, Task{id=3, description='Task 3', isDone=false}]" , taskList.getAllTasks ( ).toString ( ) , "La liste devrais contenir 3 taches" );
    }

    /**
     * On ajoute une tache à la liste
     */
    @Test
    void addTask () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //on instancie une nouvelle liste de tâche
        TaskList taskList = new TaskList ( );

        //on simule l'entrée utilisateur
        when ( scanner.nextLine ( ) ).thenReturn ( "Task 1" );

        //on appelle la methode addTask
        taskList.addTask ( scanner.nextLine ( ) );

        //on vérifie que la liste n'est pas vide
        assertFalse ( taskList.getAllTasks ( ).isEmpty ( ) , "La liste ne devrait pas être vide" );

        //on vérifie que la methode addTask a été appellé 1 fois et à créer 1 tache
        assertEquals ( 1 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 1 tache" );

        //On vérifie les donée de la tache
        assertEquals ( "Task 1" , taskList.getAllTasks ( ).get ( 0 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "L'état de la tache devrais être ici a false" );

        //on affiche vérifie l'affichage de la liste
        assertEquals ( "[Task{id=1, description='Task 1', isDone=false}]" , taskList.getAllTasks ( ).toString ( ) , "La liste devrais contenir 1 tache" );
    }

    /**
     * On marque une tache comme complétée
     */
    @Test
    void markATaskAsCompleted () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //on crée 3 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );
        taskList.addTask ( "Task 3" );

        // on vérifie que la liste n'est pas vide
        assertFalse ( taskList.getAllTasks ( ).isEmpty ( ) , "La liste ne devrait pas être vide" );

        //on vérifie que la methode addTask a été appellé 3 fois ét à créer 3 taches
        assertEquals ( 3 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 3 taches" );

        //On vérifie les donée des taches
        assertEquals ( "Task 1" , taskList.getAllTasks ( ).get ( 0 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 2" , taskList.getAllTasks ( ).get ( 1 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 1 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 3" , taskList.getAllTasks ( ).get ( 2 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 2 ).getDone ( ) , "L'état de la tache devrais être ici a false" );

        //on affiche vérifie l'affichage de la liste
        assertEquals ( "[Task{id=1, description='Task 1', isDone=false}, Task{id=2, description='Task 2', isDone=false}, Task{id=3, description='Task 3', isDone=false}]" , taskList.getAllTasks ( ).toString ( ) , "La liste devrais contenir 3taches" );

        //on marque la tache 1 comme complétée
        taskList.markTaskAsCompleted ( 1L );

        //on vérifie que la tache 1 est bien complétée
        assertEquals ( true , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "La tache 1 devrait être complétée" );

        //on marque la tache 2 comme complétée
        taskList.markTaskAsCompleted ( 2L );

        //on vérifie que la tache 2 est bien complétée
        assertEquals ( true , taskList.getAllTasks ( ).get ( 1 ).getDone ( ) , "La tache 2 devrait être complétée" );

        //on marque la tache 3 comme complétée
        taskList.markTaskAsCompleted ( 3L );

        //on vérifie que la tache 3 est bien complétée
        assertEquals ( true , taskList.getAllTasks ( ).get ( 2 ).getDone ( ) , "La tache 3 devrait être complétée" );
    }


    /**
     * On supprime une tache de la liste
     */
    @Test
    void removeTask () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //on instancie une nouvelle liste de tâche
        TaskList taskList = new TaskList ( );

        //on crée 3 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );
        taskList.addTask ( "Task 3" );

        // on vérifie que la liste n'est pas vide
        assertFalse ( taskList.getAllTasks ( ).isEmpty ( ) , "La liste ne devrait pas être vide" );

        //on vérifie que la methode addTask a été appellé 3 fois ét à créer 3 taches
        assertEquals ( 3 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 3 taches" );

        //On vérifie les donée des taches
        assertEquals ( "Task 1" , taskList.getAllTasks ( ).get ( 0 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 2" , taskList.getAllTasks ( ).get ( 1 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 1 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 3" , taskList.getAllTasks ( ).get ( 2 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 2 ).getDone ( ) , "L'état de la tache devrais être ici a false" );

        //on affiche vérifie l'affichage de la liste
        assertEquals ( "[Task{id=1, description='Task 1', isDone=false}, Task{id=2, description='Task 2', isDone=false}, Task{id=3, description='Task 3', isDone=false}]" , taskList.getAllTasks ( ).toString ( ) , "La liste devrais contenir 3taches" );

        //on supprime la tache 2
        taskList.removeTask ( 2L );

        //on vérifie que la methode removeTask a été appellé 1 fois ét à supprimer 1 tache
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );

        //On vérifie les donée des taches
        assertEquals ( "Task 1" , taskList.getAllTasks ( ).get ( 0 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 3" , taskList.getAllTasks ( ).get ( 1 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 1 ).getDone ( ) , "L'état de la tache devrais être ici a false" );

        //on affiche vérifie l'affichage de la liste
        assertEquals ( "[Task{id=1, description='Task 1', isDone=false}, Task{id=3, description='Task 3', isDone=false}]" , taskList.getAllTasks ( ).toString ( ) , "La liste devrais contenir 2 taches" );
    }

    /**
     * On affiche la liste avec toutes les taches
     */
    @Test
    void testDisplayTasks () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //on instancie une nouvelle liste de tâche
        TaskList taskList = new TaskList ( );

        //on crée 3 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );
        taskList.addTask ( "Task 3" );

        // on vérifie que la liste n'est pas vide
        assertFalse ( taskList.getAllTasks ( ).isEmpty ( ) , "La liste ne devrait pas être vide" );

        //on vérifie que la methode addTask a été appellé 3 fois ét à créer 3 taches
        assertEquals ( 3 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 3 taches" );

        //On vérifie les donée des taches
        assertEquals ( "Task 1" , taskList.getAllTasks ( ).get ( 0 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 2" , taskList.getAllTasks ( ).get ( 1 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 1 ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 3" , taskList.getAllTasks ( ).get ( 2 ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 2 ).getDone ( ) , "L'état de la tache devrais être ici a false" );

        //on affiche vérifie l'affichage de la liste
        assertEquals ( "[Task{id=1, description='Task 1', isDone=false}, Task{id=2, description='Task 2', isDone=false}, Task{id=3, description='Task 3', isDone=false}]" , taskList.getAllTasks ( ).toString ( ) , "La liste devrais contenir 3taches" );
    }
}