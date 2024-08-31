package org.example;

import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Data
@Builder
public class Project {
    private final long id;
    private String name;
    private String description;
    private final LocalDateTime startDate = LocalDateTime.now();
    private LocalDateTime endDate;
    private final Map<Long, Task> tasks = new HashMap<>();

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                (description != null ? ", description='" + description + '\'' : "") +
                ", startDate=" + formatter.format(startDate) +
                 (endDate != null ? ", endDate=" + formatter.format(endDate) : "") +
                '}';
    }


}
