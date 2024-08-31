package org.example.commands;

import org.example.repository.CommandRepository;

public class HelpCommand extends Commands{

    @Override
    public String description() {
        return "Вызов справки";
    }

    @Override
    public String nameOfCommand() {
        return "help";
    }

    @Override
    public void execute() {
        CommandRepository commandRepository = new CommandRepository();
        commandRepository.getAllCommands();

    }
}
