package fr.esgi.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    private final TaskList taskList = new TaskList ( );

    @Test
    void addTask () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //On déclare les attributs d'une tache par default l'isDone est à false
        String description = "Task 1";
        //On crée une 2ᵉ tache
        String description2 = "Task 2";

        //On ajoute les taches à la liste
        taskList.addTask ( description );
        taskList.addTask ( description2 );

        //on vérifie que la methode addTask a été appelée 2 fois ét à créer 2 taches
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );

        //On vérifie les donée des taches
        assertEquals ( "Task 1" , taskList.findById ( 1L ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.findById ( 1L ).getDone ( ) , "L'état de la tache devrais être ici a false" );

        assertEquals ( "Task 2" , taskList.findById ( 2L ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.findById ( 2L ).getDone ( ) , "L'état de la tache devrais être ici a false" );

        // on vérifie que la liste contient bien 2 taches
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );


    }

    @Test
    void removeTask () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //on crée 2 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );

        //on vérifie que la methode addTask a été appelé 2 fois ét à créer 2 taches
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );

        //On vérifie les donée des taches
        assertEquals ( "Task 1" , taskList.findById ( 1L ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.findById ( 1L ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 2" , taskList.findById ( 2L ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.findById ( 2L ).getDone ( ) , "L'état de la tache devrais être ici a false" );


        //on supprime la tache 1
        boolean taskRemoved1 = taskList.removeTask ( 1L );

        //on vérifie que la methode removeTask a été appelé 1 fois ét a supprimé 1 tache
        assertTrue ( taskRemoved1 , "La tâche devrait être supprimée et ne plus être dans la liste" );
        assertEquals ( 1 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 1 tache" );

        //on supprime la tache 2
        boolean taskRemoved2 = taskList.removeTask ( 2L );

        //on vérifie que la methode removeTask a été appelé 1 fois ét a supprimé 1 tache
        assertTrue ( taskRemoved2 , "La tâche devrait être supprimée et ne plus être dans la liste" );
        assertEquals ( 0 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 0 tache" );
    }

    @Test
    void markTaskAsCompleted () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //on crée 2 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );

        //on vérifie que la methode addTask a été appelée 2 fois ét à créer 2 taches
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );

        //On vérifie les donée des taches
        assertEquals ( "Task 1" , taskList.findById ( 1L ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.findById ( 1L ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 2" , taskList.findById ( 2L ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.findById ( 2L ).getDone ( ) , "L'état de la tache devrais être ici a false" );

        //on marque la tache 1 comme complétée
        taskList.markTaskAsCompleted ( 1L );
        //On vérifie les donée des taches
        assertEquals ( "Task 1" , taskList.findById ( 1L ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1" );
        assertEquals ( true , taskList.findById ( 1L ).getDone ( ) , "L'état de la tache devrais être ici a true" );

        // on marque la tache 2 comme complétée
        taskList.markTaskAsCompleted ( 2L );
        //On vérifie les données des taches
        assertEquals ( "Task 2" , taskList.findById ( 2L ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1" );
        assertEquals ( true , taskList.findById ( 2L ).getDone ( ) , "L'état de la tache devrais être ici a true" );

    }

    @Test
    void getAllTasks () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //on crée 2 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );

        //on vérifie que la methode addTask a été appellée 2 fois ét à créer 2 taches et on vérifie que la liste contient bien 2 taches
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );


        //On vérifie les donées des taches
        assertEquals ( "Task 1" , taskList.findById ( 1L ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.findById ( 1L ).getDone ( ) , "L'état de la tache devrais être ici a false" );
        assertEquals ( "Task 2" , taskList.findById ( 2L ).getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.findById ( 2L ).getDone ( ) , "L'état de la tache devrais être ici a false" );


    }

    @Test
    void findById () {
        // on initialise le compteur d'id
        Task.setCounter ( 0L );

        //on crée 2 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );

        //on vérifie que la methode addTask a été appellé 2 fois ét à créer 2 taches
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );

        //On vérifie qu'on a bien retrouvé les taches et leurs donées des taches

        // verification de la task 1
        Task task1 = taskList.findById ( 1L );
        //on vérifie que la tache 1 existe
        assertEquals ( 1L , task1.getId ( ) , "La tache devrais être ici: id:1,description:Task1,isDone:false" );

        //On vérifie les donées de la description de la tache 1
        String task1Description = task1.getDescription ( );
        assertEquals ( "Task 1" , task1.getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        // on vérifie l'état de la tache 1
        boolean task1Done = task1.getDone ( );
        assertEquals ( false , task1.getDone ( ) , "L'état de la tache devrais être ici a false" );

        // verification de la task 2
        Task task2 = taskList.findById ( 2L );
        //on vérifie que la tache 2 existe
        assertEquals ( 2L , task2.getId ( ) , "La tache devrais être ici: id:1,description:Task1,isDone:false" );

        //On vérifie les donées de la description de la tache 2
        String task2Description = task2.getDescription ( );
        assertEquals ( "Task 2" , task2.getDescription ( ) , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        // on vérifie l'état de la tache 2
        boolean task2Done = task2.getDone ( );
        assertEquals ( false , task2.getDone ( ) , "L'état de la tache devrais être ici a false" );


        //On vérifie qu'on a bien retrouvé les taches et leurs donées des taches avec la methode findById
        // verification de la task 1
        assertEquals ( "Task 1" , task1Description , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertFalse ( task1Done , "L'état de la tache devrais être ici a false" );

        // verification de la task 2
        assertEquals ( "Task 2" , task2Description , "La description devrais être ici: id:1,description:Task1,isDone:false" );
        assertFalse ( task2Done , "L'état de la tache devrais être ici a false" );


    }
}