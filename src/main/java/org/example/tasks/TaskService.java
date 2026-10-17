
package org.example.tasks;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

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

    public void deleteTask(Long id) {
        boolean removed = tasks.removeIf(task -> task.getId().equals(id));

        if (!removed) {
            throw new IllegalArgumentException("task not found");
        }
    }

    public Task updateTask(Long id, String newTitle) {
        if (newTitle == null || newTitle.isBlank()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }

        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        // Create an updated task with the same ID
        Task updatedTask = new Task(id, newTitle);

        if (task.isCompleted()) {
            updatedTask.markCompleted();
        }

        tasks.set(tasks.indexOf(task), updatedTask);

        return updatedTask;
    }


    public long getCompletedTaskCount() {
        return tasks.stream()
                .filter(Task::isCompleted)
                .count();
    }


}
