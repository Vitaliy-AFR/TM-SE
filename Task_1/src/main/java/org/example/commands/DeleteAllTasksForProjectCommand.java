package org.example.commands;

import org.example.LineReader;
import org.example.repository.ProjectRepository;
import org.example.repository.TaskRepository;

public class DeleteAllTasksForProjectCommand extends Commands{

    private TaskRepository taskRepository = TaskRepository.getInstance();
    private ProjectRepository projectRepository = ProjectRepository.getInstance();
    private LineReader lineReader = LineReader.getInstance();
    private long projectId;

    @Override
    public String nameOfCommand() {
        return "delete all tasks for project";
    }

    @Override
    public String description() {
        return "Удалить все задачи из проекта";
    }

    @Override
    public void execute() {
        try {
            taskRepository.isEmpty();
            System.out.println("Введите номер проекта:");
            projectId = lineReader.readLong();
        } catch (Exception e) {
            return;
        }
        if (!projectRepository.getProjects().containsKey(projectId)) {
            projectRepository.findOne(projectId);
        } else {
            taskRepository.removeAllForProject(projectId);
            System.out.println("Все задачи удалены из проекта №" + projectId);
        }
    }
}
