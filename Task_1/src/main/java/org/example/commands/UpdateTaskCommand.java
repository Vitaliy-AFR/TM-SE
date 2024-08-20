package org.example.commands;

import org.example.TerminalLogic;

public class UpdateTaskCommand implements Commands{
    @Override
    public String nameOfCommand() {
        return "update task";
    }

    @Override
    public String description() {
        return "Изменить задачу";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {

    }
}
