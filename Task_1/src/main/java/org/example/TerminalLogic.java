package org.example;

import java.util.ArrayList;
import java.util.List;

public class TerminalLogic {

    protected String command = "";

    //Команды
    protected final String EXIT = "exit";
    private final String HELP = "help";
    private final String CREATE_PROJECT = "create project";
    private final String LIST_OF_PROJECTS = "list of projects";
    private final String SHOW_PROJECT = "show project";
    private final String CHANGE_PROJECT = "change project";
    private final String DELETE_PROJECT = "delete project";

    //Сообщения
    public static final String NONE_PROJECT = "Ни одного проекта еще не создано";
    public static final String INCORRECT_NUMBER_ENTERED = "Введено некорректное число";
    private final String ENTER_NEW_COMMAND = "Введите новую команду";
    private final String INVALID_COMMAND = "Введена некорректная команда";
    private final String EXIT_THE_PROGRAM = "Выход из программы";


    List<String> commands = new ArrayList<>();

    public TerminalLogic() {
        System.out.println("Привет, пользователь! Введи команду:");
        commands.add(EXIT + " - Закрыть программу");
        commands.add(HELP + " - Вызов справки");
        commands.add(CREATE_PROJECT + " - Создание нового проекта");
        commands.add(LIST_OF_PROJECTS + " - Показать список всех проектов");
        commands.add(SHOW_PROJECT + " - Показать проект");
        commands.add(CHANGE_PROJECT + " - Изменить проект");
        commands.add(DELETE_PROJECT + " - Удалить проект");
    }

    protected void commandProcessing(String command) {
        if (command.equalsIgnoreCase(HELP)) help();
        else if (command.equalsIgnoreCase(CREATE_PROJECT)) createProject();
        else if (command.equalsIgnoreCase(LIST_OF_PROJECTS)) listOfProjects();
        else if (command.equalsIgnoreCase(SHOW_PROJECT)) showProject();
        else if (command.equalsIgnoreCase(CHANGE_PROJECT)) changeProject();
        else if (command.equalsIgnoreCase(DELETE_PROJECT)) deleteProject();
        else if (command.equalsIgnoreCase(EXIT)) System.out.println(EXIT_THE_PROGRAM);
        else System.out.println(INVALID_COMMAND);
    }

    private void help() {
        for (String command : commands) {
            System.out.println(command);
        }
        System.out.println("\n" + ENTER_NEW_COMMAND);
    }

    private void createProject() {
        ProjectRepository projectRepository = ProjectRepository.getInstance();
        projectRepository.createProject();
        System.out.println("\n" + ENTER_NEW_COMMAND);
    }

    private void listOfProjects() {
        ProjectRepository projectRepository = ProjectRepository.getInstance();
        projectRepository.listOfProjects();
        System.out.println("\n" + ENTER_NEW_COMMAND);
    }

    private void showProject() {
        ProjectRepository projectRepository = ProjectRepository.getInstance();
        projectRepository.showProject();
        System.out.println("\n" + ENTER_NEW_COMMAND);
    }

    private void changeProject() {
        ProjectRepository projectRepository = ProjectRepository.getInstance();
        projectRepository.changeProject();
        System.out.println("\n" + ENTER_NEW_COMMAND);
    }

    private void deleteProject() {
        ProjectRepository projectRepository = ProjectRepository.getInstance();
        projectRepository.deleteProject();
        System.out.println("\n" + ENTER_NEW_COMMAND);
    }

}
