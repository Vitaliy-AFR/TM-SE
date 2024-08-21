package org.example.commands;

import org.example.Project;
import org.example.Task;
import org.example.TerminalLogic;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CreateTaskCommand implements Commands{
    @Override
    public String nameOfCommand() {
        return "create task";
    }

    @Override
    public String description() {
        return "Создать задачу";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {
        Scanner scanner = terminalLogic.getScanner();
        Map<Integer, Project> projects = terminalLogic.getProjectRepository().getProjects();
        if (projects.size() == 0) {
            System.out.println(terminalLogic.getNONE_PROJECT());
            return;
        }
        int numberOfProject = getProjectNumber(terminalLogic);
        if (!correctProjectNumber(terminalLogic, numberOfProject)) {
            return;
        }
        System.out.println("Введите название задачи:");
        String nameOfTask;
        while (true) {
            nameOfTask = scanner.nextLine();
            if (terminalLogic.getTaskRepository().getTasks().containsKey(nameOfTask)) {
                System.out.println("Задача с таким именем уже существует в системе. Введите другое имя или cancel для отмены");
            } else if (nameOfTask.equalsIgnoreCase("cancel")) {
                return;
            } else {
                break;
            }
        }
        Project project = projects.get(numberOfProject);
        int numberOfTask = project.getTasks().size() + 1;
        Task task = Task.builder().name(nameOfTask).number(numberOfTask).numberOfProject(numberOfProject).build();
        project.getTasks().add(task);
        terminalLogic.getTaskRepository().getTasks().put(nameOfTask, task);
        System.out.println("Вы хотите добавить описание к задаче? yes/no");
        String answer = scanner.nextLine();
        if (addDescription(answer)) {
            String description = scanner.nextLine();
            project.getTasks().get(numberOfTask - 1).setDescription(description);
        }
        System.out.println(String.format("В проекте №%d создана задача №%d: %s", numberOfProject, numberOfTask, nameOfTask));
    }

    private int getProjectNumber(TerminalLogic terminalLogic) {
        Scanner scanner = terminalLogic.getScanner();
        System.out.println("Введите номер проекта, к которому нужно добавить задачу:");
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

    private boolean addDescription (String answer) {
        if (answer.equalsIgnoreCase("no")) {
            System.out.println("Задача пока не содержит описание, вы можете добавить описание позже");
            return false;
        } else if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Введите описание задачи:");
            return true;
        } else {
            System.out.println("Некорректный ответ. Задача пока не содержит описание, вы можете добавить описание позже");
            return false;
        }
    }

}
