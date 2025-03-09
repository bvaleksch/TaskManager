package ru.valentin3131.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    private static GlobalData instance;
    private List<Task> tasks = new ArrayList<Task>();
    private List<User> users = new ArrayList<User>();
    private List<Milestone> milestones = new ArrayList<Milestone>();
    private List<Project> projects = new ArrayList<Project>();

    private GlobalData() {
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
}
