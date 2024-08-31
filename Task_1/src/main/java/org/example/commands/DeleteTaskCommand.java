package org.example.commands;

import org.example.LineReader;
import org.example.repository.TaskRepository;

public class DeleteTaskCommand extends Commands{

    private TaskRepository taskRepository = TaskRepository.getInstance();
    private LineReader reader = LineReader.getInstance();
    private long id;

    @Override
    public String nameOfCommand() {
        return "delete task";
    }

    @Override
    public String description() {
        return "Удалить задачу";
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
        taskRepository.remove(id);
    }

}
