package ru.valentin3131.taskmanager;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import ru.valentin3131.taskmanager.Task;
import ru.valentin3131.taskmanager.TaskList;

public class Project {
    private String name;
    private UUID uuid;
    private TaskList taskList;

    public Project(String name) {
        this.name = name;
        this.taskList = new TaskList();
        this.uuid = UUID.randomUUID();
    }

    public UUID getUUID() {return uuid;}

    public void addTask(Task task) {
        taskList.addTask(task);
    }

    public void removeTask(Task task) {
        taskList.removeTask(task);
    }

    public void updateTask(Task task, String newName, String newStatus, int newPriority, Date newDeadline) {
        taskList.updateTask(task, newName, newStatus, newPriority, newDeadline);
    }

    public List<Task> getTasks() {
        return taskList.getTasks();
    }

    public void sortTasksByDeadline() {
        taskList.getTasks().sort((t1, t2) -> t1.getDeadline().compareTo(t2.getDeadline()));
    }

    public void sortTasksByPriority() {
        taskList.getTasks().sort((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()));
    }

    public String getName() {
        return name;
    }
}
