package org.example.commands;

import org.example.Project;
import org.example.TerminalLogic;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class UpdateProjectCommand implements Commands {
    @Override
    public String description() {
        return "Изменить проект";
    }

    @Override
    public String nameOfCommand() {
        return "update project";
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
            System.out.println(terminalLogic.getPROJECT_WITH_SUCH_NUMBER_NOT_YET_CREATED());
        } else {
            while (true) {
                System.out.println("Введите название графы, которую вы хотите изменить: name/description (чтобы отменить изменение, введите cancel)");
                String column = scanner.nextLine();
                if (column.equalsIgnoreCase("cancel")) {
                    break;
                } else if (column.equalsIgnoreCase("name")) {
                    System.out.println("Введите новое название проекта");
                    column = scanner.nextLine();
                    projects.get(number).setName(column);
                    continue;
                } else if (column.equalsIgnoreCase("description")) {
                    System.out.println("Введите новое описание проекта");
                    column = scanner.nextLine();
                    projects.get(number).setDescription(column);
                    continue;
                }
            }

        }
    }

}
