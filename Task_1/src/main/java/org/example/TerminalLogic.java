package org.example;

import org.example.commands.Commands;
import org.example.repository.CommandRepository;

import java.util.Map;

public class TerminalLogic {

    private LineReader reader = LineReader.getInstance();
    private CommandRepository commandRepository = new CommandRepository();


    //Сообщения
    private final String ENTER_NEW_COMMAND = "\nВведите новую команду";
    private final String INVALID_COMMAND = "Введена некорректная команда";
    private final String HELLO_COMMAND = "Привет, пользователь! \nВведи команду";


    protected void commandProcessing() {
        Map<String, Commands> commands = commandRepository.getCommands();
        System.out.println(HELLO_COMMAND);
        while (true) {
            String command = reader.readString();
            if (!commands.containsKey(command)) {
                System.out.println(INVALID_COMMAND);
            } else {
                commands.get(command.toLowerCase()).execute();
            }
            System.out.println(ENTER_NEW_COMMAND);

        }
    }
}
