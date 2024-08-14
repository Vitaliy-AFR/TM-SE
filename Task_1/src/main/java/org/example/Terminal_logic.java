package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Terminal_logic {

    protected static String command = "";
    protected static final String EXIT = "exit";
    private static final String HELP = "help";
    private static final String CREATE_PROJECT = "create project";
    private static final String LIST_OF_PROJECT = "list of projects";
    private static final String SHOW_PROJECT = "show project";
    private static final String NONE_PROJECT = "Ни одного проекта еще не создано";

    static List<String> commands = new ArrayList<>();

    private static void commandsInit() {
        commands.add(EXIT + " - Закрыть программу");
        commands.add(HELP + " - Вызов справки");
        commands.add(CREATE_PROJECT + " - Создание нового проекта");
        commands.add(LIST_OF_PROJECT + " - Показать список всех проектов");
        commands.add(SHOW_PROJECT + " - Показать проект № ...");
    }

    protected static void commandProcessing(String command) {
        if (command.equalsIgnoreCase(HELP)) help();
        if (command.equalsIgnoreCase(CREATE_PROJECT)) createProject();
        if (command.equalsIgnoreCase(LIST_OF_PROJECT)) listOfProject();
        if (command.equalsIgnoreCase(SHOW_PROJECT)) showProjectNumber();
    }

    private static void help() {
        commandsInit();
        for (String command : commands) {
            System.out.println(command);
        }
    }

    private static void createProject() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя нового проекта:");
        String name = null;
        try {
            name = reader.readLine();
        } catch (IOException ignore) {
        }
        int number = Data.getProjectList().size() + 1;
        Data.getProjectList().add(new Project(name, number));
    }

    private static void listOfProject() {
        List<Project> projects = Data.getProjectList();
        if (projects.size() == 0) System.out.println(NONE_PROJECT);
        for (Project project : projects) {
            System.out.println(project.toString());
        }
    }

    private static void showProjectNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите номер проекта:");
        int number = 0;
        try {
            number = Integer.parseInt(reader.readLine());

        } catch (IOException ignore) {
        }
        if (number == 0) {
            System.out.println(NONE_PROJECT);
        } else {
            Project project = Data.getProjectList().get(number - 1);
            System.out.println("Name: " + project.getName());
            System.out.println("Project № " + project.getNumber());
            if (project.getDescription() != null) System.out.println("Description: " + project.getDescription());
        }
    }

}
