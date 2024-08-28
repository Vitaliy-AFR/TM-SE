package org.example;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Task {
    private final long id;
    private String name;
    String description;
    private final Date startDate = new Date();
    @ToString.Exclude private final Date endDate;
    private final long projectId;

}
