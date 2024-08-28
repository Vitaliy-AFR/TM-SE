package org.example.commands;

import org.example.Project;
import org.example.TerminalLogic;
import org.example.repository.ProjectRepository;

import java.util.Map;

public class GetAllProjectsCommand extends Commands{

    private ProjectRepository projectRepository = ProjectRepository.getInstance();

    @Override
    public String description() {
        return "Показать список всех проектов";
    }

    @Override
    public String nameOfCommand() {
        return "get all projects";
    }

    @Override
    public void execute() {
        try {
            projectRepository.isEmpty();
        } catch (Exception e) {
            return;
        }
        projectRepository.findAll();
    }
}
