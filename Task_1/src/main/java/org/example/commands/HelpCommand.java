package org.example.commands;

import org.example.TerminalLogic;

import java.util.Map;

public class HelpCommand implements Commands{
    @Override
    public String description() {
        return "Вызов справки";
    }

    @Override
    public String nameOfCommand() {
        return "help";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {
        Map<String, Commands> commands = terminalLogic.getCommands();
        System.out.println("Список команд:");
        for (Map.Entry<String, Commands> entry : commands.entrySet()) {
            System.out.println(entry.getValue().nameOfCommand() + " - " + entry.getValue().description());
        }
    }
}
