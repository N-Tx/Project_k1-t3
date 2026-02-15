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
            System.out.println("2. Listar por Prioridade");
            System.out.println("3. Listar por Categoria");
            System.out.println("4. Listar por Status");
            System.out.println("5. Listagem geral");
            System.out.println("6. Remover Tarefa");
            System.out.println("7. Atualizar Status");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("--- Adicionando Nova Tarefa ---");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String description = scanner.nextLine();

                    System.out.print("Data (ddmmaa): ");
                    String date = scanner.nextLine();

                    int pri = 0;
                    while (true) {
                        System.out.print("Prioridade (1 a 5): ");
                        if (scanner.hasNextInt()) {
                            pri = scanner.nextInt();
                            scanner.nextLine(); // Consumir enter
                            if (pri >= 1 && pri <= 5) {
                                break;
                            } else {
                                System.out.println("Erro: A prioridade deve ser entre 1 e 5.");
                            }
                        } else {
                            System.out.println("Erro: Digite apenas números.");
                            scanner.next();
                        }
                    }

                    System.out.print("Categoria: ");
                    String category = scanner.nextLine();


                    String status = "";
                    while (true) {
                        System.out.print("Status (TODO, DOING, DONE): ");
                        status = scanner.nextLine();

                        if (status.equalsIgnoreCase("TODO") ||
                                status.equalsIgnoreCase("DOING") ||
                                status.equalsIgnoreCase("DONE")) {
                            break;
                        } else {
                            System.out.println("Erro: Status inválido! Use apenas TODO, DOING ou DONE.");
                        }
                    }

                    Task novaTask = new Task(nome, description, date, pri, category, status);
                    service.addTask(novaTask);
                    System.out.println("Tarefa adicionada e rebalanceada com sucesso!");
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
                case 5:
                    service.listAll();
                    break;
                case 6:
                    service.listAll();
                    System.out.print("Digite o índice [número] para remover: ");
                    int idRemove = scanner.nextInt();
                    scanner.nextLine();
                    service.removeTask(idRemove);
                    break;
                case 7:
                    service.listAll();

                    System.out.print("Digite o nome da tarefa: ");
                    String index = scanner.next();
                    scanner.nextLine();

                    System.out.print("Qual o novo status? (TODO, DOING, DONE): ");
                    String novoStatus = scanner.nextLine();

                    service.updateStatus(index, novoStatus);
                    service.listAll();
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