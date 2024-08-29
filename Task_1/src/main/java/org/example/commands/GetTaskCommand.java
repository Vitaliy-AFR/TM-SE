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

public class GetTaskCommand extends Commands {

    private TaskRepository taskRepository = TaskRepository.getInstance();
    private ProjectRepository projectRepository = ProjectRepository.getInstance();
    private LineReader reader = LineReader.getInstance();
    private long id;

    @Override
    public String nameOfCommand() {
        return "get task";
    }

    @Override
    public String description() {
        return "Показать задачу";
    }

    @Override
    public void execute() {
        try {
            taskRepository.isEmpty();
            System.out.println("Введите номер задачи");
            id = reader.readLong();
        } catch (Exception e) {
            return;
        }
        taskRepository.findOne(id);
    }

}
