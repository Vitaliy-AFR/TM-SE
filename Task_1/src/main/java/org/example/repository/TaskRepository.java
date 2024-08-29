package org.example.repository;

import lombok.Data;
import org.example.LineReader;
import org.example.Project;
import org.example.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Data
public class TaskRepository {

    protected final String NONE_TASK = "Ни одна задача еще не создана";
    protected final String TASK_NOT_EXIST = "Задача c таким номером не существует";
    private final String INCORRECT_NUMBER_ENTERED = "Введено некорректное число";

    private final Map<Long, Task> tasks = new HashMap<>();
    private LineReader reader = LineReader.getInstance();
    private ProjectRepository projectRepository = ProjectRepository.getInstance();

    private static TaskRepository instance = new TaskRepository();

    private TaskRepository() {
    }

    public static TaskRepository getInstance() {
        return instance;
    }

    public long createNewTask(long projectId, String name) {
        long id = tasks.size() + 1;

        Task task = Task.builder()
                .id(id)
                .projectId(projectId)
                .name(name)
                .build();
        tasks.put(id, task);
        projectRepository.getProjects()
                .get(projectId)
                .getTasks()
                .put(id, task);
        return id;
    }

    public void addDescription(long id) {
        System.out.println("Введите описание к задаче:");
        String description = reader.readString();
        tasks.get(id).setDescription(description);
        projectRepository.getProjects()
                .get(tasks.get(id).getProjectId())
                .getTasks()
                .get(id)
                .setDescription(description);
    }

    public void addEndDate(long id) {
        System.out.println("Введите дату окончания задачи:");
        while (true){
            String endDateString = reader.readString();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date endDate;
            try {
                endDate = formatter.parse(endDateString);
                GregorianCalendar endDateGregorian = new GregorianCalendar();
                endDateGregorian.setTime(endDate);
                if (endDateGregorian.before(tasks.get(id).getStartDate())) {
                    System.out.println("Дата окончания не может быть раньше даты создания. Введите дату еще раз");
                } else {
                    tasks.get(id).setEndDate(endDateGregorian);
                    projectRepository.getProjects()
                            .get(tasks.get(id).getProjectId())
                            .getTasks()
                            .get(id)
                            .setEndDate(endDateGregorian);
                    break;
                }
            } catch (ParseException e) {
                System.out.println("Дата введена неверно");
            }
        }

    }

    public void addNewNameTask(long id) {
        System.out.println("Введите имя проекта:");
        String name = reader.readString();
        tasks.get(id).setName(name);
    }

    public void findOne(long id) {
        if (id > maxId()) {
            System.out.println(TASK_NOT_EXIST);
        } else if (id <= 0) {
            System.out.println(INCORRECT_NUMBER_ENTERED);
        } else {
            System.out.println(tasks.get(id));
        }
    }

    public void findAll() {
        System.out.println("Список всех задач:");
        for (Task task : tasks.values()){
            System.out.println(task);
        }
    }

    public void findAllForProject(long projectId) {
        Map<Long, Task> tasksProject = projectRepository
                .getProjects()
                .get(projectId)
                .getTasks();
        if (tasksProject.size() == 0) {
            System.out.println("Данный проект не содержит задач");
            return;
        }
        System.out.println(String.format("Список всех задач для проекта №%d:", projectId));
        for (Task task : tasksProject.values()) {
            System.out.println(task);
        }
    }

    private long maxId() {
        long maxId = 0;
        if (tasks.size() != 0) {
            for(Map.Entry<Long, Task> entry : tasks.entrySet()) {
                if (entry.getKey() > maxId) {
                    maxId = entry.getKey();
                }
            }
        }
        return maxId;
    }

    public void isEmpty () {
        if (tasks.size() == 0) {
            System.out.println(NONE_TASK);
            throw new InputMismatchException();
        }
    }

    public void remove(long id) {
        if (id > maxId()) {
            System.out.println(TASK_NOT_EXIST);
        } else if (id <= 0) {
            System.out.println(INCORRECT_NUMBER_ENTERED);
        } else {
            tasks.remove(id);
            projectRepository.getProjects()
                    .get(tasks.get(id).getProjectId())
                    .getTasks()
                    .remove(id);
            System.out.println("Задача №" + id + " удалена");
        }
    }

    public void removeAll() {
        for (Map.Entry<Long, Task> entry : tasks.entrySet()){
            tasks.remove(entry);
        }
        for (Map.Entry<Long, Project> entry : projectRepository.getProjects().entrySet()) {
            entry.getValue().getTasks().clear();
        }
        System.out.println("Все задачи были удалены");
    }

    public void removeAllForProject(long projectId) {
        projectRepository.getProjects().get(projectId).getTasks().clear();
        for (Map.Entry<Long, Task> entry : tasks.entrySet()){
            if (entry.getValue().getProjectId() == projectId) {
                tasks.remove(entry);
            }
        }
    }

}
