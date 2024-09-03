package org.example.commands;

import org.example.repository.ProjectRepository;

public class DeleteAllProjectsCommand extends Commands{

    private ProjectRepository projectRepository = ProjectRepository.getInstance();

    @Override
    public String nameOfCommand() {
        return "delete all projects";
    }

    @Override
    public String description() {
        return "Удалить все проекты";
    }

    @Override
    public void execute() {
        try {
            projectRepository.isEmpty();
        } catch (Exception e) {
            return;
        }
        projectRepository.removeAll();
    }
}
