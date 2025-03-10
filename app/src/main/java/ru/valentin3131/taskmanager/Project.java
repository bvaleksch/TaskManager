package ru.valentin3131.taskmanager;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import ru.valentin3131.taskmanager.Task;
import ru.valentin3131.taskmanager.TaskList;

public class Project {
    private boolean original;
    private String name;
    private UUID uuid;
    private TaskList taskList;

    public Project(String name) {
        this.name = name;
        original = true;
        this.taskList = new TaskList();
        this.uuid = UUID.randomUUID();
    }

    public Project clone(){
        Project prj = new Project(this.name);
        prj.original = false;
        prj.taskList = this.taskList;
        prj.uuid = this.getUUID();
        return prj;
    }

    public boolean isClone() {return !original;};

    public String toString(){return name;}

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
