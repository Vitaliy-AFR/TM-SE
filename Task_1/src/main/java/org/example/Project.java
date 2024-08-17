package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Project {
    @ToString.Include
    private String name;
    private String description;
    @ToString.Include
    private int number;
    List<Task> tasks;

    public Project(String name, int number) {
        this.name = name;
        this.number = number;
    }

}
