package org.example;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TaskRepository {
    private final Map<String, Task> tasks = new HashMap<>();
}
