package org.example;

import lombok.Data;
import org.example.commands.*;

import java.util.*;

@Data
public class TerminalLogic {


    private final Map<String, Commands> commands = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final TaskRepository taskRepository = new TaskRepository();

    //Сообщения
    private final String NONE_PROJECT = "Ни одного проекта еще не создано";
    private final String INCORRECT_NUMBER_ENTERED = "Введено некорректное число";
    private final String ENTER_NEW_COMMAND = "\nВведите новую команду";
    private final String INVALID_COMMAND = "Введена некорректная команда";
    private final String PROJECT_NOT_EXIST = "Проект с таким номером еще не создан";
    private final String NONE_TASK = "Ни одна задача еще не создана";
    private final String TASK_NOT_EXIST = "Задача с именем %s не существует";


    public TerminalLogic() {
        commands.put(new ExitCommand().nameOfCommand(), new ExitCommand());
        commands.put(new HelpCommand().nameOfCommand(), new HelpCommand());
        commands.put(new CreateProjectCommand().nameOfCommand(), new CreateProjectCommand());
        commands.put(new GetAllProjectsCommand().nameOfCommand(), new GetAllProjectsCommand());
        commands.put(new GetProjectCommand().nameOfCommand(), new GetProjectCommand());
        commands.put(new UpdateProjectCommand().nameOfCommand(), new UpdateProjectCommand());
        commands.put(new DeleteProjectCommand().nameOfCommand(), new DeleteProjectCommand());
        commands.put(new CreateTaskCommand().nameOfCommand(), new CreateTaskCommand());
        commands.put(new GetAllTasksCommand().nameOfCommand(), new GetAllTasksCommand());
        commands.put(new GetAllProjectTasksCommand().nameOfCommand(), new GetAllProjectTasksCommand());
        commands.put(new GetTaskCommand().nameOfCommand(), new GetTaskCommand());
        commands.put(new UpdateTaskCommand().nameOfCommand(), new UpdateTaskCommand());
        commands.put(new DeleteTaskCommand().nameOfCommand(), new DeleteTaskCommand());

    }

    protected void commandProcessing() {

        System.out.println("Привет, пользователь! \nВведи команду");
        while (true) {
            String command = scanner.nextLine();
            if (!commands.containsKey(command)) {
                System.out.println(INVALID_COMMAND);
            } else {
                commands.get(command.toLowerCase()).execute(this);
            }
            System.out.println(ENTER_NEW_COMMAND);

        }
    }
}
