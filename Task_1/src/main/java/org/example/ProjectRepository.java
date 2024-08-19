package org.example;

import lombok.Data;


import java.util.HashMap;
import java.util.Map;

@Data
public class ProjectRepository {
    private final Map<Integer, Project> projects = new HashMap<>();

}
