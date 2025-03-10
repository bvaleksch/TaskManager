package ru.valentin3131.taskmanager;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private boolean original;
    private String name;
    private UUID uuid;
    private List<Task> assignedTasks;
    private List<Project> projects;

    public User(String name) {
        this.name = name;
        this.original = true;
        this.assignedTasks = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.uuid = UUID.randomUUID();
    }

    public User clone(){
        User usr = new User(this.name);
        usr.original = false;
        usr.assignedTasks = this.getAssignedTasks();
        usr.projects = this.getProjects();
        usr.uuid = this.getUUID();

        return usr;
    }

    public boolean isClone() {
        return !original;
    }

    public UUID getUUID() {return uuid;}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void assignTask(Task task) {
        assignedTasks.add(task);
    }

    public void unassignTask(Task task) {
        assignedTasks.remove(task);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public List<Project> getProjects() {
        return projects;
    }

    @NonNull
    public String toString(){
        if (name == null)
            return "Not user";
        else
            return name;
    }
}
