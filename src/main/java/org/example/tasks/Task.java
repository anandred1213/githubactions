
package org.example.tasks;

public class Task {

    private final Long id;
    private final String title;
    private boolean completed;

    public Task(Long id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}
