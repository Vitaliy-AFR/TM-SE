package org.example;

public class Project {
    private String name;
    private String description;
    private int number;

    public Project(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
