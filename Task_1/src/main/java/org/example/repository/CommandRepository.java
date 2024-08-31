package org.example.repository;

import lombok.Data;
import org.example.commands.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class CommandRepository {

    private final Map<String, Commands> commands = new LinkedHashMap<>();

    public CommandRepository() {
        commands.put(new ExitCommand().nameOfCommand(), new ExitCommand());
        commands.put(new HelpCommand().nameOfCommand(), new HelpCommand());
        commands.put(new CreateProjectCommand().nameOfCommand(), new CreateProjectCommand());
        commands.put(new GetProjectCommand().nameOfCommand(), new GetProjectCommand());
        commands.put(new GetAllProjectsCommand().nameOfCommand(), new GetAllProjectsCommand());
        commands.put(new UpdateProjectCommand().nameOfCommand(), new UpdateProjectCommand());
        commands.put(new DeleteProjectCommand().nameOfCommand(), new DeleteProjectCommand());
        commands.put(new DeleteAllProjectsCommand().nameOfCommand(), new DeleteAllProjectsCommand());
        commands.put(new CreateTaskCommand().nameOfCommand(), new CreateTaskCommand());
        commands.put(new GetTaskCommand().nameOfCommand(), new GetTaskCommand());
        commands.put(new GetAllTasksCommand().nameOfCommand(), new GetAllTasksCommand());
        commands.put(new GetAllTasksForProjectCommand().nameOfCommand(), new GetAllTasksForProjectCommand());
        commands.put(new UpdateTaskCommand().nameOfCommand(), new UpdateTaskCommand());
        commands.put(new DeleteTaskCommand().nameOfCommand(), new DeleteTaskCommand());
        commands.put(new DeleteAllTasksCommand().nameOfCommand(), new DeleteAllTasksCommand());
        commands.put(new DeleteAllTasksForProjectCommand().nameOfCommand(), new DeleteAllTasksForProjectCommand());
    }

    public void getAllCommands() {
        System.out.println("Список команд:");
        for (Map.Entry<String, Commands> entry : commands.entrySet()) {
            System.out.println(entry.getValue().nameOfCommand() + " - " + entry.getValue().description());
        }
    }
}
