package org.example.commands;

import org.example.Project;
import org.example.TerminalLogic;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GetProjectCommand implements Commands {

    @Override
    public String description() {
        return "Показать проект";
    }

    @Override
    public String nameOfCommand() {
        return "get project";
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
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(terminalLogic.getINCORRECT_NUMBER_ENTERED());
        }
        if (number > projects.size()) {
            System.out.println(terminalLogic.getPROJECT_WITH_SUCH_NUMBER_NOT_YET_CREATED());
            scanner.close();
        } else if (number <= 0) {
            System.out.println(terminalLogic.getINCORRECT_NUMBER_ENTERED());
        } else {
            Project project = projects.get(number);
            System.out.println("Name: " + project.getName());
            System.out.println("Project № " + project.getNumber());
            if (project.getDescription() != null) System.out.println("Description: " + project.getDescription());
        }

    }

}
