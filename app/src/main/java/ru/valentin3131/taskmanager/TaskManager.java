package ru.valentin3131.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<User> users;
    private List<Project> projects;

    public TaskManager() {
        this.users = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public List<Task> searchTasksByKeyword(String keyword) {
        List<Task> result = new ArrayList<>();
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getName().contains(keyword)) {
                    result.add(task);
                }
            }
        }
        return result;
    }

    public List<Task> searchTasksByProject(Project project) {
        return project.getTasks();
    }
}
