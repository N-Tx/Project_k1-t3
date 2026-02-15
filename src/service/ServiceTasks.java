package service;

import entity.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceTasks {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);

        tasks.sort(Comparator.comparingInt(Task::getLevel_priority).reversed());
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("Erro: Índice inválido!");
        }
    }

    public void listAll() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("--- LISTA DE TAREFAS (Ordenada por Prioridade) ---");
        for (int i = 0; i < tasks.size(); i++) {

            System.out.println("[" + i + "] " + tasks.get(i));
        }
    }


    public void listStatus(String status) {
        System.out.println("--- Filtrando por Status: " + status.toUpperCase() + " ---");
        boolean encontrou = false; // assumindo que comecei nao achando o filtro
        for (Task t : tasks) {
            if (t.getStatus().equalsIgnoreCase(status)) {
                System.out.println(t);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhuma tarefa com esse status.");
    }


    public void listCategory(String cat) {
        System.out.println("--- Filtrando por Categoria: " + cat + " ---");
        boolean encontrou = false;
        for (Task t : tasks) {

            if (t.getCategory().equalsIgnoreCase(cat)) {
                System.out.println(t);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhuma tarefa nessa categoria.");
    }


    public void listPriority(int priority) {
        System.out.println("--- Filtrando por Prioridade: " + priority + " ---");
        boolean encontrou = false;
        for (Task t : tasks) {
            if (t.getLevel_priority() == priority) {
                System.out.println(t);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhuma tarefa com essa prioridade.");
    }

    public void updateStatus(String id, String newStatus){
        for (Task t : tasks){
            if (t.getName().equalsIgnoreCase(id)){
                t.setStatus(newStatus);
                System.out.println("Status atualizado com sucesso!");
                return;
            }
        }
    }
}