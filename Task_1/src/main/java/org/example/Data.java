package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    private static List<Project> projectList = new ArrayList<>();
    private static Map<Project, List<Task>> taskMap = new HashMap<>();

    public static List<Project> getProjectList() {
        return projectList;
    }

    public static void setProjectList(List<Project> projectList) {
        Data.projectList = projectList;
    }

    public static Map<Project, List<Task>> getTaskMap() {
        return taskMap;
    }

    public static void setTaskMap(Map<Project, List<Task>> taskMap) {
        Data.taskMap = taskMap;
    }
}
