package org.example.commands;

import org.example.Project;
import org.example.Task;
import org.example.TerminalLogic;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GetAllProjectTasksCommand implements Commands{
    @Override
    public String nameOfCommand() {
        return "get all project tasks";
    }

    @Override
    public String description() {
        return "Показать список всех задач проекта";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {
        System.out.println("Введите номер проекта:");
        int numberOfProject = getNumber(terminalLogic);
        if (!correctProjectNumber(terminalLogic, numberOfProject)) {
            return;
        }
        Project project = terminalLogic.getProjectRepository().getProjects().get(numberOfProject);
        List<Task> tasks = project.getTasks();
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
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
            System.out.println(terminalLogic.getPROJECT_NOT_EXIST());
            return false;
        } else if (number <= 0) {
            System.out.println(terminalLogic.getINCORRECT_NUMBER_ENTERED());
            return false;
        } else {
            return true;
        }
    }


}
