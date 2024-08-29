package org.example.commands;

import org.example.LineReader;
import org.example.repository.TaskRepository;

import java.util.InputMismatchException;

public class UpdateTaskCommand extends Commands{

    private TaskRepository taskRepository = TaskRepository.getInstance();
    private LineReader reader = LineReader.getInstance();
    private long id;

    @Override
    public String nameOfCommand() {
        return "update task";
    }

    @Override
    public String description() {
        return "Изменить задачу";
    }

    @Override
    public void execute() {
        try {
            taskRepository.isEmpty();
            System.out.println("Введите номер задачи:");
            id = reader.readLong();
        } catch (InputMismatchException e) {
            return;
        }
        if (!taskRepository.getTasks().containsKey(id)) {
            taskRepository.findOne(id);
        } else {
            updateTask();
        }
    }

    private void updateTask(){
        while (true) {
            System.out.println("Введите название графы, которую вы хотите изменить: name/description/end date (чтобы отменить изменение, введите cancel)");
            String column = reader.readString();
            if (column.equalsIgnoreCase("cancel")) {
                break;
            } else if (column.equalsIgnoreCase("name")) {
                taskRepository.addNewNameTask(id);
            } else if (column.equalsIgnoreCase("description")) {
                taskRepository.addDescription(id);
            } else if (column.equalsIgnoreCase("end date")) {
                taskRepository.addEndDate(id);
            }
        }
    }

}
