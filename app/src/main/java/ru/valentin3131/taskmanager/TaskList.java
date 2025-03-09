package ru.valentin3131.taskmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void updateTask(Task task, String newName, String newStatus, int newPriority, Date newDeadline) {
        task.setName(newName);
        task.setStatus(newStatus);
        task.setPriority(newPriority);
        task.setDeadline(newDeadline);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
