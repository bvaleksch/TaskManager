package ru.valentin3131.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GlobalData {
    private static GlobalData instance;
    private List<Task> tasks = new ArrayList<Task>();
    private List<User> users = new ArrayList<User>();
    private List<Milestone> milestones = new ArrayList<Milestone>();
    private List<Project> projects = new ArrayList<Project>();

    private GlobalData() {
    }

    public Task getTask(UUID uuid) {
        for (Task task : tasks) {
            if (task.getUUID().equals(uuid))
                return task;
        }

        return null;
    }

    public static GlobalData getInstance(){
        if (instance == null)
            instance = new GlobalData();
        return instance;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<User> getUsers() {return users; }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }
}
