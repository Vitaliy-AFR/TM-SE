package org.example;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Task {
    private String name;
    private String description;
    private final int number;
    Project project;

    public Task(String name, int number) {
        this.name = name;
        this.number = number;
    }

}
