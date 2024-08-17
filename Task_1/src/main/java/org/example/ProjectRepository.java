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

    //Сообщения


    //Добавление данных в мап должно быть в этом классе
    //адд, делет и тд


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
        System.out.println("Создан проект №" + number + ": " + name);
    }

    protected void listOfProjects() {
        if (projects.size() == 0) System.out.println(TerminalLogic.NONE_PROJECT);
        for (Project project : projects.values()) {
            System.out.println(project.toString());
        }
    }

    protected void showProjectNumber() {
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

}
