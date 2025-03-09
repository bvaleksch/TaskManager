package ru.valentin3131.taskmanager;

import java.util.Date;

public class Task {
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
    }

    public Task clone() {
        return new Task(name, status, priority, deadline);
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
}
