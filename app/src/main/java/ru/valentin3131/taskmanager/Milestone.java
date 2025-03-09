package ru.valentin3131.taskmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Milestone extends Task {
    private String description;
    private List<Task> dependentTasks;

    public Milestone(String name, String status, int priority, Date deadline, String description) {
        super(name, status, priority, deadline);
        this.description = description;
        this.dependentTasks = new ArrayList<>();
    }

    public Milestone(String name, String description) {
        super(name, "Новая", 1, new Date());
        this.description = description;
        this.dependentTasks = new ArrayList<>();
    }


    public void addDependentTask(Task task) {
        dependentTasks.add(task);
    }

    public void removeDependentTask(Task task) {
        dependentTasks.remove(task);
    }

    public List<Task> getDependentTasks() {
        return dependentTasks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
