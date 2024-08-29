package org.example;

import lombok.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class Project {
    private final long id;
    private String name;
    private String description;
    private final GregorianCalendar startDate = new GregorianCalendar();
    private GregorianCalendar endDate;
    private final Map<Long, Task> tasks = new HashMap<>();

    @Override
    public String toString() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                (description != null ? ", description='" + description + '\'' : "") +
                ", startDate=" + formater.format(startDate.getTime()) +
                 (endDate != null ? ", endDate=" + formater.format(endDate.getTime()) : "") +
                '}';
    }


}
