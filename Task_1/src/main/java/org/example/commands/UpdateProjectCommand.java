package org.example.commands;

import org.example.LineReader;
import org.example.repository.ProjectRepository;

import java.util.InputMismatchException;

public class UpdateProjectCommand extends Commands {

    private ProjectRepository projectRepository = ProjectRepository.getInstance();
    private LineReader reader = LineReader.getInstance();
    long id = 0;

    @Override
    public String description() {
        return "Изменить проект";
    }

    @Override
    public String nameOfCommand() {
        return "update project";
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
        if (!projectRepository.getProjects().containsKey(id)) {
            projectRepository.findOne(id);
        } else {
            updateProject();
        }
    }

    private void updateProject(){
        while (true) {
            System.out.println("Введите название графы, которую вы хотите изменить: name/description/end date (чтобы отменить изменение, введите cancel)");
            String column = reader.readString();
            if (column.equalsIgnoreCase("cancel")) {
                break;
            } else if (column.equalsIgnoreCase("name")) {
                projectRepository.addNewNameProject(id);
            } else if (column.equalsIgnoreCase("description")) {
                projectRepository.addDescriptionProject(id);
            } else if (column.equalsIgnoreCase("end date")) {
                projectRepository.addEndDateProject(id);
            }
        }
    }

}
