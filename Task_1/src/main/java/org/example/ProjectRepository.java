package org.example;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ProjectRepository {
    private final Map<Integer, Project> projects = new HashMap<>();

    private static ProjectRepository instance;

    private ProjectRepository() {
    }

    public static ProjectRepository getInstance() {
        if (instance == null) instance = new ProjectRepository();
        return instance;
    }

    protected void createProject() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя нового проекта:");
        String name = null;
        try {
            name = reader.readLine();
        } catch (IOException ignore) {
        }
        int number = projects.size() + 1;
        projects.put(number, new Project(name, number));
        System.out.println("Вы хотите добавить описание к проекту? yes/no");
        try {
            String answer = reader.readLine();
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("Введите описание к проекту:");
                projects.get(number).setDescription(reader.readLine());
            } else if (answer.equalsIgnoreCase("no")) {
                System.out.println("Проект " + name + " пока не содержит описание. Вы можете добавить описание позже.");
            } else {
                System.out.println("Некорректный отевет. Проект " + name + " пока не содержит описание. Вы можете добавить описание позже.");
            }
        } catch (IOException ignore) {
        }
        System.out.println("Создан проект №" + number + ": " + name);
    }

    protected void listOfProjects() {
        if (projects.size() == 0) System.out.println(TerminalLogic.NONE_PROJECT);
        for (Project project : projects.values()) {
            System.out.println(project.toString());
        }
    }

    protected void showProject() {
        if (projects.size() == 0) {
            System.out.println(TerminalLogic.NONE_PROJECT);
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите номер проекта:");
        int number = 0;
        try {
            number = Integer.parseInt(reader.readLine());

        } catch (IOException ignore) {
        } catch (NumberFormatException N) {
            System.out.println(TerminalLogic.INCORRECT_NUMBER_ENTERED);
        }
        if (number > projects.size()) {
            System.out.println("Проект с таким номером еще не создан");
        } else if (number <= 0) System.out.println(TerminalLogic.INCORRECT_NUMBER_ENTERED);
        else{
            Project project = projects.get(number);
            System.out.println("Name: " + project.getName());
            System.out.println("Project № " + project.getNumber());
            if (project.getDescription() != null) System.out.println("Description: " + project.getDescription());
        }
    }

    protected void changeProject() {
        if (projects.size() == 0) {
            System.out.println(TerminalLogic.NONE_PROJECT);
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите номер проекта:");
        int number = 0;
        try {
            number = Integer.parseInt(reader.readLine());

        } catch (IOException ignore) {
        } catch (NumberFormatException N) {
            System.out.println(TerminalLogic.INCORRECT_NUMBER_ENTERED);
        }
        if (number > projects.size()) {
            System.out.println("Проект с таким номером еще не создан");
        } else if (number <= 0) System.out.println(TerminalLogic.INCORRECT_NUMBER_ENTERED);
        else{
            while (true) {
                String column = null;
                System.out.println("Введите название графы, которую вы хотите изменить: name/description (чтобы отменить изменение, введите cancel)");
                try {
                    column = reader.readLine();
                } catch (IOException ignore) {
                }
                if (column.equalsIgnoreCase("cancel")) break;
                else if (column.equalsIgnoreCase("name")) {
                    System.out.println("Введите новое название проекта");
                    try {
                        column = reader.readLine();
                        projects.get(number).setName(column);
                    } catch (IOException ignore) {
                    }
                    continue;
                } else if (column.equalsIgnoreCase("description")) {
                    System.out.println("Введите новое описание проекта");
                    try {
                        column = reader.readLine();
                        projects.get(number).setDescription(column);
                    } catch (IOException ignore) {
                    }
                    continue;
                }
            }
        }
    }

    protected void deleteProject() {
        if (projects.size() == 0) {
            System.out.println(TerminalLogic.NONE_PROJECT);
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите номер проекта:");
        int number = 0;
        try {
            number = Integer.parseInt(reader.readLine());

        } catch (IOException ignore) {
        } catch (NumberFormatException N) {
            System.out.println(TerminalLogic.INCORRECT_NUMBER_ENTERED);
        }
        if (number > projects.size()) {
            System.out.println("Проект с таким номером еще не создан");
        } else if (number <= 0) System.out.println(TerminalLogic.INCORRECT_NUMBER_ENTERED);
        else{
            projects.remove(number);
            System.out.println("Проект №" + number + " удален");
        }
    }

}
