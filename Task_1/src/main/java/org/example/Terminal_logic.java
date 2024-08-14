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

    static List<String> commands = new ArrayList<>();
    private static void commandsInit(){
        commands.add(EXIT + " - Закрыть программу");
        commands.add(HELP + " - Вызов справки");
        commands.add(CREATE_PROJECT + " - Создание нового проекта");
        commands.add(LIST_OF_PROJECT + " - Показать список всех проектов");
    }

    protected static void commandProcessing(String command) {
        if (command.equalsIgnoreCase(HELP)) help();
        if (command.equalsIgnoreCase(CREATE_PROJECT)) createProject();
        if(command.equalsIgnoreCase(LIST_OF_PROJECT)) listOfProject();
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
        try {name = reader.readLine();} catch (IOException ignore) {}
        int number = Data.getProjectList().size() + 1;
            Data.getProjectList().add(new Project(name, number));
    }

    private static void listOfProject(){
        List<Project> projects = Data.getProjectList();
        if (projects.size() == 0) System.out.println("Ни одного проекта еще не создано");
        for(Project project : projects) {
            System.out.println(project.toString());
        }
    }

}
