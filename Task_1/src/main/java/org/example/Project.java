package org.example;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Project {
    private String name;
    private String description;
    private final int number;
    @ToString.Exclude private final List<Task> tasks = new ArrayList<>();
}
