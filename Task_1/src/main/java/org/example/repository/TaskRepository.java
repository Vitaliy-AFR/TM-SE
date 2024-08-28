package org.example.repository;

import lombok.Data;
import org.example.Task;

import java.util.HashMap;
import java.util.Map;

@Data
public class TaskRepository {

    protected final String NONE_TASK = "Ни одна задача еще не создана";
    protected final String TASK_NOT_EXIST = "Задача с именем %s не существует";

    private final Map<Long, Task> tasks = new HashMap<>();

    private static TaskRepository instance = new TaskRepository();

    private TaskRepository() {
    }

    public static TaskRepository getInstance() {
        return instance;
    }
}
