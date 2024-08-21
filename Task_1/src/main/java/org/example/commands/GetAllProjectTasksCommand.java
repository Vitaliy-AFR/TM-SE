package org.example.commands;

import org.example.TerminalLogic;

public class GetAllProjectTasksCommand implements Commands{
    @Override
    public String nameOfCommand() {
        return "get all project tasks";
    }

    @Override
    public String description() {
        return "Показать список всех задач проекта";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {

    }
}
