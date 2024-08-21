package org.example;

import lombok.*;

import java.util.List;

@Data
@Builder
public class Task {
    private String name;
    @ToString.Exclude
    String description;
    private final int number;
    @ToString.Exclude
    private final int numberOfProject;

}
