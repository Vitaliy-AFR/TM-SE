package org.example.commands;

import org.example.TerminalLogic;

public class CreateTaskCommand implements Commands{
    @Override
    public String nameOfCommand() {
        return "create task";
    }

    @Override
    public String description() {
        return "Создать задачу";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {

    }
}
