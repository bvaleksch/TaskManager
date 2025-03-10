package ru.valentin3131.taskmanager;

import java.util.Date;
import java.util.UUID;

public class Task {
    private boolean clone;
    private UUID uuid;
    private UUID project_uuid;
    private String name;
    private String status;
    private int priority;
    private Date deadline;
    private User assignedUser;

    public Task(String name, String status, int priority, Date deadline) {
        this.clone = false;
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.deadline = deadline;
        this.uuid = UUID.randomUUID();
        this.project_uuid = null;
        this.assignedUser = null;
    }

    private void setUUID(UUID uuid){this.uuid = uuid;}

    private void setProjectUUID(UUID uuid) {this.project_uuid = uuid;}

    public boolean isClone() {return clone;}

    public Task clone() {
        Task task = new Task(name, status, priority, deadline);
        task.clone = true;
        task.setUUID(this.getUUID());
        task.setProjectUUID(this.getProjectUUID());
        task.setAssignedUser(this.getAssignedUser());
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

    public void setProject(Project project) {
        project_uuid = project.getUUID();
    }

    public UUID getProjectUUID(){return project_uuid;}
}
