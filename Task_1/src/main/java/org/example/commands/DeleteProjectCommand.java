package org.example.commands;

import org.example.Project;
import org.example.TerminalLogic;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class DeleteProjectCommand implements Commands {
    @Override
    public String nameOfCommand() {
        return "delete project";
    }

    @Override
    public String description() {
        return "Удалить проект";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {
        Scanner scanner = terminalLogic.getScanner();
        Map<Integer, Project> projects = terminalLogic.getProjectRepository().getProjects();
        if (projects.size() == 0) {
            System.out.println(terminalLogic.getNONE_PROJECT());
            return;
        }
        System.out.println("Введите номер проекта:");
        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(terminalLogic.getINCORRECT_NUMBER_ENTERED());
        }
        if (number > projects.size()) {
            System.out.println("Проект с таким номером еще не создан");
        } else if (number <= 0) {
            System.out.println(terminalLogic.getINCORRECT_NUMBER_ENTERED());
        } else {
            projects.remove(number);
            System.out.println("Проект №" + number + " удален");
        }
    }

}
