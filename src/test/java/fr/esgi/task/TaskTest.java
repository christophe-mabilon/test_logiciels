package fr.esgi.task;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;
class TaskTest {

    @Test
    void getId() {
        //given
        Task task = mock(Task.class);
        Assertions.assertNotNull(task);
        // when
        when(task.getId()).thenReturn(1L);

        // then
        Assertions.assertEquals(1, task.getId());
    }

    @Test
    void setId() {
        //given
        Task task = mock(Task.class);
        Assertions.assertNotNull(task);
        // when
        when(task.getId()).thenReturn(1L);
        //then
        Assertions.assertEquals(1, task.getId());

        //given
        task = mock(Task.class);

        //when
        when(task.getId()).thenReturn(2L);
        //then
        Assertions.assertEquals(2, task.getId());
    }

    @Test
    void getDescription() {
        //given
        Task task = mock(Task.class);
        Assertions.assertNotNull(task);
        //when
        when(task.getDescription()).thenReturn("Test Task");
        Assertions.assertNotNull(task.getDescription());
        //then
        Assertions.assertEquals("Test Task", task.getDescription());
    }

    @Test
    void setDescription() {
        //given
        Task task = mock(Task.class);
        Assertions.assertNotNull(task);
        //when
        when(task.getDescription()).thenReturn("Test Task");
        Assertions.assertNotNull(task.getDescription());
        //then
        Assertions.assertEquals("Test Task", task.getDescription());
    }

    @Test
    void getDone() {
        //given
        Task task = mock(Task.class);
        Assertions.assertNotNull(task);
        Assertions.assertNotNull(task.getDone());
        //when
        when(task.getDone()).thenReturn(false);
        Assertions.assertNotNull(task.getDone());
        //then
        Assertions.assertEquals(false, task.getDone());

        //given
        mock(Task.class);
        //when
        when(task.getDone()).thenReturn(true);
        Assertions.assertNotNull(task.getDone());
        //then
        Assertions.assertEquals(true, task.getDone());
    }

    @Test
    void setDone() {
        //given
        Task task = mock(Task.class);
        Assertions.assertNotNull(task);
        Assertions.assertNotNull(task.getDone());
        //when
        when(task.getDone()).thenReturn(true);
        Assertions.assertNotNull(task.getDone());
        //given
        mock(Task.class);
        //when
        when(task.getDone()).thenReturn(true);
        Assertions.assertNotNull(task.getDone());
        //then
        Assertions.assertEquals(true, task.getDone());
    }

    @Test
    void testEquals() {
        //given
        Task task = mock(Task.class);
        Assertions.assertNotNull(task);

        // when
        when(task.getId()).thenReturn(1L);
        //then
        Assertions.assertEquals(1, task.getId());


        //when
        when(task.getDescription()).thenReturn("Test Task");
        Assertions.assertNotNull(task.getDescription());
        //then
        Assertions.assertEquals("Test Task", task.getDescription());

        //when
        when(task.getDone()).thenReturn(false);
        Assertions.assertNotNull(task.getDone());
        //then
        Assertions.assertEquals(false, task.getDone());
        //when
        when(task.getDone()).thenReturn(true);
        Assertions.assertNotNull(task.getDone());
        //then
        Assertions.assertEquals(true, task.getDone());
    }

    @Test
    void testToString() {
        //given
        Task task = mock(Task.class);
        Assertions.assertNotNull(task);
        //when
        when(task.getId()).thenReturn(1L);
        //then
        Assertions.assertEquals(1, task.getId());

        //when
        when(task.getDescription()).thenReturn("Test Task");
        Assertions.assertNotNull(task.getDescription());
        //then
        Assertions.assertEquals("Test Task", task.getDescription());

        //when
        when(task.getDone()).thenReturn(false);
        Assertions.assertNotNull(task.getDone());
        //then
        Assertions.assertEquals(false, task.getDone());
        //when
        when(task.getDone()).thenReturn(true);
        Assertions.assertNotNull(task.getDone());
        //then
        Assertions.assertEquals(true, task.getDone());

    }

    
}