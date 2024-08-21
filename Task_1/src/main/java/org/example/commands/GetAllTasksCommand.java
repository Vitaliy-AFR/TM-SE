package org.example.commands;

import org.example.TerminalLogic;

public class GetAllTasksCommand implements Commands{
    @Override
    public String nameOfCommand() {
        return "get all task";
    }

    @Override
    public String description() {
        return "Показать список всех задач";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {

    }
}
