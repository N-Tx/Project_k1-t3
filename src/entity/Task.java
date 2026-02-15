package entity;


import java.time.LocalDate;

public class Task {

    private String name;
    private String description;
    private LocalDate deadline;
    private int level_priority;
    private String category;
    private String status;


    public Task(String name, String description, LocalDate deadline, int priority, String category, String status) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.level_priority = priority;
        this.category = category;
        this.status = status;

    }
    @Override
    public String toString() {
        return "Nome: " + name +
                " | Descrição: " + description +
                " | Data: " + deadline +
                " | Prioridade: " + level_priority +
                " | Categoria: " + category +
                " | Status: " + status;
    }



    // geters e seters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public int getLevel_priority() {
        return level_priority;
    }

    public void setLevel_priority(int level_priority) {
        this.level_priority = level_priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}