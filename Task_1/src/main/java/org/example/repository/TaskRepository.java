package org.example.repository;

import lombok.Data;
import org.example.LineReader;
import org.example.Project;
import org.example.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Data
public class TaskRepository {

    private final String NONE_TASK = "Ни одной задачи не существует";
    private final String TASK_NOT_EXIST = "Задача c таким номером не существует";
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
        String endDateString = "";
        while (!endDateString.equalsIgnoreCase("cancel")) {
            endDateString = reader.readString() + " 23:59:59";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
            try {
                LocalDateTime endDate = LocalDateTime.parse(endDateString, formatter);
                if (endDate.isBefore(tasks.get(id).getStartDate())) {
                    System.out.println("Дата окончания не может быть раньше даты создания. Введите дату еще раз или \"cancel\" для отмены");
                } else {
                    tasks.get(id).setEndDate(endDate);
                    projectRepository
                            .getProjects()
                            .get(tasks.get(id).getProjectId())
                            .getTasks()
                            .get(id)
                            .setEndDate(endDate);
                    break;
                }
            } catch (Exception e) {
                if (!endDateString.equalsIgnoreCase("cancel"))
                    System.out.println("Дата введена неверно. Введите дату еще раз или \"cancel\" для отмены");
            }
        }

    }

    public void addNewNameTask(long id) {
        System.out.println("Введите имя проекта:");
        String name = reader.readString();
        tasks.get(id).setName(name);
    }

    public void findOne(long id) {
        if (id <= 0) {
            System.out.println(INCORRECT_NUMBER_ENTERED);
        } else if (!tasks.containsKey(id)) {
            System.out.println(TASK_NOT_EXIST);
        } else {
            System.out.println(tasks.get(id));
        }
    }

    public void findAll() {
        System.out.println("Список всех задач:");
        for (Task task : tasks.values()) {
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
            for (Map.Entry<Long, Task> entry : tasks.entrySet()) {
                if (entry.getKey() > maxId) {
                    maxId = entry.getKey();
                }
            }
        }
        return maxId;
    }

    public void isEmpty() {
        if (tasks.size() == 0) {
            System.out.println(NONE_TASK);
            throw new InputMismatchException();
        }
    }

    public void remove(long id) {
        if (id <= 0) {
            System.out.println(INCORRECT_NUMBER_ENTERED);
        } else if (!tasks.containsKey(id)) {
            System.out.println(TASK_NOT_EXIST);
        } else {
            projectRepository
                    .getProjects()
                    .get(tasks.get(id).getProjectId())
                    .getTasks()
                    .remove(id);
            tasks.remove(id);
            System.out.println("Задача №" + id + " удалена");
        }
    }

    public void removeAll() {
        for (Map.Entry<Long, Project> entry : projectRepository.getProjects().entrySet()) {
            entry.getValue().getTasks().clear();
        }
        tasks.clear();
        System.out.println("Все задачи были удалены");
    }

    public void removeAllForProject(long projectId) {
        projectRepository.getProjects().get(projectId).getTasks().clear();
        for (Iterator<Map.Entry<Long, Task>> entryIterator = tasks.entrySet().iterator(); entryIterator.hasNext(); ) {
            Map.Entry<Long, Task> entry = entryIterator.next();
            if (entry.getValue().getProjectId() == projectId) {
                entryIterator.remove();
            }
        }

    }

}
