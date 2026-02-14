package aplication;

import service.ServiceTasks;
import entity.Task;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceTasks service = new ServiceTasks();
        boolean running = true;

        while (running) {
            System.out.println("\n--- ZG HERO TODO LIST ---");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar por Prioridade)");
            System.out.println("3. Listar por Categoria");
            System.out.println("4. Listar por Status");
            System.out.println("4. Remover Tarefa");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (option) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String description = scanner.nextLine();

                    System.out.print("Data: (ddmmaa) ");
                    String date = scanner.nextLine();

                    System.out.print("Prioridade (1-5): ");
                    int pri = scanner.nextInt();
                    scanner.nextLine();


                    System.out.print("Categoria ");
                    String category = scanner.nextLine();

                    System.out.print("Status: TO DO/DOING/DONE ");
                    String status = scanner.nextLine();
                    scanner.nextLine();

                    Task novaTask = new Task(nome, description, date, pri, category, status);
                    service.addTask(novaTask);
                    break;
                case 2:
                    System.out.print("Qual prioridade (1-5)? ");
                    int p = scanner.nextInt();
                    scanner.nextLine();
                    service.listPriority(p);
                    break;
                case 3:
                    System.out.print("Qual categoria? ");
                    String cat = scanner.nextLine();
                    service.listCategory(cat);
                    break;
                case 4:
                    System.out.print("Qual status? (TODO/DOING/DONE) ");
                    String st = scanner.nextLine();
                    service.listStatus(st);
                    break;

                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}