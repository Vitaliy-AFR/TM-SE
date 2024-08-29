package org.example.commands;

import org.example.LineReader;
import org.example.Project;
import org.example.Task;
import org.example.TerminalLogic;
import org.example.repository.ProjectRepository;
import org.example.repository.TaskRepository;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CreateTaskCommand extends Commands{

    private LineReader reader = LineReader.getInstance();
    private TaskRepository taskRepository = TaskRepository.getInstance();
    private ProjectRepository projectRepository = ProjectRepository.getInstance();
    private long id;
    private long projectId;
    private String name;

    private final String NO_DESCRIPTION = "Задача %s пока не содержит описание. Вы можете добавить описание позже.";
    private final String NO_END_DATE = "Задача %s пока не содержит дату окончания. Вы можете добавить ее позже.";

    @Override
    public String nameOfCommand() {
        return "create task";
    }

    @Override
    public String description() {
        return "Создать задачу";
    }

    @Override
    public void execute() {
        try {
            projectRepository.isEmpty();
            System.out.println("Введите номер проекта, к которому нужно добавить задачу:");
            projectId = reader.readLong();
        } catch (Exception e) {
            return;
        }
        if (!projectRepository.getProjects().containsKey(projectId)) {
            projectRepository.findOne(projectId);
        } else {
            System.out.println("Введите имя задачи:");
            name = reader.readString();
            id = taskRepository.createNewTask(projectId, name);
            addDescription();
            addEndDate();
            System.out.println("Создана задача:");
            taskRepository.findOne(id);
        }

    }

    private void addDescription () {
        System.out.println("Вы хотите добавить описание к задаче? yes/no");
        String answer = reader.readString();
        if (answer.equalsIgnoreCase(YES)) {
            taskRepository.addDescription(id);
        } else if (answer.equalsIgnoreCase(NO)) {
            System.out.println(String.format(NO_DESCRIPTION, name));
        } else {
            System.out.println(INCORRECT_ANSWER + ". " + String.format(NO_DESCRIPTION, name));
        }
    }

    private void addEndDate() {
        System.out.println("Вы хотите добавить дату окончания задачи? yes/no");
        String answer = reader.readString();
        if (answer.equalsIgnoreCase(YES)) {
            taskRepository.addEndDate(id);
        } else if (answer.equalsIgnoreCase(NO)) {
            System.out.println(String.format(NO_END_DATE, name));
        } else {
            System.out.println(INCORRECT_ANSWER + ". " + String.format(NO_END_DATE, name));
        }
    }

}
