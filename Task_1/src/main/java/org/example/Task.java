package org.example;

import lombok.*;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

@Data
@Builder
public class Task {
    private final long id;
    private final long projectId;
    private String name;
    String description;
    private final GregorianCalendar startDate = new GregorianCalendar();
    private GregorianCalendar endDate;

    @Override
    public String toString() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Task{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", name='" + name + '\'' +
                (description != null ? ", description='" + description + '\'' : "") +
                ", startDate=" + formater.format(startDate.getTime()) +
                (endDate != null ? ", endDate=" + formater.format(endDate.getTime()) : "") +
                '}';
    }
}
