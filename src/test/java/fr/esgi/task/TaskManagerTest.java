package fr.esgi.task;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TaskManagerTest {

    @Test
    void testAddTask () {
        //on instancie une nouvelle liste de tâche
        TaskList taskList = new TaskList ( );

        //On déclare les attributs d'une tache
        String description = "Task 1";
        Boolean isDone = false;
        //On crée une 2eme tache
        String description2 = "Task 2";
        Boolean isDone2 = false;

        //On ajoute les taches a la liste
        taskList.addTask ( description );
        taskList.addTask ( description2 );

        //on vérifie que la methode addTask a été appellé 2 fois ét a créer 2 taches
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );

        //On verifie les donée des taches
        assertEquals ( "Task 1" , taskList.findById ( 1 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.findById ( 1 ).getDone ( ) , "L'etat de la tache devrais etre ici a false" );

        assertEquals ( "Task 2" , taskList.findById ( 2 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.findById ( 2 ).getDone ( ) , "L'etat de la tache devrais etre ici a false" );

        // on verifie que la liste contient bien 2 taches
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );

        //

    }

    @Test
    void testMarkATaskAsCompleted () {
        //on instancie une nouvelle liste de tâche
        TaskList taskList = new TaskList ( );

        //on crée 2 taches instancié par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );

        //on verifie que la methode addTask a été appellé 2 fois ét a créer 2 taches
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );


        //On verifie les donée des taches
        assertEquals ( "Task 1" , taskList.getAllTasks ( ).get ( 0 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "L'etat de la tache devrais etre ici a false" );
        assertEquals ( "Task 2" , taskList.getAllTasks ( ).get ( 1 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 1 ).getDone ( ) , "L'etat de la tache devrais etre ici a false" );

        //on marque la tache 1 comme complétée
        taskList.markTaskAsCompleted ( "1" );
        //On verifie les donée des taches
        assertEquals ( "Task 1" , taskList.findById ( 1 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1" );
        assertEquals ( true , taskList.findById ( 1 ).getDone ( ) , "L'état de la tache devrais etre ici a true" );

        // on marque la tache 2 comme complétée
        taskList.markTaskAsCompleted ( "2" );
        //On verifie les donée des taches
        assertEquals ( "Task 2" , taskList.findById ( 2 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1" );
        assertEquals ( true , taskList.findById ( 2 ).getDone ( ) , "L'état de la tache devrais etre ici a true" );

    }


    @Test
    void testRemoveTask () {
        //on instancie une nouvelle liste de tâche
        TaskList taskList = new TaskList ( );
        //on crée 2 taches instanciées par default comme non complétée
        taskList.addTask ( "Task 1" );
        taskList.addTask ( "Task 2" );

        //on vérifie que la methode addTask a été appellé 2 fois ét à créer 2 taches
        assertEquals ( 2 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 2 taches" );

        //On verifie les donée des taches
        assertEquals ( "Task 1" , taskList.getAllTasks ( ).get ( 0 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 0 ).getDone ( ) , "L'etat de la tache devrais etre ici a false" );
        assertEquals ( "Task 2" , taskList.getAllTasks ( ).get ( 1 ).getDescription ( ) , "La description devrais etre ici: id:1,description:Task1,isDone:false" );
        assertEquals ( false , taskList.getAllTasks ( ).get ( 1 ).getDone ( ) , "L'etat de la tache devrais etre ici a false" );


        //on supprime la tache 1
        boolean taskRemoved1 = taskList.removeTask ( 1L );

        //on vérifie que la methode removeTask a été appellé 1 fois ét a supprimé 1 tache
        assertTrue ( taskRemoved1 , "La tâche devrait être supprimée et ne plus etre dans la liste" );
        assertEquals ( 1 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 1 tache" );

        //on supprime la tache 2
        boolean taskRemoved2 = taskList.removeTask ( 2L );

        //on vérifie que la methode removeTask a été appellé 1 fois ét a supprimé 1 tache
        assertTrue ( taskRemoved2 , "La tâche devrait être supprimée et ne plus etre dans la liste" );
        assertEquals ( 0 , taskList.getAllTasks ( ).size ( ) , "La liste devrais contenir 0 tache" );
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
        assertEquals ( "[Task1 : { id=1, description='Task 1', isDone=false }, Task2 : { id=2, description='Task 2', isDone=false }, Task3 : { id=3, description='Task 3', isDone=false }]", taskList.getAllTasks ( ).toString ( ) , "La liste devrais contenir 3taches" );
    }
}