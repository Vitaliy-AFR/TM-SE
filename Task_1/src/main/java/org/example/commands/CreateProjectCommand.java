package org.example.commands;

import org.example.Project;
import org.example.TerminalLogic;

import java.util.Map;
import java.util.Scanner;

public class CreateProjectCommand implements Commands {
    @Override
    public String description() {
        return "Создание проекта";
    }

    @Override
    public String nameOfCommand() {
        return "create project";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {
        Scanner scanner = terminalLogic.getScanner();
        Map<Integer, Project> projects = terminalLogic.getProjectRepository().getProjects();
        System.out.println("Введите имя нового проекта:");
        String name = scanner.nextLine();
        int number = projects.size() + 1;
        projects.put(number, Project.builder().name(name).number(number).build());
        System.out.println("Вы хотите добавить описание к проекту? yes/no");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Введите описание к проекту:");
            projects.get(number).setDescription(scanner.nextLine());
        } else if (answer.equalsIgnoreCase("no")) {
            System.out.println("Проект " + name + " пока не содержит описание. Вы можете добавить описание позже.");
        } else {
            System.out.println("Некорректный отевет. Проект " + name + " пока не содержит описание. Вы можете добавить описание позже.");
        }
        System.out.println("Создан проект №" + number + ": " + name);

    }
}
