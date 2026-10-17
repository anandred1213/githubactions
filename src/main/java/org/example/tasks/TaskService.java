
package org.example.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    public Task addTask(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Task title cannot be empty"
            );
        }

        Task task = new Task(nextId++, title);
        tasks.add(task);

        return task;
    }

    public List<Task> getAllTasks() {
        return List.copyOf(tasks);
    }

    public void completeTask(Long id) {
        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Task not found")
                );

        task.markCompleted();
    }
    public int getTaskCount(){
        return tasks.size();
    }
}
