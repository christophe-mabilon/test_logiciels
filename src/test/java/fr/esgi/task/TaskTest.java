package fr.esgi.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaskTest {

    @BeforeEach
    void resetCounter () throws NoSuchFieldException, IllegalAccessException {
        Field counterField = Task.class.getDeclaredField ( "counter" );
        counterField.setAccessible ( true );
        counterField.set ( null , 0L );
    }

    @Test
    void getId () {
        //given
        Task task = mock ( Task.class );
        assertNotNull ( task );
        // when
        when ( task.getId ( ) ).thenReturn ( 1L );

        // then
        assertNotNull ( task.getId ( ) );
        Assertions.assertEquals ( 1 , task.getId ( ) );
    }

    @Test
    void setId () {
        //given
        Task task = mock ( Task.class );
        assertNotNull ( task );
        // when
        when ( task.getId ( ) ).thenReturn ( 1L );
        //then
        assertNotNull ( task.getId ( ) );
        Assertions.assertEquals ( 1 , task.getId ( ) );

        //given
        task = mock ( Task.class );

        //when
        when ( task.getId ( ) ).thenReturn ( 2L );
        assertNotNull ( task.getId ( ) );
        //then
        Assertions.assertEquals ( 2 , task.getId ( ) );
    }

    @Test
    void getDescription () {
        //given
        Task task = mock ( Task.class );
        assertNotNull ( task );
        //when
        when ( task.getDescription ( ) ).thenReturn ( "Test Task" );
        assertNotNull ( task.getDescription ( ) );
        //then
        Assertions.assertEquals ( "Test Task" , task.getDescription ( ) );
    }

    @Test
    void setDescription () {
        //given
        Task task = mock ( Task.class );
        assertNotNull ( task );
        //when
        when ( task.getDescription ( ) ).thenReturn ( "Test Task" );
        assertNotNull ( task.getDescription ( ) );
        //then
        Assertions.assertEquals ( "Test Task" , task.getDescription ( ) );
    }

    @Test
    void getDone () {
        //given
        Task task = mock ( Task.class );
        assertNotNull ( task );
        //when
        when ( task.getDone ( ) ).thenReturn ( false );
        //then
        Assertions.assertEquals ( false , task.getDone ( ) );

        //when
        when ( task.getDone ( ) ).thenReturn ( true );
        //then
        Assertions.assertEquals ( true , task.getDone ( ) );
    }

    @Test
    void setDone () {
        //given
        Task task = new Task ("Test Task", false);
        //when
        task.setDone ( true );
        //then
        Assertions.assertEquals ( true , task.getDone ( ) );

    }

    @Test
    void testEquals () {
        //given
        Task task = mock ( Task.class );
        assertNotNull ( task );

        // when
        when ( task.getId ( ) ).thenReturn ( 1L );
        assertNotNull ( task.getId ( ) );
        //then
        Assertions.assertEquals ( 1 , task.getId ( ) );


        //when
        when ( task.getDescription ( ) ).thenReturn ( "Test Task" );
        assertNotNull ( task.getDescription ( ) );
        //then
        Assertions.assertEquals ( "Test Task" , task.getDescription ( ) );

        //when
        when ( task.getDone ( ) ).thenReturn ( false );
        assertNotNull ( task.getDone ( ) );
        //then
        Assertions.assertEquals ( false , task.getDone ( ) );
        //when
        when ( task.getDone ( ) ).thenReturn ( true );
        assertNotNull ( task.getDone ( ) );
        //then
        Assertions.assertEquals ( true , task.getDone ( ) );
    }

    @Test
    void testToString () {
        //given
        Task task = mock ( Task.class );
        assertNotNull ( task );
        //when
        when ( task.getId ( ) ).thenReturn ( 1L );
        assertNotNull ( task.getId ( ) );
        //then
        Assertions.assertEquals ( 1 , task.getId ( ) );

        //when
        when ( task.getDescription ( ) ).thenReturn ( "Test Task" );
        assertNotNull ( task.getDescription ( ) );
        //then
        Assertions.assertEquals ( "Test Task" , task.getDescription ( ) );

        //when
        when ( task.getDone ( ) ).thenReturn ( false );
        assertNotNull ( task.getDone ( ) );
        //then
        Assertions.assertEquals ( false , task.getDone ( ) );
        //when
        when ( task.getDone ( ) ).thenReturn ( true );
        assertNotNull ( task.getDone ( ) );
        //then
        Assertions.assertEquals ( true , task.getDone ( ) );

    }

    @Test
    void testConstructor () {
        //given
        Task task = mock ( Task.class );
        assertNotNull ( task );
        //when
        when ( task.getId ( ) ).thenReturn ( 1L );
        when ( task.getDescription ( ) ).thenReturn ( "Test Task" );
        when ( task.getDone ( ) ).thenReturn ( false );

        Task createdTask = new Task ( "Test Task" , false );
        assertNotNull ( createdTask );
        assertNotNull ( createdTask.getId ( ) );
        assertNotNull ( createdTask.getDescription ( ) );
        assertNotNull ( createdTask.getDone ( ) );
        //then
        Assertions.assertEquals ( task.getId ( ) , createdTask.getId ( ) );
        Assertions.assertEquals ( task.getDescription ( ) , createdTask.getDescription ( ) );
        Assertions.assertEquals ( task.getDone ( ) , createdTask.getDone ( ) );
    }
}
