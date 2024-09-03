package org.example.commands;

import org.example.LineReader;
import org.example.repository.ProjectRepository;
import org.example.repository.TaskRepository;

public class GetAllTasksForProjectCommand extends Commands{

    private TaskRepository taskRepository = TaskRepository.getInstance();
    private LineReader reader = LineReader.getInstance();
    private ProjectRepository projectRepository = ProjectRepository.getInstance();
    private long projectId;

    @Override
    public String nameOfCommand() {
        return "get all tasks for project";
    }

    @Override
    public String description() {
        return "Показать список всех задач для проекта";
    }

    @Override
    public void execute() {
        try {
            projectRepository.isEmpty();
            taskRepository.isEmpty();
            System.out.println("Введите номер проекта, для которого необходимо показать список задач:");
            projectId = reader.readLong();
        } catch (Exception e) {
            return;
        }
        if (!projectRepository.getProjects().containsKey(projectId)) {
            projectRepository.findOne(projectId);
        } else {
            taskRepository.findAllForProject(projectId);
        }


    }
}
