package org.example.commands;

import org.example.LineReader;
import org.example.repository.ProjectRepository;

public class CreateProjectCommand extends Commands {


    private final String NO_DESCRIPTION = "Проект %s пока не содержит описание. Вы можете добавить описание позже.";
    private final String NO_END_DATE = "Проект %s пока не содержит дату окончания. Вы можете добавить ее позже.";

    private ProjectRepository projectRepository = ProjectRepository.getInstance();
    private LineReader reader = LineReader.getInstance();
    private long id;
    private String name;

    @Override
    public String description() {
        return "Создать проект";
    }

    @Override
    public String nameOfCommand() {
        return "create project";
    }

    @Override
    public void execute() {
        System.out.println("Введите имя нового проекта:");
        name = reader.readString();
        id = projectRepository.createNew(name);
        addDescription();
        addEndDate();
        System.out.println("Создан проект:");
        projectRepository.findOne(id);
    }

    private void addDescription() {
        System.out.println("Вы хотите добавить описание к проекту? yes/no");
        String answer = reader.readString();
        if (answer.equalsIgnoreCase(YES)) {
            projectRepository.addDescription(id);
        } else if (answer.equalsIgnoreCase(NO)) {
            System.out.println(String.format(NO_DESCRIPTION, name));
        } else {
            System.out.println(INCORRECT_ANSWER + ". " + String.format(NO_DESCRIPTION, name));
        }
    }

    private void addEndDate() {
        System.out.println("Вы хотите добавить дату окончания проекта? yes/no");
        String answer = reader.readString();
        if (answer.equalsIgnoreCase(YES)) {
            projectRepository.addEndDate(id);
        } else if (answer.equalsIgnoreCase(NO)) {
            System.out.println(String.format(NO_END_DATE, name));
        } else {
            System.out.println(INCORRECT_ANSWER + ". " + String.format(NO_END_DATE, name));
        }
    }

}
