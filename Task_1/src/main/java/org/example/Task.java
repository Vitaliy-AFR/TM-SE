package org.example;

import lombok.*;

import java.util.List;

@Data
@Builder
public class Task {
    private String name;
    String description;
    private final int number;
    private final int numberOfProject;

}
