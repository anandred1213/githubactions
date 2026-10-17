package com.example.tasks;

import org.example.tasks.Task;
import org.example.tasks.TaskService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    @Test
    void shouldAddTaskSuccessfully(){
        TaskService service = new TaskService();

        Task task  = service.addTask("learn github actions");

        assertEquals(1L, task.getId());
        assertEquals("learn github actions", task.getTitle());
        assertFalse(task.isCompleted());
    }


    @Test
    void shouldRejectEmptyTask(){
        TaskService service = new TaskService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.addTask(" ")
        );
    }

    @Test
    void shouldReturnTaskCount(){
        TaskService service = new TaskService();
        service.addTask("service task 1");
        service.addTask("service task2");
        assertEquals(2, service.getTaskCount());

    }
}
