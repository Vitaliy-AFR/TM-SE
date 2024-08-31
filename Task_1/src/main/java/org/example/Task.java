package org.example;

import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.GregorianCalendar;
import java.util.Locale;

@Data
@Builder
public class Task {
    private final long id;
    private final long projectId;
    private String name;
    private String description;
    private final LocalDateTime startDate = LocalDateTime.now();
    private LocalDateTime endDate;

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        return "Task{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", name='" + name + '\'' +
                (description != null ? ", description='" + description + '\'' : "") +
                ", startDate=" + formatter.format(startDate) +
                (endDate != null ? ", endDate=" + formatter.format(endDate) : "") +
                '}';
    }
}
