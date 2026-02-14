package service;

import entity.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceTasks {

    private List<Task> tasks = new ArrayList<>();



    public void addTask(Task task){
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getLevel_priority).reversed());
    }

    public List<Task> getAllTasks(Task task) {
        return tasks;
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void listStatus(String status){
        for (Task t : tasks){
            if (t.getStatus().equalsIgnoreCase(status)) {
                System.out.println(t);
            }
        }


    }

    public void listCategory(String cat) {
        for (Task t : tasks) {
            System.out.println(t.getCategory() + " -> " + t);

        }
    }
    public void listPriority(int priority) {
        for (Task t : tasks) {
            if (t.getLevel_priority() == priority) {
                System.out.println(t);
            }
        }
    }

    public void listAll() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s%n", i, tasks.get(i));
        }
    }




}
