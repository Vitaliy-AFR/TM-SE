package org.example.commands;

import org.example.Project;
import org.example.ProjectRepository;
import org.example.TerminalLogic;

import java.util.Map;

public class GetAllProjectsCommand implements Commands{
    @Override
    public String description() {
        return "Показать список всех проектов";
    }

    @Override
    public String nameOfCommand() {
        return "get all projects";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {
        Map<Integer, Project> projects = terminalLogic.getProjectRepository().getProjects();
        if (projects.size() == 0) {
            System.out.println(terminalLogic.getNONE_PROJECT());
        }
        for (Project project : projects.values()){
            System.out.println(project.toString());
        }
    }
}
