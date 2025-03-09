package ru.valentin3131.taskmanager;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID uuid;
    private String name;
    private String status;
    private int priority;
    private Date deadline;
    private User assignedUser;

    public Task(String name, String status, int priority, Date deadline) {
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.deadline = deadline;
        this.uuid = UUID.randomUUID();
    }

    private void setUUID(UUID uuid){this.uuid = uuid;}

    public Task clone() {
        Task task = new Task(name, status, priority, deadline);
        task.setUUID(this.getUUID());
        return task;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setAssignedUser(User user) {
        this.assignedUser = user;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public UUID getUUID() {
        return uuid;
    }
}
