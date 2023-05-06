package fr.esgi.task;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskTest {

    @Test
    void getId() {
        Task task = mock(Task.class);
        assertNotNull(task);
        when(task.getId()).thenReturn(1);
        assertNotNull(task.getId());
        Assertions.assertEquals(1, task.getId());
    }

    @Test
    void setId() {
        Task task = mock(Task.class);
        assertNotNull(task);
        when(task.getId()).thenReturn(1);
        assertNotNull(task.getId());
        Assertions.assertEquals(1, task.getId());

        when(task.getId()).thenReturn(2);
        assertNotNull(task.getId());
        Assertions.assertEquals(2, task.getId());
    }

    @Test
    void getDescription() {
        Task task = mock(Task.class);
        assertNotNull(task);
        assertNotNull(task.getDescription());
        when(task.getDescription()).thenReturn("Test Task");
        assertNotNull(task.getDescription());
        Assertions.assertEquals("Test Task", task.getDescription());
    }

    @Test
    void setDescription() {
        Task task = mock(Task.class);
        assertNotNull(task);
        assertNotNull(task.getDescription());
        when(task.getDescription()).thenReturn("Test Task");
        assertNotNull(task.getDescription());
        Assertions.assertEquals("Test Task", task.getDescription());
        task.setDescription("Test Task 2");
        assertNotNull(task.getDescription());
        Assertions.assertEquals("Test Task 2", task.getDescription());

    }

    @Test
    void getDone() {
        Task task = mock(Task.class);
        assertNotNull(task);
        assertNotNull(task.getDone());

        when(task.getDone()).thenReturn(false);
        assertNotNull(task.getDone());
        Assertions.assertEquals(false, task.getDone());

        when(task.getDone()).thenReturn(true);
        assertNotNull(task.getDone());
        Assertions.assertEquals(true, task.getDone());
    }

    @Test
    void setDone() {
        Task task = mock(Task.class);
        assertNotNull(task);
        assertNotNull(task.getDone());

        when(task.getDone()).thenReturn(true);
        Assertions.assertEquals(false, task.getDone());

        when(task.getDone()).thenReturn(true);
        assertNotNull(task.getDone());
        Assertions.assertEquals(true, task.getDone());
    }

    @Test
    void testEquals() {
        Task task = mock(Task.class);
        assertNotNull(task);

        when(task.getId()).thenReturn(1);
        assertNotNull(task.getId());
        Assertions.assertEquals(1, task.getId());

        when(task.getDescription()).thenReturn("Test Task");
        Assertions.assertEquals("Test Task", task.getDescription());
        assertNotNull(task.getDescription());

        when(task.getDone()).thenReturn(false);
        assertNotNull(task.getDone());
        Assertions.assertEquals(false, task.getDone());

        when(task.getDone()).thenReturn(true);
        assertNotNull(task.getDone());
        Assertions.assertEquals(true, task.getDone());
    }

    @Test
    void testToString() {
        Task task = mock(Task.class);
        assertNotNull(task);
        when(task.getId()).thenReturn(1);
        assertNotNull(task.getId());
        Assertions.assertEquals(1, task.getId());

        when(task.getDescription()).thenReturn("Test Task");
        assertNotNull(task.getDescription());
        Assertions.assertEquals("Test Task", task.getDescription());

        when(task.getDone()).thenReturn(false);
        assertNotNull(task.getDone());
        Assertions.assertEquals(false, task.getDone());

        when(task.getDone()).thenReturn(true);
        assertNotNull(task.getDone());
        Assertions.assertEquals(true, task.getDone());

    }

    @Test
    void testConstructor() {
        Task task = mock(Task.class);
        assertNotNull(task);
        when(task.getId()).thenReturn(1);
        when(task.getDescription()).thenReturn("Test Task");
        when(task.getDone()).thenReturn(false);

        try (MockedStatic<Task> mockedStatic = mockStatic(Task.class)) {
            mockedStatic.when(() -> new Task(1, "Test Task", false)).thenReturn(task);

            Task createdTask = new Task(1, "Test Task", false);
            assertNotNull(createdTask);
            assertNotNull(createdTask.getId());
            assertNotNull(createdTask.getDescription());
            assertNotNull(createdTask.getDone());
            Assertions.assertEquals(task.getId(), createdTask.getId());
            Assertions.assertEquals(task.getDescription(), createdTask.getDescription());
            Assertions.assertEquals(task.getDone(), createdTask.getDone());
        }
    }
}