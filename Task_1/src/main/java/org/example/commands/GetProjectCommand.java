package org.example.commands;

import org.example.LineReader;
import org.example.repository.ProjectRepository;

import java.util.InputMismatchException;


public class GetProjectCommand extends Commands {

    private LineReader reader = LineReader.getInstance();
    private ProjectRepository projectRepository = ProjectRepository.getInstance();
    long id = 0;

    @Override
    public String description() {
        return "Показать проект";
    }

    @Override
    public String nameOfCommand() {
        return "get project";
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
        projectRepository.findOne(id);
    }



}
