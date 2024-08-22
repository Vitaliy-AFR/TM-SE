package org.example.commands;

import org.example.Task;
import org.example.TerminalLogic;

import java.util.Map;
import java.util.Scanner;

public class GetAllTasksCommand implements Commands{
    @Override
    public String nameOfCommand() {
        return "get all tasks";
    }

    @Override
    public String description() {
        return "Показать список всех задач";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {
        Map<String, Task> tasks = terminalLogic.getTaskRepository().getTasks();
        if (!tasksExist(terminalLogic)) {
            return;
        }
        for (Task task : tasks.values()) {
            System.out.println(task.toString());
        }
    }

    private boolean tasksExist(TerminalLogic terminalLogic) {
        Map<String, Task> tasks = terminalLogic.getTaskRepository().getTasks();
        if (tasks.size() == 0) {
            System.out.println(terminalLogic.getNONE_TASK());
            return false;
        }
        return true;
    }
}
