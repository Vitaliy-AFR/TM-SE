package org.example.commands;

import org.example.TerminalLogic;

public class GetTaskCommand implements Commands {
    @Override
    public String nameOfCommand() {
        return "get task";
    }

    @Override
    public String description() {
        return "Показать задачу";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {

    }
}
