package org.example.commands;

import org.example.LineReader;
import org.example.repository.ProjectRepository;
import org.example.repository.TaskRepository;

import java.util.InputMismatchException;

public class DeleteProjectCommand extends Commands {

    private ProjectRepository projectRepository = ProjectRepository.getInstance();
    private TaskRepository taskRepository = TaskRepository.getInstance();
    private LineReader reader = LineReader.getInstance();
    private long id;

    @Override
    public String nameOfCommand() {
        return "delete project";
    }

    @Override
    public String description() {
        return "Удалить проект";
    }

    @Override
    public void execute() {
        try {
            projectRepository.isEmpty();
            System.out.println("Введите номер проекта:");
            id = reader.readLong();
        } catch (InputMismatchException e) {
            return;
        }
        taskRepository.removeAllForProject(id);
        projectRepository.remove(id);
    }

}
