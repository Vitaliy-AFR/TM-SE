package org.example.commands;

import org.example.Project;
import org.example.Task;
import org.example.TerminalLogic;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GetTaskCommand implements Commands {
    @Override
    public String nameOfCommand() {
        return "get task";
    }

    @Override
    public String description() {
        return "Показать задачу";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {
        Scanner scanner = terminalLogic.getScanner();
        System.out.println("Введите номер проекта:");
        int numberOfProject = getNumber(terminalLogic);
        if (!correctProjectNumber(terminalLogic, numberOfProject)) {
            return;
        }
        System.out.println("Введите название задачи:");
        String nameOfTask = scanner.nextLine();
        if (!correctTaskName(terminalLogic, nameOfTask)) {
            return;
        }
        printTask(terminalLogic, nameOfTask);
    }

    private int getNumber (TerminalLogic terminalLogic){
        Scanner scanner = terminalLogic.getScanner();
        int number = 0;
        try {
            number = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }
        return number;
    }

    private boolean correctProjectNumber(TerminalLogic terminalLogic, int number) {
        Map<Integer, Project> projects = terminalLogic.getProjectRepository().getProjects();
        if (number > projects.size()) {
            System.out.println(terminalLogic.getPROJECT_WITH_SUCH_NUMBER_NOT_YET_CREATED());
            return false;
        } else if (number <= 0) {
            System.out.println(terminalLogic.getINCORRECT_NUMBER_ENTERED());
            return false;
        } else {
            return true;
        }
    }

    private boolean correctTaskName(TerminalLogic terminalLogic, String name) {
        Map<String, Task> tasks = terminalLogic.getTaskRepository().getTasks();

        if (!tasks.containsKey(name)) {
            System.out.println(terminalLogic.getTASK_WITH_SUCH_NAME_NOT_YET_CREATED());
            return false;
        } else {
            return true;
        }
    }

    private void printTask(TerminalLogic terminalLogic, String nameOfTask){
        Task task = terminalLogic.getTaskRepository().getTasks().get(nameOfTask);
        System.out.println(String.format("Проект №%d\nЗадача №%d: %s", task.getNumberOfProject(), task.getNumber(), task.getName()));
        if (task.getDescription() != null) System.out.println("description: " + task.getDescription());
    }

}
