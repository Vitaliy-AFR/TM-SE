package org.example.commands;

import org.example.LineReader;
import org.example.Project;
import org.example.TerminalLogic;
import org.example.repository.ProjectRepository;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class DeleteProjectCommand extends Commands {

    private ProjectRepository projectRepository = ProjectRepository.getInstance();
    private LineReader reader = LineReader.getInstance();
    long id = 0;

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
        projectRepository.remove(id);

    }

}
