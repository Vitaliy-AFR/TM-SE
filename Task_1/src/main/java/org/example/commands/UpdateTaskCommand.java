package org.example.commands;

import org.example.Project;
import org.example.Task;
import org.example.TerminalLogic;

import java.util.Map;
import java.util.Scanner;

public class UpdateTaskCommand implements Commands{
    @Override
    public String nameOfCommand() {
        return "update task";
    }

    @Override
    public String description() {
        return "Изменить задачу";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {
        Map<String, Task> tasks = terminalLogic.getTaskRepository().getTasks();
        Map<Integer, Project> projects = terminalLogic.getProjectRepository().getProjects();
        Scanner scanner = terminalLogic.getScanner();
        if (!tasksExist(terminalLogic)) {
            return;
        }
        String nameOfTask = nameOfTask(terminalLogic);
        if (!tasks.containsKey(nameOfTask)) {
            System.out.println(String.format(terminalLogic.getTASK_NOT_EXIST(), nameOfTask));
            return;
        }
        Task task = tasks.get(nameOfTask);
        System.out.println("Введите новое описание задачи:");
        String description = scanner.nextLine();
        tasks.get(nameOfTask).setDescription(description);
        projects.get(task.getNumberOfProject()).getTasks().get(task.getNumber() - 1).setDescription(description);
    }

    private boolean tasksExist(TerminalLogic terminalLogic) {
        Map<String, Task> tasks = terminalLogic.getTaskRepository().getTasks();
        if (tasks.size() == 0) {
            System.out.println(terminalLogic.getNONE_TASK());
            return false;
        }
        return true;
    }

    private String nameOfTask (TerminalLogic terminalLogic) {
        Scanner scanner = terminalLogic.getScanner();
        System.out.println("Введите имя задачи:");
        String nameOfTask = scanner.nextLine();
        return nameOfTask;
    }

}
