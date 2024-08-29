package org.example.commands;

import org.example.repository.TaskRepository;

public class DeleteAllTasksCommand extends Commands{

    private TaskRepository taskRepository = TaskRepository.getInstance();

    @Override
    public String nameOfCommand() {
        return "delete all tasks";
    }

    @Override
    public String description() {
        return "Удалить все задачи";
    }

    @Override
    public void execute() {
        try {
            taskRepository.isEmpty();
        } catch (Exception e) {
            return;
        }
        taskRepository.removeAll();
    }
}
