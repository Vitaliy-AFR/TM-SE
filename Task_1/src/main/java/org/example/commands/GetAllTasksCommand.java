package org.example.commands;

import org.example.LineReader;
import org.example.Task;
import org.example.TerminalLogic;
import org.example.repository.TaskRepository;

import java.util.Map;
import java.util.Scanner;

public class GetAllTasksCommand extends Commands{

    private TaskRepository taskRepository = TaskRepository.getInstance();

    @Override
    public String nameOfCommand() {
        return "get all tasks";
    }

    @Override
    public String description() {
        return "Показать список всех задач";
    }

    @Override
    public void execute() {
        try {
            taskRepository.isEmpty();
        } catch (Exception e) {
            return;
        }
        taskRepository.findAll();
    }

}
