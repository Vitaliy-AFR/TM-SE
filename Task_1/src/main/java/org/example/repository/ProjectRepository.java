package org.example.repository;

import lombok.Data;
import org.example.LineReader;
import org.example.Project;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Data
public class ProjectRepository {

    private final Map<Long, Project> projects = new HashMap<>();
    private LineReader reader = LineReader.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private final String PROJECT_NOT_EXIST = "Проект с таким номером еще не создан";
    private final String INCORRECT_NUMBER_ENTERED = "Введено некорректное число";
    private final String NONE_PROJECT = "Ни одного проекта еще не создано";
    private final String All_PROJECTS_DELETED = "Все проекты удалены";

    private static ProjectRepository instance = new ProjectRepository();
    private ProjectRepository() {
    }
    public static ProjectRepository getInstance() {
        return instance;
    }

    public long createNewProject(String name) {
        long id = projects.size() + 1;
        Project project = Project
                .builder()
                .name(name)
                .id(id)
                .build();
        projects.put(id, project);
        return id;
    }

    public void addDescriptionProject(long id) {
        System.out.println("Введите описание к проекту:");
        String description = reader.readString();
        projects.get(id).setDescription(description);
    }

    public void addEndDateProject(long id) {
        System.out.println("Введите дату окончания проекта:");
        while (true){
            String endDateString = reader.readString();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date endDate;
            try {
                endDate = formatter.parse(endDateString);
                GregorianCalendar endDateGregorian = new GregorianCalendar();
                endDateGregorian.setTime(endDate);
                if (endDateGregorian.before(projects.get(id).getStartDate())) {
                    System.out.println("Дата окончания не может быть раньше даты создания. Введите дату еще раз");
                } else {
                    projects.get(id).setEndDate(endDateGregorian);
                    break;
                }
            } catch (ParseException e) {
                System.out.println("Дата введена неверно");
            }
        }

    }

    public void addNewNameProject(long id) {
        System.out.println("Введите имя проекта:");
        String name = reader.readString();
        projects.get(id).setName(name);
    }

    public void findOne(long id) {
        if (id > maxId()) {
            System.out.println(PROJECT_NOT_EXIST);
        } else if (id <= 0) {
            System.out.println(INCORRECT_NUMBER_ENTERED);
        } else {
            System.out.println(projects.get(id));
        }
    }

    public void findAll() {
        System.out.println("Список всех проектов:");
        for (Project project : projects.values()){
            System.out.println(project.toString());
        }
    }

    public void remove(long id) {
        if (id > maxId()) {
            System.out.println(PROJECT_NOT_EXIST);
        } else if (id <= 0) {
            System.out.println(INCORRECT_NUMBER_ENTERED);
        } else {
            projects.remove(id);
            System.out.println("Проект №" + id + " удален");
        }
    }

    public void removeAll() {
        for (Map.Entry<Long, Project> entry : projects.entrySet()){
            projects.remove(entry);
        }
        System.out.println("Все проекты были удалены");
    }

    public void isEmpty () {
        if (projects.size() == 0) {
            System.out.println(NONE_PROJECT);
            throw new InputMismatchException();
        }
    }

    private long maxId() {
        long maxId = 0;
        if (projects.size() != 0) {
            for(Map.Entry<Long, Project> entry : projects.entrySet()) {
                if (entry.getKey() > maxId) {
                    maxId = entry.getKey();
                }
            }
        }
        return maxId;
    }

}
